package com.testefinch.lanchonete.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testefinch.lanchonete.model.VendaPromocao;
import com.testefinch.lanchonete.services.VendaPromocaoService;

@RestController
@RequestMapping("/vendaPromocao")
public class VendaPromocaoController {

	private VendaPromocaoService vendaPromocaoService;
	
	@GetMapping("/vendaPromocao/lista")
	public String getAll(Model model){
		List<VendaPromocao> vendaPromocao = vendaPromocaoService.getAllVendaPromocao();
		model.addAttribute("vendaPromocao", vendaPromocao);
		return "home";
	}
	
	@GetMapping("/vendaPromocao/criar/{id}")
	public String createVendaPromocaoPage(Model model){
			VendaPromocao vendaPromocao = new VendaPromocao();
			model.addAttribute("vendaPromocao", vendaPromocao);
			model.addAttribute("isUpdate", false);
			return "create-update";
	}

    @GetMapping("/vendaPromocao/update/{id}")
    public String updateVendaPromocaoPage(Model model, @PathVariable("id") Integer id) {
    	VendaPromocao vendaPromocao = vendaPromocaoService.getVendaPromocao(id);
    	model.addAttribute("vendaPromocao", vendaPromocao);
    	model.addAttribute("isUpdate", true);
        return "create-update";
    }

    @PostMapping("/vendaPromocao/update/{id}")
    public String createVendaPromocao(@ModelAttribute("vendaPromocao") VendaPromocao vendaPromocao,@PathVariable("id") Integer id) {
       vendaPromocaoService.updateVendaPromocao(vendaPromocao, id);
        return "redirect:/vendaPromocao";
    }

    @PostMapping("/vendaPromocao/criar")
    public String createVendaPromocao(@ModelAttribute("vendaPromocao") VendaPromocao vendaPromocao) {
        vendaPromocaoService.createVendaPromocao(vendaPromocao);
        return "redirect:/vendaPromocao";
    }
	
    @GetMapping("/vendaPromocao/delete/{id}")
    public String deleteVendaPromocao(@PathVariable("id") Integer id) {
    	vendaPromocaoService.deleteVendaPromocao(id);
    	return "redirect:/vendaPromocao";
    }
	
}
