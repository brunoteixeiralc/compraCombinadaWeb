package br.com.compra.combinada.dao;

import java.util.List;

import br.com.compra.combinada.bean.ListaCotacao;

public interface ListaCotacaoDAO {

	public void salvar(ListaCotacao lista);

	public void atualizar(ListaCotacao lista);

	public void excluir(ListaCotacao lista);

	public List<ListaCotacao> listar();
	
	public ListaCotacao carregar(Integer lista);
}
