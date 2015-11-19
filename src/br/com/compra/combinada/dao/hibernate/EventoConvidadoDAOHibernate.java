package br.com.compra.combinada.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.compra.combinada.bean.EventoConvidado;
import br.com.compra.combinada.bean.Lista;
import br.com.compra.combinada.bean.ListaProduto;
import br.com.compra.combinada.bean.Produto;
import br.com.compra.combinada.dao.EventoConvidadoDAO;


public class EventoConvidadoDAOHibernate implements EventoConvidadoDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventoConvidado> carregar(Integer usuario) {
		
		List<EventoConvidado> eventos = new ArrayList<EventoConvidado>();
		eventos.addAll(this.session.createQuery("select ec from EventoConvidado ec where ec.usuario.id =" + usuario +
				" and ec.evento.temCotacao = 0").list());
		
		for (EventoConvidado evento : eventos) {
			for (Lista lista : evento.getEvento().getListas()) {
				for (ListaProduto listaProduto : lista.getProdutos()) {
					Produto p = listaProduto.getProduto();
					int count = this.session
							.createQuery("select p.id from Preferencia p where p.produto.id =" + p.getId()).list()
							.size();

					if (count != 0) {
						p.setPreferencia(1);
					}
				}
			}

		}

		return eventos;
	}

	
	
	
}
