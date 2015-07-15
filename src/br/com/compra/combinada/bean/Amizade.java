package br.com.compra.combinada.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="amizade")
public class Amizade implements Serializable {

	private static final long serialVersionUID = -5826231070802564993L;
	
	@Id @GeneratedValue
	private int id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_convidante")
	private Usuario usuarioConvidante;
	
	@ManyToOne
	@JoinColumn(name = "usuario_convidado")
	private Usuario usuarioConvidado;
	
	@Column(name = "status_aceite")
	private boolean statusAceite;

	public Usuario getUsuarioConvidante() {
		return usuarioConvidante;
	}

	public void setUsuarioConvidante(Usuario usuarioConvidante) {
		this.usuarioConvidante = usuarioConvidante;
	}

	public Usuario getUsuarioConvidado() {
		return usuarioConvidado;
	}

	public void setUsuarioConvidado(Usuario usuarioConvidado) {
		this.usuarioConvidado = usuarioConvidado;
	}

	public boolean isStatusAceite() {
		return statusAceite;
	}

	public void setStatusAceite(boolean statusAceite) {
		this.statusAceite = statusAceite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
