package br.com.amaurymartin.cursomc.domain;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	private Integer numeroParcelas;
	
	public PagamentoComCartao() {
	}
	
	public PagamentoComCartao(String status, Pedido pedido, Integer numeroParcelas) {
		super(status, pedido);
		this.numeroParcelas = numeroParcelas;
	}
	
	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}
	
	public PagamentoComCartao setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
		return this;
	}
	
}
