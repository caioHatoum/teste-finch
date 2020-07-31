package com.testefinch.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testefinch.lanchonete.model.Lanche;

public interface LancheRepository extends JpaRepository<Lanche, Integer> {

}
