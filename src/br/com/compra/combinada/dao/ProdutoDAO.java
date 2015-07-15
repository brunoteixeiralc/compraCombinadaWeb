package br.com.compra.combinada.dao;

import java.util.List;

import br.com.compra.combinada.bean.Produto;

public interface ProdutoDAO {

	public void salvar(Produto produto);

	public void atualizar(Produto produto);

	public void excluir(Produto produto);

	public List<Produto> listar();
	
	public Produto carregar(Integer produto);
}
