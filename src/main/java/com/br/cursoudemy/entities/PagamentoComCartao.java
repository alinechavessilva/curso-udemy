package com.br.cursoudemy.entities;

import javax.persistence.Entity;

import com.br.cursoudemy.entities.enums.StatusPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	private Integer numeroDeParcelas;

	public PagamentoComCartao(Integer numeroDeParcelas) {
		super();
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	public PagamentoComCartao() {}
	

	public PagamentoComCartao(Integer numeroDeParcelas, Integer id, StatusPagamento statusPagamento, Pedido pedido) {
		super(id, statusPagamento, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
}
