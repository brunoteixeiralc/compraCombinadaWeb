package br.com.compra.combinada.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.compra.combinada.bean.Amizade;
import br.com.compra.combinada.bean.Configuracao;
import br.com.compra.combinada.bean.Cotacao;
import br.com.compra.combinada.bean.Divisao;
import br.com.compra.combinada.bean.Evento;
import br.com.compra.combinada.bean.EventoConvidado;
import br.com.compra.combinada.bean.Familia;
import br.com.compra.combinada.bean.Lista;
import br.com.compra.combinada.bean.ListaCotacao;
import br.com.compra.combinada.bean.ListaProdutoCotacao;
import br.com.compra.combinada.bean.ListaProdutoCotacaoAudit;
import br.com.compra.combinada.bean.Marca;
import br.com.compra.combinada.bean.Produto;
import br.com.compra.combinada.bean.ProdutoPreferencia;
import br.com.compra.combinada.bean.Solicitacoes;
import br.com.compra.combinada.bean.Usuario;
import br.com.compra.combinada.bean.ValidarCotacao;
import br.com.compra.combinada.dao.AmizadeDAO;
import br.com.compra.combinada.dao.ConfiguracaoDAO;
import br.com.compra.combinada.dao.CotacaoDAO;
import br.com.compra.combinada.dao.DivisaoDAO;
import br.com.compra.combinada.dao.EventoConvidadoDAO;
import br.com.compra.combinada.dao.EventoDAO;
import br.com.compra.combinada.dao.FamiliaDAO;
import br.com.compra.combinada.dao.ListaCotacaoDAO;
import br.com.compra.combinada.dao.ListaDAO;
import br.com.compra.combinada.dao.ListaProdutoCotacaoAuditDAO;
import br.com.compra.combinada.dao.ListaProdutoCotacaoDAO;
import br.com.compra.combinada.dao.ListaProdutoDAO;
import br.com.compra.combinada.dao.MarcaDAO;
import br.com.compra.combinada.dao.PreferenciaDAO;
import br.com.compra.combinada.dao.ProdutoDAO;
import br.com.compra.combinada.dao.SolicitacoesDAO;
import br.com.compra.combinada.dao.UsuarioDAO;
import br.com.compra.combinada.dao.ValidarCotacaoDAO;
import br.com.compra.combinada.util.DAOFactory;

import com.google.gson.Gson;

@Path("/compracombinada")
public class CompraCombinadaProvider {
	
	private Usuario usuario;
	private UsuarioDAO usuarioDAO;
	private ConfiguracaoDAO configuracaoDAO;
	private SolicitacoesDAO solicitacoesDAO;
	private ValidarCotacao validarCotacao;
	private ValidarCotacaoDAO validarCotacaoDAO;
	private ListaCotacaoDAO listaCotacaoDAO;
	private ListaProdutoCotacaoDAO listaProdutoCotacaoDAO;
	private ListaProdutoCotacaoAuditDAO listaProdutoCotacaoAuditDAO;
	private CotacaoDAO cotacaoDAO;
	private EventoConvidadoDAO eventoConvidadoDAO;
	private EventoDAO eventoDao;
	private AmizadeDAO amizadeDAO;
	private ListaDAO listaDAO;
	private List<ListaProdutoCotacao> listaProdutoCotacaos;
	private List<ListaProdutoCotacao> listaProdutoCotacaosFinal;
	private Map<Integer, List<ListaProdutoCotacao>> mapListaProdutoCotacoes;
	private ProdutoDAO produtoDAO;
	private MarcaDAO marcaDAO;
	private FamiliaDAO familiaDAO;
	private DivisaoDAO divisaoDAO;
	private PreferenciaDAO preferenciaDAO;
	private ListaProdutoDAO listaProdutoDAO;
	private List<Cotacao> cotacoesUsuario;
	private List<EventoConvidado> eventosConvidados;
	private List<Evento> eventos;
	private List<Amizade> amizades;
	private List<Lista> listas;
	private List<Produto> produtos;
	private List<Marca> marcas;
	private List<Familia> familias;
	private List<Divisao> divisoes;
	private List<ValidarCotacao> validarCotacaos;
	private Gson gson;
	private Evento evento;
	private List<ValidarCotacao> cotacaos;
	private List<ListaProdutoCotacao> listaProdutoCotacaoIgual;
	private Configuracao configuracao;
	private Solicitacoes solicitacoes;
	private Produto produto;
	private List<ProdutoPreferencia> preferencias;
	private ListaProdutoCotacao produtoCotacao;
	private ListaProdutoCotacao listaProdutoCotacao;
	private ListaCotacao listaCotacao;

	
	@GET
	@Path("/configuracao")
	@Produces(MediaType.APPLICATION_JSON)
	public Configuracao carregarConfiguracao(){

		this.configuracaoDAO = DAOFactory.criarConfiguracaoDAO();
		
		configuracao = new Configuracao();
		configuracao = configuracaoDAO.listar();
		
		return configuracao;
		
	}
	
