package br.com.compra.combinada.dao;

import java.util.List;

import br.com.compra.combinada.bean.Cotacao;

public interface CotacaoDAO {

	public void salvar(Cotacao cotacao);
	
	public List<Cotacao> carregar(Integer evento);
	
	public List<Cotacao> pesquisarCotacao(Integer usuario);
}
