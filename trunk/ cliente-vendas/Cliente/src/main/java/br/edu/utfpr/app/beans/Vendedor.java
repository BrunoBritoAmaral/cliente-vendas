package br.edu.utfpr.app.beans;

import br.edu.utfpr.util.IBean;

public class Vendedor implements IBean{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	public Vendedor(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
