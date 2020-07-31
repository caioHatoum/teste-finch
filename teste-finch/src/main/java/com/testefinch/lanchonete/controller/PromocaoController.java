package com.testefinch.lanchonete.controller;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.testefinch.lanchonete.model.Promocao;
import com.testefinch.lanchonete.services.PromocaoService;

@RestController
@RequestMapping("/promocao")
public class PromocaoController {

	private PromocaoService promocaoService;
	
	@GetMapping("/promocao/lista")
	public String getAll(Model model){
		List<Promocao> promocoes = promocaoService.getAllPromocao();
		model.addAttribute("promocoes", promocoes);
		return "home";
	}
	
	@GetMapping("/promocao/criar/{id}")
	public String createPromocaoPage(Model model){
			Promocao promocao = new Promocao();
			model.addAttribute("promocao", promocao);
			model.addAttribute("isUpdate", false);
			return "create-update";
	}

    @GetMapping("/promocao/update/{id}")
    public String updatePromocaoPage(Model model, @PathVariable("id") Integer id) {
    	Promocao promocao = promocaoService.getPromocao(id);
    	model.addAttribute("promocao", promocao);
    	model.addAttribute("isUpdate", true);
        return "create-update";
    }

    @PostMapping("/promocao/update/{id}")
    public String createPromocao(@ModelAttribute("promocao") Promocao promocao,@PathVariable("id") Integer id) {
       promocaoService.updatePromocao(promocao, id);
        return "redirect:/promocao";
    }

    @PostMapping("/promocao/criar")
    public String createPromocao(@ModelAttribute("promocao") Promocao promocao) {
        promocaoService.createPromocao(promocao);
        return "redirect:/promocao";
    }
	
    @GetMapping("/promocao/delete/{id}")
    public String deletePromocao(@PathVariable("id") Integer id) {
    	promocaoService.deletePromocao(id);
    	return "redirect:/promocao";
    }
	
}

