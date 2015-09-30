package br.com.compra.combinada.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import br.com.compra.combinada.bean.Configuracao;
import br.com.compra.combinada.bean.ListaCotacao;
import br.com.compra.combinada.bean.Produto;
import br.com.compra.combinada.bean.ProdutoPreferencia;
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

	@SuppressWarnings("unchecked")
	@Override
	public ListaCotacao carregar(Integer usuarioId) {
		
		List<ListaCotacao> listaCotacaos = new ArrayList<ListaCotacao>();

		listaCotacaos.addAll((Collection<? extends ListaCotacao>)this.session.createQuery("select lc from ListaCotacao lc where lc.usuario.id = " + usuarioId).list());
		
		return listaCotacaos.get(0);
	}

}