	@POST
	@Path("/configuracaoAtualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateConfiguracao(String jsonConfiguracao){
		
		gson = new Gson();
		configuracao = new Configuracao();
		
		configuracao = gson.fromJson(jsonConfiguracao,Configuracao.class);
		
		this.configuracaoDAO = DAOFactory.criarConfiguracaoDAO();
		
		this.configuracaoDAO.atualizar(configuracao);;

		return Response.status(200).entity(configuracao.getServidor()).build();

	}
	
	@POST
	@Path("/solicitacoes")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=ISO-8859-1")
	public Response saveSolicitacoes(String jsonSolicitacoes){
		
		gson = new Gson();
		
		solicitacoes = new Solicitacoes();
		
		//Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		
		solicitacoes = gson.fromJson(jsonSolicitacoes,Solicitacoes.class);
		
		this.solicitacoesDAO = DAOFactory.criarSolicitacoesDAO();
		
		this.solicitacoesDAO.salvar(solicitacoes);

		return Response.status(200).entity("Sugestão enviada com sucesso").build();

	}
	
	@GET
	@Path("/usuario/{login}/{senha}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario carregarUsuario(@PathParam("login") String login, @PathParam("senha")String senha){

		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
		
		usuario = new Usuario();
		usuario = usuarioDAO.loginUsuario(login, senha);

		
		return usuario;
		
	}
	
	@GET
	@Path("/cotacao/{usuarioId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cotacao> carregarCotacaoUsuario(@PathParam("usuarioId") Integer usuarioId){

		this.cotacaoDAO = DAOFactory.criarCotacaoDAO();
		
		cotacoesUsuario = new ArrayList<Cotacao>();
		cotacoesUsuario.addAll(this.cotacaoDAO.pesquisarCotacao(usuarioId));
		
		return cotacoesUsuario;
		
	}
	
	@GET
	@Path("/evento/convidado/{usuarioId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EventoConvidado> carregarEventoConvidado(@PathParam("usuarioId") Integer usuarioId){
		

		this.eventoConvidadoDAO = DAOFactory.criarEventoConvidadoDAO();
		
		eventosConvidados = new ArrayList<EventoConvidado>();
		eventosConvidados.addAll(this.eventoConvidadoDAO.carregar(usuarioId));
		
		
		return eventosConvidados;
		
	}
	
	@GET
	@Path("/evento/{usuarioId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Evento> carregarEventosUsuario(@PathParam("usuarioId") Integer usuarioId){
		

		this.eventoDao = DAOFactory.criarEventoDAO();
		eventos = new ArrayList<Evento>();
		eventos.addAll(this.eventoDao.carregar(usuarioId));

		
		return eventos;
		
	}
	
	@GET
	@Path("/preferencia/{produtoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoPreferencia> carregarPreferenciaProduto(@PathParam("produtoId") Integer produtoId){
		

		this.preferenciaDAO = DAOFactory.criarPreferenciaDAO();
		preferencias = new ArrayList<ProdutoPreferencia>();
		preferencias.addAll(this.preferenciaDAO.carregar(produtoId));

		
		return preferencias;
		
	}
	
