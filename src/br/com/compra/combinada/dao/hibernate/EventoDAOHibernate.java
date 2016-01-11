package br.com.compra.combinada.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import br.com.compra.combinada.bean.Evento;
import br.com.compra.combinada.bean.Lista;
import br.com.compra.combinada.bean.ListaProduto;
import br.com.compra.combinada.bean.Produto;
import br.com.compra.combinada.dao.EventoDAO;


public class EventoDAOHibernate implements EventoDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Evento evento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Evento evento) {
		this.session.refresh(evento);
		this.session.merge(evento);
	}

	@Override
	public void excluir(Evento evento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Evento> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> carregar(Integer usuarioId) {
		
		List<Evento> eventos = new ArrayList<Evento>();
		eventos.addAll(
				(Collection<? extends Evento>) this.session
						.createQuery(
								"select e from Evento e  where e.usuario.id =" + usuarioId + "and e.temCotacao = 0")
						.list());
		
		for (Evento evento : eventos) {
			for (Lista lista : evento.getListas()) {
				for (ListaProduto listaProduto : lista.getProdutos()) {
					Produto p = listaProduto.getProduto();
					int count = this.session
							.createQuery("select p.id from Preferencia p where p.produto.id ="
							+ p.getId() + " and p.usuario.id =" + usuarioId).list()
							.size();

					if (count != 0) {
						p.setPreferencia(1);
					}
				}
			}

		}

		return eventos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> carregarFinalizados(Integer usuarioId) {
		List<Evento> eventos = new ArrayList<Evento>();
		eventos.addAll((Collection<? extends Evento>) this.session.createQuery("select e from Evento e where e.usuario.id =" + usuarioId + 
				"and e.temCotacao = 1").list());
		
		return eventos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> carregarProdutosFalta(Integer usuarioId) {
		List<Evento> eventos = new ArrayList<Evento>();
		eventos.addAll(
				(Collection<? extends Evento>) this.session.createQuery("select e from Evento e where e.usuario.id ="
						+ usuarioId + "and e.temCotacao = 1 order by e.interacao DESC").setMaxResults(1).list());

		return eventos;
	}

	
	
}
