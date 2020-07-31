package com.testefinch.lanchonete.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testefinch.lanchonete.model.IngredienteLanche;
import com.testefinch.lanchonete.repository.IngredienteLancheRepository;

@Service
public class IngredienteLancheService {
	private IngredienteLancheRepository ingredienteLancheRepository;
	
	public List<IngredienteLanche> getAllIngredienteLanche(){
		return ingredienteLancheRepository.findAll();
	}
	public IngredienteLanche createIngredienteLanche(IngredienteLanche ingredienteLanche) {
		return ingredienteLancheRepository.save(ingredienteLanche);
	}
	public IngredienteLanche updateIngredienteLanche(IngredienteLanche ingredienteLanche, Integer id) {
		IngredienteLanche ingredienteLanche_ = ingredienteLancheRepository.getOne(id);
		ingredienteLanche_.setIngrediente(ingredienteLanche.getIngrediente());
		ingredienteLanche_.setQtd_ingrediente(ingredienteLanche.getQtd_ingrediente());
		
		return ingredienteLancheRepository.save(ingredienteLanche);
	}
	public String deleteIngredienteLanche(Integer id) {
		ingredienteLancheRepository.deleteById(id);
		return "ingredienteLanche deletado com sucesso";
	}
	public IngredienteLanche getIngredienteLanche(Integer id) {
		return ingredienteLancheRepository.getOne(id);
	}
}