	@GET
	@Path("/eventoFinalizado/{usuarioId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Evento> carregarEventosFinalizadosUsuario(@PathParam("usuarioId") Integer usuarioId){
		

		this.eventoDao = DAOFactory.criarEventoDAO();
		eventos = new ArrayList<Evento>();
		eventos.addAll(this.eventoDao.carregarFinalizados(usuarioId));

		return eventos;
		
	}
	
	@GET
	@Path("/amizade/{usuarioId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Amizade> carregarAmizadeUsuario(@PathParam("usuarioId") Integer usuarioId){
		

		this.amizadeDAO = DAOFactory.criarAmizadeDAO();
		
		amizades = new ArrayList<Amizade>();
		amizades.addAll(this.amizadeDAO.carregar(usuarioId));
		
		return amizades;
		
	}
	
	@GET
	@Path("/lista/{usuarioId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lista> carregarListaUsuario(@PathParam("usuarioId") Integer usuarioId){
		

		this.listaDAO = DAOFactory.criarListaDAO();
		
		listas = new ArrayList<Lista>();
		listas.addAll(this.listaDAO.carregar(usuarioId));
		
		
		return listas;
		
	}
	
	@GET
	@Path("/listaCotacaoUsuario/{usuarioId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ListaCotacao carregarListaCotacaoUsuario(@PathParam("usuarioId") Integer usuarioId){
		
		this.listaCotacaoDAO = DAOFactory.criarListaCotacaoDAO();
		
		listaCotacao = new ListaCotacao();
		listaCotacao = this.listaCotacaoDAO.carregar(usuarioId);
		
		return listaCotacao;
		
	}
	
	@GET
	@Path("/listaCotacao/{eventoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ListaProdutoCotacao> carregarListaCotacao(@PathParam("eventoId") Integer eventoId){
		
		listaProdutoCotacaosFinal = new ArrayList<ListaProdutoCotacao>();
		
		this.validarCotacaoDAO = DAOFactory.criarValidacaoCotacaoDAO();
		
		validarCotacaos = new ArrayList<ValidarCotacao>();
		validarCotacaos.addAll(this.validarCotacaoDAO.carregar(eventoId));

		if(validarCotacaos.size()>0){
			HashMap<Integer, ValidarCotacao> c = new HashMap<Integer,ValidarCotacao>();
			
			mapListaProdutoCotacoes = new HashMap<Integer, List<ListaProdutoCotacao>>();
			
			for (int i = 0; i < validarCotacaos.get(0).getEvento().getUsuarioConvidados().size() + 1; i++) {
				
				ValidarCotacao validarCotacao = new ValidarCotacao();
				validarCotacao.setEvento(validarCotacaos.get(i).getEvento());
				validarCotacao.setListaCotacao(validarCotacaos.get(i).getListaCotacao());
				validarCotacao.setUsuario(validarCotacaos.get(i).getUsuario());
				validarCotacao.setLocalEscolhido(validarCotacaos.get(i).getLocalEscolhido());
				
				c.put(i, validarCotacao);
			}
			
			for (Map.Entry<Integer, ValidarCotacao> map : c.entrySet()) {
				
				ValidarCotacao vc1 = new ValidarCotacao();
				vc1 = map.getValue();
				
				for(Map.Entry<Integer, ValidarCotacao> map2 : c.entrySet()){
					
					ValidarCotacao vc2 = new ValidarCotacao();
					vc2 = map2.getValue();
					
					if(map2.getKey() == map.getKey()) continue;
					
					int count = 0;
					
					for (ListaProdutoCotacao lpc : vc1.getListaCotacao().getProdutos()) {
						 
						 if((lpc.getProduto().getId() == vc2.getListaCotacao().getProdutos().get(count).getProduto().getId()) &&
								 lpc.isNaoContem() && vc2.getListaCotacao().getProdutos().get(count).isNaoContem()){
	
							 listaProdutoCotacaos = new ArrayList<ListaProdutoCotacao>();
							 
							 if(mapListaProdutoCotacoes.get(lpc.getProduto().getId()) == null){
								 listaProdutoCotacaos.add(lpc);
								 mapListaProdutoCotacoes.put(lpc.getProduto().getId(),listaProdutoCotacaos);
							 }else{
								 ((List<ListaProdutoCotacao>)mapListaProdutoCotacoes.get(lpc.getProduto().getId())).add(lpc);
							 }
						 }
						
						 count++;
					}
					
				}
	
			}
			
			for(Map.Entry<Integer, List<ListaProdutoCotacao>> entry : mapListaProdutoCotacoes.entrySet()){
			    if(entry.getValue().size() != validarCotacaos.get(0).getEvento().getUsuarioConvidados().size()+1)
			    	mapListaProdutoCotacoes.entrySet().remove(entry.getKey());
			    else
			    	listaProdutoCotacaosFinal.add((ListaProdutoCotacao) entry.getValue().get(0));
			}
		}

		return listaProdutoCotacaosFinal;
		
	}
	
