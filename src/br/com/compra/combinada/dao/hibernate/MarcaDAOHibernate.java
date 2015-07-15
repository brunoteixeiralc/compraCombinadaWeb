package br.com.compra.combinada.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import br.com.compra.combinada.bean.Marca;
import br.com.compra.combinada.dao.MarcaDAO;


public class MarcaDAOHibernate implements MarcaDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Marca> listar() {
		
		List<Marca> marcas = new ArrayList<Marca>();
		marcas.addAll((Collection<? extends Marca>) this.session.createQuery("select m from Marca m").list());
		
		return marcas;
	}


	
}
