package br.com.compra.combinada.dao;

import java.util.List;

import br.com.compra.combinada.bean.Evento;

public interface EventoDAO {

	public void salvar(Evento evento);

	public void atualizar(Evento evento);

	public void excluir(Evento evento);

	public List<Evento> listar();
	
	public List<Evento> carregar(Integer usuarioId);
	
	public List<Evento> carregarFinalizados(Integer usuarioId);
	
	public List<Evento> carregarProdutosFalta(Integer usuarioId);

}
