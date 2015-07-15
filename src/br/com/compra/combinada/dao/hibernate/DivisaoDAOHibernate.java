package br.com.compra.combinada.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import br.com.compra.combinada.bean.Divisao;
import br.com.compra.combinada.dao.DivisaoDAO;


public class DivisaoDAOHibernate implements DivisaoDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Divisao> listar() {
		
		List<Divisao> divisoes = new ArrayList<Divisao>();
		divisoes.addAll((Collection<? extends Divisao>) this.session.createQuery("select d from Divisao d").list());
		
		return divisoes;
	}


	
}
