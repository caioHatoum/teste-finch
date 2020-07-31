package com.testefinch.lanchonete.model;

import java.sql.Date;
import java.util.List;

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
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="venda")
@Entity
public class Venda {
	@Id
	private int id;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "valor_total")
	private double valor_total;

	@OneToMany(mappedBy = "venda")
	private List<VendaLanche> venda_lanche;
	
	@OneToMany(mappedBy = "venda")
	private List<VendaPromocao> vendas_promocao;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public List<VendaLanche> getVenda_lanche() {
		return venda_lanche;
	}

	public void setVenda_lanche(List<VendaLanche> venda_lanche) {
		this.venda_lanche = venda_lanche;
	}

	public List<VendaPromocao> getVendas_promocao() {
		return vendas_promocao;
	}

	public void setVendas_promocao(List<VendaPromocao> vendas_promocao) {
		this.vendas_promocao = vendas_promocao;
	}

	public int getId() {
		return id;
	}
	
	
	
	
}
