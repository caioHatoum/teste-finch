package com.testefinch.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testefinch.lanchonete.model.Ingrediente;
import com.testefinch.lanchonete.model.IngredienteLanche;

public interface IngredienteLancheRepository extends JpaRepository<IngredienteLanche, Integer>{

}
