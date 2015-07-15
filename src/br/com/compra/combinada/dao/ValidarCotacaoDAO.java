package br.com.compra.combinada.dao;

import java.util.List;

import br.com.compra.combinada.bean.ValidarCotacao;

public interface ValidarCotacaoDAO {

	public void salvar(ValidarCotacao validarCotacao);
	
	public List<ValidarCotacao> carregar(Integer evento);
	
	public int pesquiarValidacaoCotacao(Integer evento);
}
