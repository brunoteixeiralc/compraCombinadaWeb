package br.com.compra.combinada.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.compra.combinada.bean.Usuario;
import br.com.compra.combinada.dao.UsuarioDAO;


public class UsuarioDAOHibernate implements UsuarioDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		return this.session.createCriteria(Usuario.class).list();
	}

	@Override
	public void salvar(Usuario usuario) {
		this.session.save(usuario);
		
	}

	@Override
	public void atualizar(Usuario usuario) {
		this.session.update(usuario);
		
	}

	@Override
	public void excluir(Usuario usuario) {
		this.session.delete(usuario);
		
	}

	@Override
	public Usuario carregar(Integer usuario) {
		return (Usuario) this.session.get(Usuario.class, usuario);
	}
	
	@SuppressWarnings("deprecation")
	public Usuario loginUsuario(String login,String senha){

		if (login.contains("@")) {
			return ((Usuario) this.session.createCriteria(Usuario.class)
					.add(org.hibernate.criterion.Expression.eq("email", login))
					.add(org.hibernate.criterion.Expression.eq("senha", senha)).uniqueResult());
		} else {
			return ((Usuario) this.session.createCriteria(Usuario.class)
					.add(org.hibernate.criterion.Expression.eq("login", login))
					.add(org.hibernate.criterion.Expression.eq("senha", senha)).uniqueResult());
		}

	}

}
