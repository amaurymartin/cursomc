package br.com.amaurymartin.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	
	private Integer quantidade;
	private Double preco;
	private Double desconto;
	
	public ItemPedido setPedido(Pedido pedido) {
		this.id.setPedido(pedido);
		return this;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return this.id.getPedido();
	}
	
	public ItemPedido setProduto(Produto produto) {
		this.id.setProduto(produto);
		return this;
	}
	
	public Produto getProduto() {
		return this.id.getProduto();
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public ItemPedido setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
		return this;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public ItemPedido setPreco(Double preco) {
		this.preco = preco;
		return this;
	}
	
	public Double getDesconto() {
		return desconto;
	}
	
	public ItemPedido setDesconto(Double desconto) {
		this.desconto = desconto;
		return this;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
