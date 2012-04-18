package br.edu.utfpr.app.dto;

import br.edu.utfpr.util.IBean;


public class PedidoDTO implements IBean{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String descricao;

	private ClienteDTO cliente;
	

	private VendedorDTO vendedor;
	
	public PedidoDTO() {
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
	
}
