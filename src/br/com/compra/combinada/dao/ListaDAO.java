package br.com.compra.combinada.dao;

import java.util.List;

import br.com.compra.combinada.bean.Lista;

public interface ListaDAO {
	
	public List<Lista> carregar(Integer usuarioId);
}
