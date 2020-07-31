package com.testefinch.lanchonete.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testefinch.lanchonete.model.Lanche;
import com.testefinch.lanchonete.repository.LancheRepository;

@Service
public class LancheService {
	private LancheRepository lancheRepository;
	
	public List<Lanche> getAllLanche(){
		return lancheRepository.findAll();
	}
	public Lanche createLanche(Lanche lanche) {
		return lancheRepository.save(lanche);
	}
	public Lanche updateLanche(Lanche lanche, Integer id) {
		Lanche lanche_ = lancheRepository.getOne(id);
		lanche_.setNome(lanche.getNome());
		return lancheRepository.save(lanche);
	}
	public String deleteLanche(Integer id) {
		lancheRepository.deleteById(id);
		return "lanche deletado com sucesso";
	}
	public Lanche getLanche(Integer id) {
		return lancheRepository.getOne(id);
	}
}
