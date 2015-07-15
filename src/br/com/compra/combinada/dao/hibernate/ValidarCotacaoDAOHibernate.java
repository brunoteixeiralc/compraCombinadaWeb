package br.com.compra.combinada.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;

import br.com.compra.combinada.bean.ValidarCotacao;
import br.com.compra.combinada.dao.ValidarCotacaoDAO;


public class ValidarCotacaoDAOHibernate implements ValidarCotacaoDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<ValidarCotacao> carregar(Integer evento) {
		
		List<ValidarCotacao> validarCotacoes = new ArrayList<ValidarCotacao>();
		validarCotacoes.addAll((Collection<? extends ValidarCotacao>) this.session.createQuery("select vc from ValidarCotacao vc where vc.evento.id =" + evento).list());
		
		return validarCotacoes;
	}
	
	@Override
	public void salvar(ValidarCotacao validarCotacao) {
		this.session.setFlushMode(FlushMode.ALWAYS);
		this.session.save(validarCotacao);
		
		
	}

	@Override
	public int pesquiarValidacaoCotacao(Integer evento) {
		
		int count  = ((Long)this.session.createQuery("select count(vc) from ValidarCotacao vc where vc.evento.id =" + evento).uniqueResult()).intValue();
		
		return count;
	}

}
