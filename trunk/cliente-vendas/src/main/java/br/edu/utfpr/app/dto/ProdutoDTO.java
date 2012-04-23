package br.edu.utfpr.app.dto;

import br.edu.utfpr.util.IBean;

public class ProdutoDTO implements IBean {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String descricao;

	private double preco;

	public ProdutoDTO() {
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return this.descricao + " - R$" + this.getPreco();
	}

}
