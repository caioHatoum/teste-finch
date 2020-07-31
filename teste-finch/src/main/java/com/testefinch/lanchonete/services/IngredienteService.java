package com.testefinch.lanchonete.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testefinch.lanchonete.model.Ingrediente;
import com.testefinch.lanchonete.repository.IngredienteRepository;

@Service
public class IngredienteService {
	private IngredienteRepository ingredienteRepository;
	
	public List<Ingrediente> getAllIngrediente(){
		return ingredienteRepository.findAll();
	}
	public Ingrediente createIngrediente(Ingrediente ingrediente) {
		return ingredienteRepository.save(ingrediente);
	}
	public Ingrediente updateIngrediente(Ingrediente ingrediente, Integer id) {
		Ingrediente ingrediente_ = ingredienteRepository.getOne(id);
		ingrediente_.setNome(ingrediente.getNome());
		return ingredienteRepository.save(ingrediente);
	}
	public String deleteIngrediente(Integer id) {
		ingredienteRepository.deleteById(id);
		return "ingrediente deletado com sucesso";
	}
	public Ingrediente getIngrediente(Integer id) {
		return ingredienteRepository.getOne(id);
	}
}
