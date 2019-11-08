package br.ucsal.lamis.model;

public class Laboratorio {
	
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private Bloco bloco;
	
	public Laboratorio() {
		
	}

	public Laboratorio(String nome, Bloco bloco) {
		super();
		this.nome = nome;
		this.bloco = bloco;
	}

	public Laboratorio(Integer id, String nome, String descricao, Bloco bloco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.bloco = bloco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Bloco getBloco() {
		return bloco;
	}

	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}
	
	

}
