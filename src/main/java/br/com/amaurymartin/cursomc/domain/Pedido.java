package br.com.amaurymartin.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_endereco_entrega")
	private Endereco enderecoEntrega;
	
	@OneToMany(mappedBy="id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Integer getId() {
		return id;
	}
	
	public Pedido setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Date getData() {
		return data;
	}
	
	public Pedido setData(Date data) {
		this.data = data;
		return this;
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public Pedido setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
		return this;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Pedido setCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}
	
	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}
	
	public Pedido setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
		return this;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}
	
	public Pedido setItens(Set<ItemPedido> itens) {
		this.itens = itens;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
