package br.com.compra.combinada.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import br.com.compra.combinada.bean.Produto;
import br.com.compra.combinada.dao.ProdutoDAO;


public class ProdutoDAOHibernate implements ProdutoDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Produto produto) {
		this.session.save(produto);
		
	}

	@Override
	public void atualizar(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listar() {
		
		List<Produto> pList = new ArrayList<Produto>();
		pList.addAll((Collection<? extends Produto>) this.session.createQuery("select p.id,p.nome,p.descricao,p.foto "
 + ", f.nome, d.nome, f.medida from Produto p "
				+ "inner join p.familia as f "
				+ "inner join p.divisao as d "
				+ "where p.ativo = 1").list());
				
		return pList;
	}

	@Override
	public Produto carregar(Integer produto) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
