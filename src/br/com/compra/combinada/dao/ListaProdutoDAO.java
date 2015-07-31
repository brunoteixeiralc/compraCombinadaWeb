package br.com.compra.combinada.dao;

import br.com.compra.combinada.bean.ListaProduto;

public interface ListaProdutoDAO {
	
	public ListaProduto carregar(Integer produtoId, Integer listaId);
	
	public void update(ListaProduto listaProduto);
}
