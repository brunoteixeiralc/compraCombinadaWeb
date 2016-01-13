package br.com.compra.combinada.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="usuario")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Usuario implements Serializable {


	private static final long serialVersionUID = -7781866168853036050L;
	
	@Id @GeneratedValue
	private int id;
	
	private String nome;
	
	private String sexo;
	
	private String dataNascimento;
	
	private String endereco;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Evento> eventos;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuarioConvidante")
	private List<Amizade> amizades;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<RegisterID> registerIDs;

	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Lista> listas;
		
	@JsonIgnore
	@ManyToMany(mappedBy="usuarioConvidados")
	private List<Evento> eventos_convidados;
	
	@JsonIgnore
	@ManyToMany(mappedBy="usuarioFoiConvidados")
	private List<Evento> eventos_foi_convidados;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Local> locais;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Solicitacoes> solicitacoes;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Preferencia> preferencias;
	
	private String email;

	private String login;
	
	private String senha;
	
	private String foto;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Amizade> getAmizades() {
		return amizades;
	}

	public void setAmizades(List<Amizade> amizades) {
		this.amizades = amizades;
	}

	public List<Lista> getListas() {
		return listas;
	}

	public void setListas(List<Lista> listas) {
		this.listas = listas;
	}

	public List<RegisterID> getRegisterIDs() {
		return registerIDs;
	}

	public void setRegisterIDs(List<RegisterID> registerIDs) {
		this.registerIDs = registerIDs;
	}

	public List<Evento> getEventos_convidados() {
		return eventos_convidados;
	}

	public void setEventos_convidados(List<Evento> eventos_convidados) {
		this.eventos_convidados = eventos_convidados;
	}

	public List<Local> getLocais() {
		return locais;
	}

	public void setLocais(List<Local> locais) {
		this.locais = locais;
	}

	public List<Evento> getEventos_foi_convidados() {
		return eventos_foi_convidados;
	}

	public void setEventos_foi_convidados(List<Evento> eventos_foi_convidados) {
		this.eventos_foi_convidados = eventos_foi_convidados;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Solicitacoes> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacoes> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public List<Preferencia> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<Preferencia> preferencias) {
		this.preferencias = preferencias;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
