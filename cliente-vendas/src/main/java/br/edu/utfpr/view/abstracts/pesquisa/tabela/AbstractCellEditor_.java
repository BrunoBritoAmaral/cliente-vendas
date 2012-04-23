package br.edu.utfpr.view.abstracts.pesquisa.tabela;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import br.edu.utfpr.util.IBean;
import br.edu.utfpr.util.TipoCadastro;
import br.edu.utfpr.view.AbstractView;
import br.edu.utfpr.view.abstracts.cadastro.AbstractCadastroView;
import br.edu.utfpr.view.abstracts.pesquisa.AbstractPesquisaView;

public class AbstractCellEditor_<POJO extends IBean,V extends AbstractView<POJO>> extends AbstractCellEditor implements TableCellEditor{

	AbstractCellComponent_<POJO,V> component;
	
	public AbstractCellEditor_(V view, V viewCadastro,TipoCadastro tipoCadastro){
		component = new AbstractCellComponent_<POJO,V>(view, viewCadastro,tipoCadastro);
	}
	
	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		
		POJO pojo = (POJO)value;
		component.updateData(pojo, isSelected, table);
		return component;
	}

}
