package br.com.compra.combinada.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
@Table(name="eventos_convidados")
public class EventoConvidado implements Serializable {


	private static final long serialVersionUID = 7754161888508097871L;

	@Id @GeneratedValue
	private int id;
	
	@ManyToOne
	private Evento evento;
	
	@JsonIgnore
	@ManyToOne
	private Usuario usuario;

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

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
	
	
	
	
}
