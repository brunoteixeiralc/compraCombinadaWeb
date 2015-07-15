package br.com.compra.combinada.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="lista_cotacao")
public class ListaCotacao implements Serializable {

	private static final long serialVersionUID = 5059652272204292787L;

	@Id @GeneratedValue
	private int id;
	
	private String nome;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy="lista", cascade={CascadeType.PERSIST})
	private List<ListaProdutoCotacao> produtos;
	
	@JsonIgnore
	@ManyToMany(mappedBy="listas")
	private List<Evento> eventos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ListaProdutoCotacao> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ListaProdutoCotacao> produtos) {
		this.produtos = produtos;
	}

}
