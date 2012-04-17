package br.edu.utfpr.app.dto;

import java.util.List;

import br.edu.utfpr.util.IBean;

public class PedidoProduto implements IBean{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private List<Produto> produtos;
	
	private Pedido pedido;
	
	private Long quantidade;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}
	
	
}
