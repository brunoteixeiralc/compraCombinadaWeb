
package br.com.compra.combinada.util;

import br.com.compra.combinada.bean.Preferencia;
import br.com.compra.combinada.dao.AmizadeDAO;
import br.com.compra.combinada.dao.ConfiguracaoDAO;
import br.com.compra.combinada.dao.CotacaoDAO;
import br.com.compra.combinada.dao.DivisaoDAO;
import br.com.compra.combinada.dao.EventoConvidadoDAO;
import br.com.compra.combinada.dao.EventoDAO;
import br.com.compra.combinada.dao.FamiliaDAO;
import br.com.compra.combinada.dao.ListaDAO;
import br.com.compra.combinada.dao.ListaProdutoDAO;
import br.com.compra.combinada.dao.MarcaDAO;
import br.com.compra.combinada.dao.PreferenciaDAO;
import br.com.compra.combinada.dao.ProdutoDAO;
import br.com.compra.combinada.dao.SolicitacoesDAO;
import br.com.compra.combinada.dao.ValidarCotacaoDAO;
import br.com.compra.combinada.dao.ListaCotacaoDAO;
import br.com.compra.combinada.dao.UsuarioDAO;
import br.com.compra.combinada.dao.hibernate.AmizadeDAOHibernate;
import br.com.compra.combinada.dao.hibernate.ConfiguracaoDAOHibernate;
import br.com.compra.combinada.dao.hibernate.CotacaoDAOHibernate;
import br.com.compra.combinada.dao.hibernate.DivisaoDAOHibernate;
import br.com.compra.combinada.dao.hibernate.EventoConvidadoDAOHibernate;
import br.com.compra.combinada.dao.hibernate.EventoDAOHibernate;
import br.com.compra.combinada.dao.hibernate.FamiliaDAOHibernate;
import br.com.compra.combinada.dao.hibernate.ListaCotacaoDAOHibernate;
import br.com.compra.combinada.dao.hibernate.ListaDAOHibernate;
import br.com.compra.combinada.dao.hibernate.ListaProdutoCotacaoAuditDAOHibernate;
import br.com.compra.combinada.dao.hibernate.ListaProdutoCotacaoDAOHibernate;
import br.com.compra.combinada.dao.hibernate.ListaProdutoDAOHibernate;
import br.com.compra.combinada.dao.hibernate.MarcaDAOHibernate;
import br.com.compra.combinada.dao.hibernate.PreferenciaDAOHibernate;
import br.com.compra.combinada.dao.hibernate.ProdutoDAOHibernate;
import br.com.compra.combinada.dao.hibernate.SolicitacoesDAOHibernate;
import br.com.compra.combinada.dao.hibernate.UsuarioDAOHibernate;
import br.com.compra.combinada.dao.hibernate.ValidarCotacaoDAOHibernate;


public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAOHibernate = new UsuarioDAOHibernate();
		usuarioDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAOHibernate;
	}
	
	public static ConfiguracaoDAO criarConfiguracaoDAO() {
		ConfiguracaoDAOHibernate configuracaoDAOHibernate = new ConfiguracaoDAOHibernate();
		configuracaoDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return configuracaoDAOHibernate;
	}
	
	public static SolicitacoesDAO criarSolicitacoesDAO() {
		SolicitacoesDAOHibernate solicitacoesDAOHibernate = new SolicitacoesDAOHibernate();
		solicitacoesDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return solicitacoesDAOHibernate;
	}

	public static ListaDAO criarListaDAO() {
		ListaDAOHibernate listaDAOHibernate = new ListaDAOHibernate();
		listaDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return listaDAOHibernate;
	}
	
	public static AmizadeDAO criarAmizadeDAO() {
		AmizadeDAOHibernate amizadeDAOHibernate = new AmizadeDAOHibernate();
		amizadeDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return amizadeDAOHibernate;
	}

	public static ValidarCotacaoDAO criarValidacaoCotacaoDAO() {
		ValidarCotacaoDAOHibernate validarCotacaoDAO = new ValidarCotacaoDAOHibernate();
		validarCotacaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return validarCotacaoDAO;
	}
	
	public static ListaCotacaoDAO criarListaCotacaoDAO() {
		ListaCotacaoDAOHibernate listaDAO = new ListaCotacaoDAOHibernate();
		listaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return listaDAO;
	}
	
	public static ListaProdutoCotacaoDAOHibernate criarListaProdutoCotacaoDAO() {
		ListaProdutoCotacaoDAOHibernate listaProdutoCotacaoDAO = new ListaProdutoCotacaoDAOHibernate();
		listaProdutoCotacaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return listaProdutoCotacaoDAO;
	}
	
	public static ListaProdutoCotacaoAuditDAOHibernate criarListaProdutoCotacaoAuditDAO() {
		ListaProdutoCotacaoAuditDAOHibernate listaProdutoCotacaoAuditDAO = new ListaProdutoCotacaoAuditDAOHibernate();
		listaProdutoCotacaoAuditDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return listaProdutoCotacaoAuditDAO;
	}
	
	public static CotacaoDAO criarCotacaoDAO() {
		CotacaoDAOHibernate cotacaoDAO = new CotacaoDAOHibernate();
		cotacaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return cotacaoDAO;
	}
	
	public static EventoDAO criarEventoDAO() {
		EventoDAOHibernate eventoDAO = new EventoDAOHibernate();
		eventoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return eventoDAO;
	}
	
	public static EventoConvidadoDAO criarEventoConvidadoDAO() {
		EventoConvidadoDAOHibernate eventoConvidadoDAO = new EventoConvidadoDAOHibernate();
		eventoConvidadoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return eventoConvidadoDAO;
	}
	
	public static ProdutoDAO criarProdutoDAO() {
		ProdutoDAOHibernate produtoDAO = new ProdutoDAOHibernate();
		produtoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return produtoDAO;
	}
	
	public static MarcaDAO criarMarcaDAO() {
		MarcaDAOHibernate marcaDAO = new MarcaDAOHibernate();
		marcaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return marcaDAO;
	}
	
	public static FamiliaDAO criarFamiliaDAO() {
		FamiliaDAOHibernate familiaDAO = new FamiliaDAOHibernate();
		familiaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return familiaDAO;
	}
	
	public static DivisaoDAO criarDivisaoDAO() {
		DivisaoDAOHibernate divisaoDAO = new DivisaoDAOHibernate();
		divisaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return divisaoDAO;
	}
	
	public static PreferenciaDAO criarPreferenciaDAO() {
		PreferenciaDAOHibernate preferenciaDAO = new PreferenciaDAOHibernate();
		preferenciaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return preferenciaDAO;
	}
	
	public static ListaProdutoDAO criarListaProdutoDAO() {
		ListaProdutoDAOHibernate listaProdutoDAO = new ListaProdutoDAOHibernate();
		listaProdutoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return listaProdutoDAO;
	}
}