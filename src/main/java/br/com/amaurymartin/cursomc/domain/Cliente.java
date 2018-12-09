package br.com.amaurymartin.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.amaurymartin.cursomc.domain.enums.TipoCliente;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String email;
	private String inscricaoFederal;
	private String tipoCliente;
	
	@OneToMany(mappedBy="cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "Telefone")
	private Set<String> telefones = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	
	public Cliente setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Cliente setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Cliente setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getInscricaoFederal() {
		return inscricaoFederal;
	}
	
	public Cliente setInscricaoFederal(String inscricaoFederal) {
		this.inscricaoFederal = inscricaoFederal;
		return this;
	}
	
	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipoCliente);
	}
	
	public Cliente setTipo(TipoCliente tipo) {
		this.tipoCliente = tipo.getCodigo();
		return this;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	public Cliente setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
		return this;
	}
	
	public Set<String> getTelefones() {
		return telefones;
	}

	public Cliente setTelefones(Set<String> telefones) {
		this.telefones = telefones;
		return this;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public Cliente setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
