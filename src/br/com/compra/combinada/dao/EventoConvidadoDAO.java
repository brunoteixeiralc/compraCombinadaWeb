package br.com.compra.combinada.dao;

import java.util.List;

import br.com.compra.combinada.bean.EventoConvidado;

public interface EventoConvidadoDAO {
	
	public List<EventoConvidado> carregar(Integer usuario);
}