	@GET
	@Path("/obterAllProdutos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> carregarProdutos(){

		this.produtoDAO = DAOFactory.criarProdutoDAO();
		
		produtos = new ArrayList<Produto>();
		produtos.addAll(this.produtoDAO.listar());

		return produtos;
	}
	
	@GET
	@Path("/obterMarca")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Marca> carregarMarcas(){

		this.marcaDAO = DAOFactory.criarMarcaDAO();
		
		marcas = new ArrayList<Marca>();
		marcas.addAll(this.marcaDAO.listar());

		return marcas;
	}
	
	@GET
	@Path("/obterDivisao")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Divisao> carregarDivisoes(){

		this.divisaoDAO = DAOFactory.criarDivisaoDAO();
		
		divisoes = new ArrayList<Divisao>();
		divisoes.addAll(this.divisaoDAO.listar());

		return divisoes;
	}
	
	@GET
	@Path("/obterFamilia")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Familia> carregarFamilia(){

		this.familiaDAO = DAOFactory.criarFamiliaDAO();
		
		familias = new ArrayList<Familia>();
		familias.addAll(this.familiaDAO.listar());

		return familias;
	}
	
	@POST
	@Path("/addProduto")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveProduto(String jsonProduto){
		
		gson = new Gson();
		produto = new Produto();
		
		produto = gson.fromJson(jsonProduto,Produto.class);
		produto.setUsuario(1);
		
		this.produtoDAO = DAOFactory.criarProdutoDAO();
		
		this.produtoDAO.salvar(produto);

		return Response.status(200).entity(produto.getId()).build();

	}
	
	@POST
	@Path("/updateListaProdutoCotacao")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateListaProdutoCotacao(String jsonListaProdutoCotacao){
		
		gson = new Gson();
		produtoCotacao = new ListaProdutoCotacao();
		
		produtoCotacao = gson.fromJson(jsonListaProdutoCotacao,ListaProdutoCotacao.class);
		
		this.listaProdutoCotacaoDAO = DAOFactory.criarListaProdutoCotacaoDAO();
		this.listaProdutoCotacaoAuditDAO = DAOFactory.criarListaProdutoCotacaoAuditDAO();
		
		produtoCotacao.setLista(this.listaProdutoCotacaoDAO.carregar(produtoCotacao.getId()));
		
		this.listaProdutoCotacaoDAO.update(produtoCotacao);
		
		ListaProdutoCotacaoAudit produtoCotacaoAudit = new ListaProdutoCotacaoAudit();
		produtoCotacaoAudit.setId(produtoCotacao.getId());
		produtoCotacaoAudit.setLista(produtoCotacao.getLista());
		produtoCotacaoAudit.setProduto(produtoCotacao.getProduto());
		produtoCotacaoAudit.setQuantidade(produtoCotacao.getQuantidade());
		produtoCotacaoAudit.setNaoContem(produtoCotacao.isNaoContem());
		produtoCotacaoAudit.setDeletou(produtoCotacao.isDeletou());
		produtoCotacaoAudit.setPreco(produtoCotacao.getPreco());
		produtoCotacaoAudit.setPrecoKG(produtoCotacao.getPrecoKG());
		produtoCotacaoAudit.setAdicionado(produtoCotacao.getAdicionado());
		
		this.listaProdutoCotacaoAuditDAO.update(produtoCotacaoAudit);

		return Response.status(200).entity("Produto cotação atualizado com sucesso").build();

	}
	
