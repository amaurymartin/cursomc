package br.com.amaurymartin.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PagamentoComBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVencimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
	}
	
	public PagamentoComBoleto(String status, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(status, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}
	
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public PagamentoComBoleto setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
		return this;
	}
	
	public Date getDataPagamento() {
		return dataPagamento;
	}
	
	public PagamentoComBoleto setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
		return this;
	}
	
}
