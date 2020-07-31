package com.testefinch.lanchonete.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testefinch.lanchonete.model.Ingrediente;
import com.testefinch.lanchonete.model.Venda;
import com.testefinch.lanchonete.repository.VendaRepository;

@Service
public class VendaService {
	private VendaRepository vendaRepository;
	
	public List<Venda> getAllVenda(){
		return vendaRepository.findAll();
	}
	public Venda createVenda(Venda venda) {
		return vendaRepository.save(venda);
	}
	public Venda updateVenda(Venda venda, Integer id) {
		Venda venda_ = vendaRepository.getOne(id);
		venda_.setVenda_lanche(venda.getVenda_lanche());
		venda_.setValor_total(venda.getValor_total());
		venda_.setVendas_promocao(venda.getVendas_promocao());
		return vendaRepository.save(venda);
	}
	public String deleteVenda(Integer id) {
		vendaRepository.deleteById(id);
		return "venda deletado com sucesso";
	}
	public Venda getVenda(Integer id) {
		return vendaRepository.getOne(id);
	}
}

