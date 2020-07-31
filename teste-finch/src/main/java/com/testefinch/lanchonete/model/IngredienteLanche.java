package com.testefinch.lanchonete.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.mapping.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ingrediente_lanche")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngredienteLanche {
	@Id
	private int id_lanche;
	
	@Id
	private int id_ingrediente;
	
	@Column(name = "qtd_ingrediente")
	private int qtd_ingrediente;
	
	@Column(name = "preco_total_ingredientes")
	private double preco_total;
	
	@ManyToOne
	@JoinColumn(name = "id_lanche" , nullable = false)
	public Lanche lanche;
	

	@ManyToOne
	@JoinColumn(name = "id_ingrediente" , nullable = false)
	public Ingrediente ingrediente;


	public int getQtd_ingrediente() {
		return qtd_ingrediente;
	}


	public void setQtd_ingrediente(int qtd_ingrediente) {
		this.qtd_ingrediente = qtd_ingrediente;
	}


	public double getPreco_Total() {
		return preco_total;
	}


	public void setPreco_Total(double preco_total) {
		this.preco_total = preco_total;
	}


	public Lanche getLanche() {
		return lanche;
	}


	public void setLanche(Lanche lanche) {
		this.lanche = lanche;
	}


	public Ingrediente getIngrediente() {
		return ingrediente;
	}


	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}


	public int getId_lanche() {
		return id_lanche;
	}


	public int getId_ingrediente() {
		return id_ingrediente;
	}
	
	

	
	
}
