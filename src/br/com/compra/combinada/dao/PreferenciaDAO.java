package br.com.compra.combinada.dao;

import java.util.List;

import br.com.compra.combinada.bean.ProdutoPreferencia;

public interface PreferenciaDAO {

	public List<ProdutoPreferencia> carregar(Integer produtoId, Integer usuarioId);
	
}
