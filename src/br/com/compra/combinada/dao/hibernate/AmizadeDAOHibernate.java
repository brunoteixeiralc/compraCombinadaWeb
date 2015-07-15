package br.com.compra.combinada.dao.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import br.com.compra.combinada.bean.Amizade;
import br.com.compra.combinada.bean.Evento;
import br.com.compra.combinada.dao.AmizadeDAO;


public class AmizadeDAOHibernate implements AmizadeDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Amizade amizade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Amizade amizade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Amizade amizade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Amizade> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Amizade> carregar(Integer usuarioId) {
		
		List<Amizade> amizades = new ArrayList<Amizade>();
		amizades.addAll((Collection<? extends Amizade>) this.session.createQuery("select a from Amizade a where a.usuarioConvidante.id =" + usuarioId + "and a.statusAceite = 1").list());
		
		return amizades;
	}

	
	
	
}
