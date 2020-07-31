package com.testefinch.lanchonete.controller;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.testefinch.lanchonete.model.Ingrediente;
import com.testefinch.lanchonete.services.IngredienteService;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

	private IngredienteService ingredienteService;
	
	@GetMapping("/ingrediente/lista")
	public String getAll(Model model){
		List<Ingrediente> ingrediente = ingredienteService.getAllIngrediente();
		model.addAttribute("ingrediente", ingrediente);
		return "home";
	}
	
	@GetMapping("/ingrediente/criar/{id}")
	public String createIngredientePage(Model model){
			Ingrediente ingrediente = new Ingrediente();
			model.addAttribute("ingrediente", ingrediente);
			model.addAttribute("isUpdate", false);
			return "create-update";
	}

    @GetMapping("/ingrediente/update/{id}")
    public String updateIngredientePage(Model model, @PathVariable("id") Integer id) {
    	Ingrediente ingrediente = ingredienteService.getIngrediente(id);
    	model.addAttribute("ingrediente", ingrediente);
    	model.addAttribute("isUpdate", true);
        return "create-update";
    }

    @PostMapping("/ingrediente/update/{id}")
    public String createIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente,@PathVariable("id") Integer id) {
       ingredienteService.updateIngrediente(ingrediente, id);
        return "redirect:/ingrediente";
    }

    @PostMapping("/ingrediente/criar")
    public String createIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente) {
        ingredienteService.createIngrediente(ingrediente);
        return "redirect:/ingrediente";
    }
	
    @GetMapping("/ingrediente/delete/{id}")
    public String deleteIngrediente(@PathVariable("id") Integer id) {
    	ingredienteService.deleteIngrediente(id);
    	return "redirect:/ingrediente";
    }
	
}