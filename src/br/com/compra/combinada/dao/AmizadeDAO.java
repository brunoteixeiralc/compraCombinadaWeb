package br.com.compra.combinada.dao;

import java.util.List;

import br.com.compra.combinada.bean.Amizade;

public interface AmizadeDAO {

	public void salvar(Amizade amizade);

	public void atualizar(Amizade amizade);

	public void excluir(Amizade amizade);

	public List<Amizade> listar();
	
	public List<Amizade> carregar(Integer usuarioId);
}
