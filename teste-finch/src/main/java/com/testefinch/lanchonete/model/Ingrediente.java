package com.testefinch.lanchonete.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ingredientes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingrediente {
	@Id
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "preco_ingrediente")
	private double preco;
	
	@OneToMany(mappedBy = "ingrediente")
	private List<IngredienteLanche> ingrediente_lanche;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<IngredienteLanche> getIngrediente_lanche() {
		return ingrediente_lanche;
	}

	public void setIngrediente_lanche(List<IngredienteLanche> ingrediente_lanche) {
		this.ingrediente_lanche = ingrediente_lanche;
	}

	public int getId() {
		return id;
	}
	
	
	
}
