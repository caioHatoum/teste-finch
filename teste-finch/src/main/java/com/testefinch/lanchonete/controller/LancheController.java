package com.testefinch.lanchonete.controller;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.testefinch.lanchonete.model.Lanche;
import com.testefinch.lanchonete.services.LancheService;


@RestController
@RequestMapping("/lanche")
public class LancheController {

	private LancheService lancheService;
	
	@GetMapping("/lanche/lista")
	public String getAll(Model model){
		List<Lanche> promocoes = lancheService.getAllLanche();
		model.addAttribute("promocoes", promocoes);
		return "home";
	}
	
	@GetMapping("/lanche/criar/{id}")
	public String createLanchePage(Model model){
			Lanche lanche = new Lanche();
			model.addAttribute("lanche", lanche);
			model.addAttribute("isUpdate", false);
			return "create-update";
	}

    @GetMapping("/lanche/update/{id}")
    public String updateLanchePage(Model model, @PathVariable("id") Integer id) {
    	Lanche lanche = lancheService.getLanche(id);
    	model.addAttribute("lanche", lanche);
    	model.addAttribute("isUpdate", true);
        return "create-update";
    }

    @PostMapping("/lanche/update/{id}")
    public String createLanche(@ModelAttribute("lanche") Lanche lanche,@PathVariable("id") Integer id) {
       lancheService.updateLanche(lanche, id);
        return "redirect:/lanche";
    }

    @PostMapping("/lanche/criar")
    public String createLanche(@ModelAttribute("lanche") Lanche lanche) {
        lancheService.createLanche(lanche);
        return "redirect:/lanche";
    }
	
    @GetMapping("/lanche/delete/{id}")
    public String deleteLanche(@PathVariable("id") Integer id) {
    	lancheService.deleteLanche(id);
    	return "redirect:/lanche";
    }
	
}