	@POST
	@Path("/addCotacao")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCotacao(String jsonCotacao){
		
		gson = new Gson();
		validarCotacao = new ValidarCotacao();
		
		validarCotacao = gson.fromJson(jsonCotacao,ValidarCotacao.class);
		validarCotacao.getListaCotacao().setUsuario(validarCotacao.getUsuario());
		
		this.listaCotacaoDAO = DAOFactory.criarListaCotacaoDAO();
		this.listaCotacaoDAO.salvar(validarCotacao.getListaCotacao());
		
		this.listaProdutoCotacaoDAO = DAOFactory.criarListaProdutoCotacaoDAO();
		this.listaProdutoCotacaoAuditDAO = DAOFactory.criarListaProdutoCotacaoAuditDAO();
		
		for (ListaProdutoCotacao lpc : validarCotacao.getListaCotacao().getProdutos()) {
			
			lpc.setLista(validarCotacao.getListaCotacao());
			
			if(lpc.getProduto().getPreferencia() == 1){
				lpc.setProdutoGenerico(lpc.getProduto());
				lpc.setProduto(lpc.getProdutoTempPref());	
			}
			
			//Tabela de Auditoria
			ListaProdutoCotacaoAudit lpcAudit = new ListaProdutoCotacaoAudit();
			lpcAudit.setLista(lpc.getLista());
			lpcAudit.setProduto(lpc.getProduto());
			lpcAudit.setProdutoGenerico(lpc.getProdutoGenerico());
			lpcAudit.setQuantidade(lpc.getQuantidade());
			lpcAudit.setNaoContem(lpc.isNaoContem());
			lpcAudit.setDeletou(lpc.isDeletou());
			lpcAudit.setPreco(lpc.getPreco());
			lpcAudit.setPrecoKG(lpc.getPrecoKG());
			lpcAudit.setAdicionado(lpc.getAdicionado());
			
			this.listaProdutoCotacaoDAO.salvar(lpc);
			this.listaProdutoCotacaoAuditDAO.salvar(lpcAudit);
		}
		
		this.validarCotacaoDAO = DAOFactory.criarValidacaoCotacaoDAO();
		
		this.validarCotacaoDAO.salvar(validarCotacao);

		return Response.status(200).entity(validarCotacao.getId()).build();
		
	}
	
	@POST
	@Path("/addListaProdutoCotacao")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addListaProdutoCotacao(String jsonListaProdutoCotacao){
		
		gson = new Gson();
		
		listaProdutoCotacao = new ListaProdutoCotacao();
		
		listaProdutoCotacao = gson.fromJson(jsonListaProdutoCotacao,ListaProdutoCotacao.class);
		
		this.listaProdutoCotacaoDAO = DAOFactory.criarListaProdutoCotacaoDAO();
		this.listaProdutoCotacaoAuditDAO = DAOFactory.criarListaProdutoCotacaoAuditDAO();
			
			//Tabela de Auditoria
			ListaProdutoCotacaoAudit listaProdutoCotacaoAudit = new ListaProdutoCotacaoAudit();
			listaProdutoCotacaoAudit.setLista(listaProdutoCotacao.getLista());
			listaProdutoCotacaoAudit.setProduto(listaProdutoCotacao.getProduto());
			listaProdutoCotacaoAudit.setQuantidade(listaProdutoCotacao.getQuantidade());
			listaProdutoCotacaoAudit.setNaoContem(listaProdutoCotacao.isNaoContem());
			listaProdutoCotacaoAudit.setDeletou(listaProdutoCotacao.isDeletou());
			listaProdutoCotacaoAudit.setPreco(listaProdutoCotacao.getPreco());
			listaProdutoCotacaoAudit.setPrecoKG(listaProdutoCotacao.getPrecoKG());
			listaProdutoCotacaoAudit.setAdicionado(listaProdutoCotacao.getAdicionado());
			
			this.listaProdutoCotacaoDAO.salvar(listaProdutoCotacao);
			this.listaProdutoCotacaoAuditDAO.salvar(listaProdutoCotacaoAudit);

		return Response.status(200).entity(listaProdutoCotacao.getId()).build();
		
	}
	
