package br.edu.utfpr.view;

import java.util.List;

import br.edu.utfpr.util.IBean;

public interface AbstractView<POJO extends IBean> {
	
	void setLista(List<?> lista);
	
	void atualizaSelecionado(POJO pojo);
	
	void atualizaTabela(POJO pojo);
	
	void dispose();
	
	void excluir(AbstractView<POJO> view);
}
