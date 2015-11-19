package br.com.compra.combinada.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="cotacao")
public class Cotacao implements Serializable {

	private static final long serialVersionUID = 3979241176968145825L;

	@Id @GeneratedValue
	private int id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "lista_id")
	private ListaCotacao listaCotacao;
	
	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;
	
	@ManyToOne
	@JoinColumn(name = "local_escolhido_id")
	private Local localEscolhido;

	private Date interacao;

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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public ListaCotacao getListaCotacao() {
		return listaCotacao;
	}

	public void setLista(ListaCotacao lista) {
		this.listaCotacao = lista;
	}

	public Local getLocalEscolhido() {
		return localEscolhido;
	}

	public void setLocalEscolhido(Local localEscolhido) {
		this.localEscolhido = localEscolhido;
	}

	public Date getInteracao() {
		return interacao;
	}

	public void setInteracao(Date interacao) {
		this.interacao = interacao;
	}

}
