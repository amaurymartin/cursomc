package br.com.amaurymartin.cursomc.domain.enums;

public enum StatusPagamento {

	PENDENTE("PD", "Pendente"),
	CONFIRMADO("CF", "Confirmado"),
	CANCELADO("CA", "Cancelado");
	
	private String codigo;
	private String descricao;
	
	private StatusPagamento(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static StatusPagamento toEnum(String codigo) {
		if(codigo == null) return null;
		
		for(StatusPagamento s : StatusPagamento.values()) {
			if(s.getCodigo().equals(codigo)) return s;
		}
		
		throw new IllegalArgumentException(String.format("Código de StatusPagamento inválido (%s)", codigo));
	}
}
