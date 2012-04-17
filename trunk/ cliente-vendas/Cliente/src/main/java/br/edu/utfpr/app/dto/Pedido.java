package br.edu.utfpr.app.dto;

import br.edu.utfpr.util.IBean;


public class Pedido implements IBean{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String descricao;

	private Cliente cliente;
	

	private Vendedor vendedor;
	
	public Pedido() {
	}

	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
