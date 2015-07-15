package br.com.compra.combinada.dao.hibernate;

import org.hibernate.Session;

import br.com.compra.combinada.bean.Solicitacoes;
import br.com.compra.combinada.dao.SolicitacoesDAO;


public class SolicitacoesDAOHibernate implements SolicitacoesDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Solicitacoes solicitacoes) {
		this.session.save(solicitacoes); 
		
	}

	
	
}
