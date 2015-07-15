package br.com.compra.combinada.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import br.com.compra.combinada.bean.Cotacao;
import br.com.compra.combinada.dao.CotacaoDAO;


public class CotacaoDAOHibernate implements CotacaoDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Cotacao cotacao) {
		this.session.save(cotacao);
		
	}

	@Override
	public List<Cotacao> carregar(Integer evento) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cotacao> pesquisarCotacao(Integer usuario) {
		
		List<Cotacao> cotacoes = new ArrayList<Cotacao>();
		cotacoes.addAll((Collection<? extends Cotacao>) this.session.createQuery("select c from Cotacao c where c.usuario.id =" + usuario).list());
		
		return cotacoes;
	}

	
}
