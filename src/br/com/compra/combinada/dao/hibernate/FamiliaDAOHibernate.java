package br.com.compra.combinada.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import br.com.compra.combinada.bean.Familia;
import br.com.compra.combinada.dao.FamiliaDAO;


public class FamiliaDAOHibernate implements FamiliaDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Familia> listar() {
		
		List<Familia> familias = new ArrayList<Familia>();
		familias.addAll((Collection<? extends Familia>) this.session.createQuery("select f from Familia f").list());
		
		return familias;
	}


	
}
