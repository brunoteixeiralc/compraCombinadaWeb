package br.com.compra.combinada.dao;

import br.com.compra.combinada.bean.ListaCotacao;
import br.com.compra.combinada.bean.ListaProdutoCotacao;

public interface ListaProdutoCotacaoDAO {

	public void salvar(ListaProdutoCotacao listaProdutoCotacao);
	
	public void update(ListaProdutoCotacao listaProdutoCotacao);
	
	public ListaCotacao carregar(Integer idListaProdutoCotacao);
}
