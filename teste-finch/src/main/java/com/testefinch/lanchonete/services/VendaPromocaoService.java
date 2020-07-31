package com.testefinch.lanchonete.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.testefinch.lanchonete.model.IngredienteLanche;
import com.testefinch.lanchonete.model.VendaLanche;
import com.testefinch.lanchonete.model.VendaPromocao;
import com.testefinch.lanchonete.repository.VendaPromocaoRepository;

@Service
public class VendaPromocaoService {
	private VendaPromocaoRepository vendaPromocaoRepository;
	
	public List<VendaPromocao> getAllVendaPromocao(){
		return vendaPromocaoRepository.findAll();
	}
	public VendaPromocao createVendaPromocao(VendaPromocao vendaPromocao) {
		//AQUI SERÁ INTRODUZIDA CONDICAO DA VENDA POSSUIR OU NÃO UMA PROMOCAO PARA APLICAÇÃO DO VALOR DE DESCONTO
		//E POSTERIORMENTE SALVO NO DB
		return vendaPromocaoRepository.save(vendaPromocao);
	}
	public VendaPromocao updateVendaPromocao(VendaPromocao vendaPromocao, Integer id) {
		VendaPromocao vendaPromocao_ = vendaPromocaoRepository.getOne(id);
		//AQUI SERIAM INTRODUZIDAS REGRAS PARA UPDATE DE ALGUMA VENDA PASSADA QUE FOI ENVIADA ERRADO, ETC
		
//		vendaPromocao_.setPromocao();
//		vendaPromocao_.setValor_desconto();
//		vendaPromocao_.setVenda();
		return vendaPromocaoRepository.save(vendaPromocao);
	}
	public String deleteVendaPromocao(Integer id) {
		vendaPromocaoRepository.deleteById(id);
		return "vendaLanche deletado com sucesso";
	}
	public VendaPromocao getVendaPromocao(Integer id) {
		return vendaPromocaoRepository.getOne(id);
	}
}
