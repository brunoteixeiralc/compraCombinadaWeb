package br.com.compra.combinada.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="validar_cotacao")
public class ValidarCotacao implements Serializable {

	private static final long serialVersionUID = 3979241176968145825L;

	@Id @GeneratedValue
	private int id;
	
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setListaCotacao(ListaCotacao listaCotacao) {
		this.listaCotacao = listaCotacao;
	}

	public Local getLocalEscolhido() {
		return localEscolhido;
	}

	public void setLocalEscolhido(Local localEscolhido) {
		this.localEscolhido = localEscolhido;
	}


	

}
