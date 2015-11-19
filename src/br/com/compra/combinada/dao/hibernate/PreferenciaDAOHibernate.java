package br.com.compra.combinada.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import br.com.compra.combinada.bean.ProdutoPreferencia;
import br.com.compra.combinada.dao.PreferenciaDAO;


public class PreferenciaDAOHibernate implements PreferenciaDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProdutoPreferencia> carregar(Integer produtoId, Integer usuarioId) {
		
		List<ProdutoPreferencia> preferencias = new ArrayList<ProdutoPreferencia>();
		preferencias.addAll((Collection<? extends ProdutoPreferencia>) this.session.createQuery("select pp from ProdutoPreferencia as pp "
				+ "inner join pp.preferencia as p "
						+ "where p.produto.id = " + produtoId + "and p.usuario.id = " + usuarioId)
				.list());
		
		return preferencias;
	}

}
