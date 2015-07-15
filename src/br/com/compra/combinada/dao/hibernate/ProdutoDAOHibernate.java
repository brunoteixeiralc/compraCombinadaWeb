package br.com.compra.combinada.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import br.com.compra.combinada.bean.Configuracao;
import br.com.compra.combinada.bean.Evento;
import br.com.compra.combinada.bean.Produto;
import br.com.compra.combinada.bean.Usuario;
import br.com.compra.combinada.dao.ProdutoDAO;
import br.com.compra.combinada.dao.UsuarioDAO;


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
		
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.addAll((Collection<? extends Produto>) this.session.createQuery("select p from Produto p where p.ativo = 1").list());
		
		return produtos;
	}

	@Override
	public Produto carregar(Integer produto) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
