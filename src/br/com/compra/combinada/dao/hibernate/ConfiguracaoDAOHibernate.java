package br.com.compra.combinada.dao.hibernate;

import org.hibernate.Session;

import br.com.compra.combinada.bean.Configuracao;
import br.com.compra.combinada.dao.ConfiguracaoDAO;


public class ConfiguracaoDAOHibernate implements ConfiguracaoDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Configuracao listar() {
		return (Configuracao) this.session.createQuery("select c from Configuracao c").uniqueResult();
	}

	@Override
	public void atualizar(Configuracao configuracao) {
		configuracao.setId(1);
		this.session.update(configuracao);
		
	}
	
}
