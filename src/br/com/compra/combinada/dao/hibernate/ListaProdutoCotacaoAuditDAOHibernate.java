package br.com.compra.combinada.dao.hibernate;

import org.hibernate.Session;

import br.com.compra.combinada.bean.ListaCotacao;
import br.com.compra.combinada.bean.ListaProdutoCotacao;
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

	@Override
	public void update(ListaProdutoCotacaoAudit listaProdutoCotacaoAudit) {
		this.session.update(listaProdutoCotacaoAudit);
		
		this.session.createQuery("update ListaProdutoCotacaoAudit lps set lps.preco = " + listaProdutoCotacaoAudit.getPreco() + ",lps.quantidade = " + listaProdutoCotacaoAudit.getQuantidade() + 
				"where id = " + listaProdutoCotacaoAudit.getId());
	}

	@Override
	public ListaCotacao carregar(Integer idListaProdutoCotacao) {
		// TODO Auto-generated method stub
		return null;
	}

	


	

}
