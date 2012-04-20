package br.edu.utfpr.view.abstracts.pesquisa.tabela;

import java.util.List;

import br.edu.utfpr.app.dto.ClienteDTO;
import br.edu.utfpr.app.dto.ProdutoDTO;
import br.edu.utfpr.app.dto.VendedorDTO;
import br.edu.utfpr.util.IBean;
import br.edu.utfpr.util.TipoCadastro;

public class AbstractTableModel_<POJO extends IBean> extends javax.swing.table.AbstractTableModel{

	Class<POJO> pojo;
	List<POJO> lista;
	
	public AbstractTableModel_(List<POJO> lista,TipoCadastro tipoCadastro){
		this.lista = lista;
		this.pojo = getClazz(tipoCadastro);
	}
	
	public Class getColumnClass(int columnIndex) { return pojo; }
    
	public int getColumnCount() { return 1; }
    
	public String getColumnName(int columnIndex) { return ""; }

	public int getRowCount() { return (lista == null) ? 0 : lista.size(); }
	
	public Object getValueAt(int rowIndex, int columnIndex) { return (lista == null) ? null : lista.get(rowIndex); }
	
	public boolean isCellEditable(int columnIndex, int rowIndex) { return true; }
	
	public Class<POJO> getClazz(TipoCadastro tipoCadastro){
		switch (tipoCadastro) {
		case CLIENTE:
			return (Class<POJO>) new ClienteDTO().getClass();
			
		case VENDEDOR:
			return (Class<POJO>) new VendedorDTO().getClass();
		
		case PRODUTO:
			return (Class<POJO>) new ProdutoDTO().getClass();

		default:
			return null;
		}
	}

}
