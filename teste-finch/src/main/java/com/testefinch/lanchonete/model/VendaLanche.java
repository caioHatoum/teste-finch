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
@Table(name="venda_lanche")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaLanche {
	@Id
	private int id_lanche;
	
	@Id
	private int id_venda;
	
	@Column(name = "valor_lanche")
	private double valor_lanche;
	
	@ManyToOne
	@JoinColumn(name = "id_venda" , nullable = false)
	public Venda venda;
	

	@ManyToOne
	@JoinColumn(name = "id_lanche" , nullable = false)
	public Lanche lanche;


	public double getValor_lanche() {
		return valor_lanche;
	}


	public void setValor_lanche(double valor_lanche) {
		this.valor_lanche = valor_lanche;
	}


	public Venda getVenda() {
		return venda;
	}


	public void setVenda(Venda venda) {
		this.venda = venda;
	}


	public Lanche getLanche() {
		return lanche;
	}


	public void setLanche(Lanche lanche) {
		this.lanche = lanche;
	}


	public int getId_lanche() {
		return id_lanche;
	}


	public int getId_venda() {
		return id_venda;
	}

	
}
