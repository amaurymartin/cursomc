package br.com.amaurymartin.cursomc.domain.enums;

public enum TipoCliente {

	PESSOA_FISICA("PF", "Pessoa Física"),
	PESSOA_JURIDICA("PJ", "Pessoa Jurídica");
	
	private String codigo;
	private String descricao;
	
	private TipoCliente(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(String codigo) {
		if(codigo == null) return null;
		
		for(TipoCliente c : TipoCliente.values()) {
			if(c.getCodigo().equals(codigo)) return c;
		}
		
		throw new IllegalArgumentException(String.format("Código de TipoCliente inválido (%s)", codigo));
	}
}