	@POST
	@Path("/validarCotacao")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response validarCotacao(String jsonCotacao){
		
		
		gson = new Gson();
		evento = new Evento();
		evento = gson.fromJson(jsonCotacao,Evento.class);
		
		this.validarCotacaoDAO = DAOFactory.criarValidacaoCotacaoDAO();
		
		cotacaos = this.validarCotacaoDAO.carregar(evento.getId());
			
			HashMap<Integer, Cotacao> c = new HashMap<Integer,Cotacao>();
			
			for (int i = 0; i < evento.getUsuarioConvidados().size() + 1; i++) {
				
				Cotacao cotacao = new Cotacao();
				cotacao.setEvento(cotacaos.get(i).getEvento());
				cotacao.setLista(cotacaos.get(i).getListaCotacao());
				cotacao.setUsuario(cotacaos.get(i).getUsuario());
				cotacao.setLocalEscolhido(cotacaos.get(i).getLocalEscolhido());
				
				c.put(i, cotacao);
			}
			
			
			for (Map.Entry<Integer, Cotacao> map : c.entrySet()) {
				
				Cotacao c1 = new Cotacao();
				c1 = map.getValue();
				
				for(Map.Entry<Integer, Cotacao> map2 : c.entrySet()){
					
					Cotacao c2 = new Cotacao();
					c2 = map2.getValue();
					
					if(map2.getKey() == map.getKey()) continue;
					
					int count = 0;
					listaProdutoCotacaoIgual = new ArrayList<ListaProdutoCotacao>();
					
					for (ListaProdutoCotacao lpc : c1.getListaCotacao().getProdutos()) {
						
						if(count  > c2.getListaCotacao().getProdutos().size() - 1){
							count++;
							continue;
						}
							
						 if((lpc.isNaoContem() || c2.getListaCotacao().getProdutos().get(count).isNaoContem()) ||
								 lpc.isDeletou() || c2.getListaCotacao().getProdutos().get(count).isDeletou()){
							 c2.getListaCotacao().getProdutos().get(count).setPreco(0.0f);
							 count++;
							 continue;
						 }
						 
						 if(lpc.getPreco() != 0.0f && c2.getListaCotacao().getProdutos().get(count).getPreco() != 0.0f){
							 
							 int retval = Float.compare(lpc.getPreco(), c2.getListaCotacao().getProdutos().get(count).getPreco());
							 
							 if(retval > 0) {
							        System.out.println("lpc is greater than c2");
							        lpc.setPreco(0.0f);
							     }
							     else if(retval < 0) {
							        System.out.println("lpc is less than c2");
							        c2.getListaCotacao().getProdutos().get(count).setPreco(0.0f);
							     }
							     else {
							    	listaProdutoCotacaoIgual.add(lpc);
							        System.out.println("lpc is equal to c2");
							        
							     }
						 }
						 
						 count++;
					}
					
				}
				
				//break;
			}
			
			//Caso tenha cotação igual.
			if(listaProdutoCotacaoIgual.size() > 0){
				for (ValidarCotacao vc : cotacaos) {
						
					if(!evento.getUsuario().getNome().equalsIgnoreCase(vc.getUsuario().getNome())){
							
						for (ListaProdutoCotacao lpcIgual : listaProdutoCotacaoIgual) {
								
							for (ListaProdutoCotacao lp : vc.getListaCotacao().getProdutos()) {
									
								if(lp.getProduto().getNome().equalsIgnoreCase(lpcIgual.getProduto().getNome())){
									lp.setPreco(0.0f);
									break;
								}
								
							}
						}
					}
				}
			}
			
			
			this.cotacaoDAO = DAOFactory.criarCotacaoDAO();
			
			for (Map.Entry<Integer, Cotacao> mapCotacaoFinal : c.entrySet()) {
				
				this.cotacaoDAO.salvar(mapCotacaoFinal.getValue());
				
			}
			
			this.eventoDao = DAOFactory.criarEventoDAO();
			
			evento.setTemCotacao(true);
			
			this.eventoDao.atualizar(evento);
			

		return Response.status(200).build();
		
	}

}
