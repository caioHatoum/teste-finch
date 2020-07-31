package com.testefinch.lanchonete.controller;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.testefinch.lanchonete.model.Venda;
import com.testefinch.lanchonete.services.VendaService;


@RestController
@RequestMapping("/venda")
public class VendaController {

	private VendaService vendaService;
	
	@GetMapping("/venda/lista")
	public String getAll(Model model){
		List<Venda> promocoes = vendaService.getAllVenda();
		model.addAttribute("promocoes", promocoes);
		return "home";
	}
	
	@GetMapping("/venda/criar/{id}")
	public String createVendaPage(Model model){
			Venda venda = new Venda();
			model.addAttribute("venda", venda);
			model.addAttribute("isUpdate", false);
			return "create-update";
	}

    @GetMapping("/venda/update/{id}")
    public String updateVendaPage(Model model, @PathVariable("id") Integer id) {
    	Venda venda = vendaService.getVenda(id);
    	model.addAttribute("venda", venda);
    	model.addAttribute("isUpdate", true);
        return "create-update";
    }

    @PostMapping("/venda/update/{id}")
    public String createVenda(@ModelAttribute("venda") Venda venda,@PathVariable("id") Integer id) {
       vendaService.updateVenda(venda, id);
        return "redirect:/venda";
    }

    @PostMapping("/venda/criar")
    public String createVenda(@ModelAttribute("venda") Venda venda) {
        vendaService.createVenda(venda);
        return "redirect:/venda";
    }
	
    @GetMapping("/venda/delete/{id}")
    public String deleteVenda(@PathVariable("id") Integer id) {
    	vendaService.deleteVenda(id);
    	return "redirect:/venda";
    }
	
}

