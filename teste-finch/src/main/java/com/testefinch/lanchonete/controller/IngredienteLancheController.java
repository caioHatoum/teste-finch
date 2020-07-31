package com.testefinch.lanchonete.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testefinch.lanchonete.model.IngredienteLanche;
import com.testefinch.lanchonete.services.IngredienteLancheService;

@RestController 
@RequestMapping("/ingredienteLanche")
public class IngredienteLancheController {

	private IngredienteLancheService ingredienteLancheService;
	
	@GetMapping("/ingredienteLanche/lista")
	public String getAll(Model model){
		List<IngredienteLanche> ingredienteLanche = ingredienteLancheService.getAllIngredienteLanche();
		model.addAttribute("ingredienteLanche", ingredienteLanche);
		return "home";
	}
	
	@GetMapping("/ingredienteLanche/criar/{id}")
	public String createIngredienteLanchePage(Model model){
			IngredienteLanche lanche = new IngredienteLanche();
			model.addAttribute("ingredienteLanche", lanche);
			model.addAttribute("isUpdate", false);
			return "create-update";
	}

    @GetMapping("/ingredienteLanche/update/{id}")
    public String updateIngredienteLanchePage(Model model, @PathVariable("id") Integer id) {
    	IngredienteLanche lanche = ingredienteLancheService.getIngredienteLanche(id);
    	model.addAttribute("ingredienteLanche", lanche);
    	model.addAttribute("isUpdate", true);
        return "create-update";
    }

    @PostMapping("/ingredienteLanche/update/{id}")
    public String createIngredienteLanche(@ModelAttribute("ingredienteLanche") IngredienteLanche ingredienteLanche,@PathVariable("id") Integer id) {
    	ingredienteLancheService.updateIngredienteLanche(ingredienteLanche, id);
        return "redirect:/ingredienteLanche";
    }

    @PostMapping("/ingredienteLanche/criar")
    public String createIngredienteLanche(@ModelAttribute("ingredienteLanche") IngredienteLanche ingredienteLanche) {
    	ingredienteLancheService.createIngredienteLanche(ingredienteLanche);
        return "redirect:/ingredienteLanche";
    }
	
    @GetMapping("/ingredienteLanche/delete/{id}")
    public String deleteIngredienteLanche(@PathVariable("id") Integer id) {
    	ingredienteLancheService.deleteIngredienteLanche(id);
    	return "redirect:/ingredienteLanche";
    }
	
}
