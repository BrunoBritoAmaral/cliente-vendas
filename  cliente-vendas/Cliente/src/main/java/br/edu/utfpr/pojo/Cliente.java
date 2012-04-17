package br.edu.utfpr.pojo;

import java.io.Serializable;

public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7477941445460863363L;

	private Long id;
	private String nome;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
 

	public Cliente(String nome) {
		super();
		this.nome = nome;
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
