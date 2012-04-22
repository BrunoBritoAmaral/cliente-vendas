package br.edu.utfpr.view;

import br.edu.utfpr.app.dto.ProdutoDTO;
import br.edu.utfpr.util.IBean;
public interface AbstractView<POJO extends IBean> {
	
	void addLista(ProdutoDTO pojo);
	
	void atualizaSelecionado(POJO pojo);
	
	void atualizaTabela(POJO pojo);
	
	void dispose();
	
	void excluir(AbstractView<POJO> view);
}
