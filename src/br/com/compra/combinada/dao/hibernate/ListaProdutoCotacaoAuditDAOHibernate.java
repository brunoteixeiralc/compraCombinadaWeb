package br.com.compra.combinada.dao.hibernate;

import org.hibernate.Session;

import br.com.compra.combinada.bean.ListaProdutoCotacaoAudit;
import br.com.compra.combinada.dao.ListaProdutoCotacaoAuditDAO;


public class ListaProdutoCotacaoAuditDAOHibernate implements ListaProdutoCotacaoAuditDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(ListaProdutoCotacaoAudit listaProdutoCotacaoAudit) {
		this.session.save(listaProdutoCotacaoAudit);
		
	}

	


	

}
