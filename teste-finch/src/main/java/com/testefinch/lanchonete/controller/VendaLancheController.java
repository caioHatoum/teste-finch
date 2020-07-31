package com.testefinch.lanchonete.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testefinch.lanchonete.model.VendaLanche;
import com.testefinch.lanchonete.services.VendaLancheService;

@RestController
@RequestMapping("/vendaLanche")
public class VendaLancheController {

	private VendaLancheService vendaLancheService;
	
	@GetMapping("/vendaLanche/lista")
	public String getAll(Model model){
		List<VendaLanche> vendaLanche = vendaLancheService.getAllVendaLanche();
		model.addAttribute("vendaLanche", vendaLanche);
		return "home";
	}
	
	@GetMapping("/vendaLanche/criar/{id}")
	public String createVendaLanchePage(Model model){
			VendaLanche vendaLanche = new VendaLanche();
			model.addAttribute("vendaLanche", vendaLanche);
			model.addAttribute("isUpdate", false);
			return "create-update";
	}

    @GetMapping("/vendaLanche/update/{id}")
    public String updateVendaLanchePage(Model model, @PathVariable("id") Integer id) {
    	VendaLanche vendaLanche = vendaLancheService.getVendaLanche(id);
    	model.addAttribute("vendaLanche", vendaLanche);
    	model.addAttribute("isUpdate", true);
        return "create-update";
    }

    @PostMapping("/vendaLanche/update/{id}")
    public String createVendaLanche(@ModelAttribute("vendaLanche") VendaLanche vendaLanche,@PathVariable("id") Integer id) {
       vendaLancheService.updateVendaLanche(vendaLanche, id);
        return "redirect:/vendaLanche";
    }

    @PostMapping("/vendaLanche/criar")
    public String createVendaLanche(@ModelAttribute("vendaLanche") VendaLanche vendaLanche) {
        vendaLancheService.createVendaLanche(vendaLanche);
        return "redirect:/vendaLanche";
    }
	
    @GetMapping("/vendaLanche/delete/{id}")
    public String deleteVendaLanche(@PathVariable("id") Integer id) {
    	vendaLancheService.deleteVendaLanche(id);
    	return "redirect:/vendaLanche";
    }
	
}