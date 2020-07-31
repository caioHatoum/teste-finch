package com.testefinch.lanchonete.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="promocao")
@Entity
public class Promocao {

	@Id
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@ManyToMany(mappedBy = "promocoes")
	private List<Venda> vendas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public int getId() {
		return id;
	}
	
	
}
