package br.com.compra.combinada.dao;

import java.util.List;

import br.com.compra.combinada.bean.Usuario;

public interface UsuarioDAO {

	public void salvar(Usuario usuario);

	public void atualizar(Usuario usuario);

	public void excluir(Usuario usuario);

	public List<Usuario> listar();
	
	public Usuario carregar(Integer usuario);
	
	public Usuario loginUsuario(String login,String senha);
}
