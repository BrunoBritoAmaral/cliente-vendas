package br.edu.utfpr.app.dto;

import java.util.List;

import br.edu.utfpr.util.IBean;

public class PedidoProdutoDTO implements IBean{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private List<ProdutoDTO> produtos;
	
	private PedidoDTO pedido;
	
	private Long quantidade;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}


	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}


	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}

	public PedidoDTO getPedido() {
		return pedido;
	}
	
	
}
