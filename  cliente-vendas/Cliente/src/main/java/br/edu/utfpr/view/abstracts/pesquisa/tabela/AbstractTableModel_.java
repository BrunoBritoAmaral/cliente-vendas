package br.edu.utfpr.view.abstracts.pesquisa.tabela;

import java.util.List;

import br.edu.utfpr.util.IBean;

public class AbstractTableModel_<POJO extends IBean> extends javax.swing.table.AbstractTableModel{

	Class<POJO> pojo;
	List<POJO> lista;
	
	public AbstractTableModel_(List<POJO> lista){
		this.lista = lista;
	}
	
	public Class getColumnClass(int columnIndex) { return pojo; }
    
	public int getColumnCount() { return 1; }
    
	public String getColumnName(int columnIndex) { return ""; }

	public int getRowCount() { return (lista == null) ? 0 : lista.size(); }
	
	public Object getValueAt(int rowIndex, int columnIndex) { return (lista == null) ? null : lista.get(rowIndex); }
	
	public boolean isCellEditable(int columnIndex, int rowIndex) { return true; }

}
