package com.testefinch.lanchonete.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="lanche")
@Entity
@Getter
@Setter
public class Lanche {
	@Id
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@OneToMany(mappedBy = "lanche")
	private List<VendaLanche> venda_lanche;

	@OneToMany(mappedBy = "lanche")
	private List<IngredienteLanche> ingrediente_lanche;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<VendaLanche> getVenda_lanche() {
		return venda_lanche;
	}

	public void setVenda_lanche(List<VendaLanche> venda_lanche) {
		this.venda_lanche = venda_lanche;
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
