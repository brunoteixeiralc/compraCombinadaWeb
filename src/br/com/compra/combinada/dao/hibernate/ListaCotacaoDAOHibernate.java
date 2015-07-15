package br.com.compra.combinada.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.compra.combinada.bean.ListaCotacao;
import br.com.compra.combinada.dao.ListaCotacaoDAO;


public class ListaCotacaoDAOHibernate implements ListaCotacaoDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(ListaCotacao lista) {
		this.session.save(lista);
		
	}

	@Override
	public void atualizar(ListaCotacao lista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(ListaCotacao lista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ListaCotacao> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListaCotacao carregar(Integer lista) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
