package br.com.compra.combinada.dao;

import br.com.compra.combinada.bean.Configuracao;

public interface ConfiguracaoDAO {

	public Configuracao listar();
	
	public void atualizar(Configuracao configuracao);
	
}
