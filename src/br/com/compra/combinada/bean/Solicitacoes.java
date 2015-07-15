package br.com.compra.combinada.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sugestao_melhorias")
public class Solicitacoes implements Serializable {


	private static final long serialVersionUID = 7448165380545942809L;

	@Id @GeneratedValue
	private int id;
	
	@Column(name = "nome_app")
	private String nomeApp;
	
	@Column(name = "sugestao")
	private String sugestoes;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@Column(name = "interacao")
	private Timestamp interacao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeApp() {
		return nomeApp;
	}

	public void setNomeApp(String nomeApp) {
		this.nomeApp = nomeApp;
	}

	public String getSugestoes() {
		return sugestoes;
	}

	public void setSugestoes(String sugestoes) {
		this.sugestoes = sugestoes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Timestamp getInteracao() {
		return interacao;
	}

	public void setInteracao(Timestamp interacao) {
		this.interacao = interacao;
	}
	
	

	
}
