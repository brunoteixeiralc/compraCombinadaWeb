package br.com.compra.combinada.dao.hibernate;

import org.hibernate.Session;

import br.com.compra.combinada.bean.ListaProduto;
import br.com.compra.combinada.dao.ListaProdutoDAO;


public class ListaProdutoDAOHibernate implements ListaProdutoDAO {

	private Session	session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public ListaProduto carregar(Integer produtoId, Integer listaId) {
		
		ListaProduto lp = new ListaProduto();
		lp = (ListaProduto) this.session.createQuery("select lp from ListaProduto lp where l.lista.id =" + listaId + " and " + "lp.produto.id =" + produtoId);
		
		return lp;
	}

	@Override
	public void update(ListaProduto listaProduto) {
		this.session.update(listaProduto);
	}

}
