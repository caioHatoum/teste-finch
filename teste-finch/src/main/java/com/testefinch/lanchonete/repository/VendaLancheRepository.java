package com.testefinch.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testefinch.lanchonete.model.Ingrediente;
import com.testefinch.lanchonete.model.IngredienteLanche;
import com.testefinch.lanchonete.model.VendaLanche;

public interface VendaLancheRepository extends JpaRepository<VendaLanche, Integer>{

}
