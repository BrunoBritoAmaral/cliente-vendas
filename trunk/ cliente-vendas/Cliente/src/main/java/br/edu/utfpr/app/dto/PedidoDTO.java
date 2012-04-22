package br.edu.utfpr.app.dto;

import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.util.IBean;


public class PedidoDTO implements IBean{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String descricao;

	private ClienteDTO cliente;
	
	private List<ProdutoDTO> produtos;

	private VendedorDTO vendedor;
	
	public PedidoDTO() {
		produtos = new ArrayList<ProdutoDTO>();
	}

	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setVendedor(VendedorDTO vendedor) {
		this.vendedor = vendedor;
	}

	public VendedorDTO getVendedor() {
		return vendedor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void add(ProdutoDTO p){
		if(!produtos.contains(p))
			produtos.add(p);
	}
	
	public void remove(ProdutoDTO p){
		if(produtos.contains(p))
			produtos.remove(p);
	}
	
	public List<ProdutoDTO> getProdutos(){
		return produtos;
	}
	
	public void setProdutos(List<ProdutoDTO> produtos){
		this.produtos = produtos;
	}
	
}
