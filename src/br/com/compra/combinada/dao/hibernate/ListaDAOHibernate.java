package br.com.compra.combinada.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import br.com.compra.combinada.bean.Lista;
import br.com.compra.combinada.dao.ListaDAO;


public class ListaDAOHibernate implements ListaDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lista> carregar(Integer usuarioId) {
		List<Lista> listas = new ArrayList<Lista>();
		listas.addAll((Collection<? extends Lista>) this.session.createQuery("select l from Lista l where l.usuario.id =" + usuarioId).list());
		
		return listas;
	}



	
	
	
}
