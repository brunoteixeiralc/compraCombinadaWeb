package br.com.compra.combinada.dao.hibernate;

import org.hibernate.Session;

import br.com.compra.combinada.bean.ListaProdutoCotacao;
import br.com.compra.combinada.dao.ListaProdutoCotacaoDAO;


public class ListaProdutoCotacaoDAOHibernate implements ListaProdutoCotacaoDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(ListaProdutoCotacao listaProdutoCotacao) {
		this.session.save(listaProdutoCotacao);
		
	}

	


	

}
