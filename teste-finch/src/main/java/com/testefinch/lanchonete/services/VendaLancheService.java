package com.testefinch.lanchonete.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.testefinch.lanchonete.model.IngredienteLanche;
import com.testefinch.lanchonete.model.VendaLanche;
import com.testefinch.lanchonete.model.VendaPromocao;
import com.testefinch.lanchonete.repository.VendaLancheRepository;

@Service
public class VendaLancheService {
	private VendaLancheRepository vendaLancheRepository;
	
	public List<VendaLanche> getAllVendaLanche(){
		return vendaLancheRepository.findAll();
	}
	public VendaLanche createVendaLanche(VendaLanche vendaLanche) {
		double valor_total = vendaLanche
				.getLanche()
				.getIngrediente_lanche()
				.stream()
				.map(IngredienteLanche::getPreco_Total)
				.collect(Collectors.toList())
				.stream()
				.reduce((double) 0, (a,b)->a+b);
		
		double valor_desconto = vendaLanche
				.getVenda()
				.getVendas_promocao()
				.stream()
				.map(VendaPromocao::getValor_desconto)
				.collect(Collectors.toList())
				.stream()
				.reduce((double)0,(a,b)->a+b);
		
		vendaLanche.setValor_lanche(valor_total-valor_desconto);
		return vendaLancheRepository.save(vendaLanche);
	}
	public VendaLanche updateVendaLanche(VendaLanche vendaLanche, Integer id) {
		VendaLanche vendaLanche_ = vendaLancheRepository.getOne(id);
		double valor_total = vendaLanche
				.getLanche()
				.getIngrediente_lanche()
				.stream()
				.map(IngredienteLanche::getPreco_Total)
				.collect(Collectors.toList())
				.stream()
				.reduce((double) 0, (a,b)->a+b);
		
		double valor_desconto = vendaLanche
				.getVenda()
				.getVendas_promocao()
				.stream()
				.map(VendaPromocao::getValor_desconto)
				.collect(Collectors.toList())
				.stream()
				.reduce((double)0,(a,b)->a+b);
		
		vendaLanche_.setLanche(vendaLanche.getLanche());
		vendaLanche_.setValor_lanche(valor_total-valor_desconto);
		vendaLanche_.setVenda(vendaLanche.getVenda());
		return vendaLancheRepository.save(vendaLanche);
	}
	public String deleteVendaLanche(Integer id) {
		vendaLancheRepository.deleteById(id);
		return "vendaLanche deletado com sucesso";
	}
	public VendaLanche getVendaLanche(Integer id) {
		return vendaLancheRepository.getOne(id);
	}
}
