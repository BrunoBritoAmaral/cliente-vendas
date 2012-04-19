package br.edu.utfpr.view.abstracts.pesquisa.tabela;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import br.edu.utfpr.util.IBean;
import br.edu.utfpr.util.TipoCadastro;
import br.edu.utfpr.view.abstracts.pesquisa.AbstractPesquisaView;

public class AbstractCellRenderer_<POJO extends IBean> implements TableCellRenderer{
	
	AbstractCellComponent_<POJO> abstractComponent;
	POJO pojo;
	
	public AbstractCellRenderer_(AbstractPesquisaView<POJO> view,TipoCadastro tipoCadastro){
		abstractComponent = new AbstractCellComponent_<POJO>(view, tipoCadastro);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		pojo = (POJO) value;
		abstractComponent.updateData(pojo, isSelected, table);
		return abstractComponent;
	}

}
