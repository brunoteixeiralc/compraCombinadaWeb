package br.com.compra.combinada.dao.hibernate;

import java.util.Collection;

import org.hibernate.Session;

import br.com.compra.combinada.bean.Lista;
import br.com.compra.combinada.bean.ListaCotacao;
import br.com.compra.combinada.bean.ListaProdutoCotacao;
import br.com.compra.combinada.bean.ProdutoPreferencia;
import br.com.compra.combinada.dao.ListaProdutoCotacaoDAO;


public class ListaProdutoCotacaoDAOHibernate implements ListaProdutoCotacaoDAO {

	private Session	session;
	private ListaCotacao listaProdutoCotacao;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(ListaProdutoCotacao listaProdutoCotacao) {
		this.session.save(listaProdutoCotacao);
		
	}

	@Override
	public void update(ListaProdutoCotacao listaProdutoCotacao) {
		this.session.update(listaProdutoCotacao);

		this.session.createQuery("update ListaProdutoCotacao lps set lps.preco = " + listaProdutoCotacao.getPreco() + ",lps.quantidade = " + listaProdutoCotacao.getQuantidade() + 
				"where id = " + listaProdutoCotacao.getId());
		
	}

	@Override
	public ListaCotacao carregar(Integer idListaProdutoCotacao) {
		
		listaProdutoCotacao = new ListaCotacao();
		
		listaProdutoCotacao = (ListaCotacao)this.session.createQuery("select lps.lista from ListaProdutoCotacao lps "
				+ "inner join lps.lista as l "
				+ "where lps.id = " + idListaProdutoCotacao).uniqueResult();
		
		return listaProdutoCotacao;
		
	}

	


	

}
