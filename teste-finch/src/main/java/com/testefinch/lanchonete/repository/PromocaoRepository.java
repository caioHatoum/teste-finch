package com.testefinch.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testefinch.lanchonete.model.Ingrediente;
import com.testefinch.lanchonete.model.Promocao;

public interface PromocaoRepository extends JpaRepository<Promocao, Integer>{

}
