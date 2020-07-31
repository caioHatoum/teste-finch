package com.testefinch.lanchonete.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.testefinch.lanchonete.model.Venda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="venda_promocao")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaPromocao {
	@Id
	private int id_venda;
	
	@Id
	private int id_promocao;
	
	@Column(name = "valor_desconto")
	private double valor_desconto;

	@ManyToOne
	@JoinColumn(name = "id_promocao" , nullable = false)
	public Promocao promocao;
	

	@ManyToOne
	@JoinColumn(name = "id_venda" , nullable = false)
	public Venda venda;

	public Promocao getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}

	public void setValor_desconto(double valor_desconto) {
		this.valor_desconto = valor_desconto;
	}

	public double getValor_desconto() {
		return valor_desconto;
	}

	public void setValor_desconto(float valor_desconto) {
		this.valor_desconto = valor_desconto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public int getId_venda() {
		return id_venda;
	}

	public int getId_promocao() {
		return id_promocao;
	}
	
	
}
