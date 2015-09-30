package br.com.compra.combinada.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
@Table(name="evento")
public class Evento implements Serializable {

	private static final long serialVersionUID = 2840287472527978444L;
	
	@Id @GeneratedValue
	private int id;
	
	private String nome;
	
	@Column(name = "data_hora")
	private String dataHora;
	
	@Transient
	private String dataHoraString;
	
	@ManyToMany
    @JoinTable(name="evento_local", 
                joinColumns={@JoinColumn(name="evento_id")}, 
                inverseJoinColumns={@JoinColumn(name="local_id")})
	private List<Local> locais;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
    @JoinTable(name="lista_evento", 
                joinColumns={@JoinColumn(name="evento_id")}, 
                inverseJoinColumns={@JoinColumn(name="lista_id")})
	private List<Lista> listas;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToMany
    @JoinTable(name="evento_usuario_convidado", 
                joinColumns={@JoinColumn(name="evento_id")}, 
                inverseJoinColumns={@JoinColumn(name="usuario_id")})
	private List<Usuario> usuarioConvidados;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="eventos_convidados", 
                joinColumns={@JoinColumn(name="evento_id")}, 
                inverseJoinColumns={@JoinColumn(name="usuario_id")})
	private List<Usuario> usuarioFoiConvidados;
	
	private boolean temCotacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Lista> getListas() {
		return listas;
	}

	public void setListas(List<Lista> listas) {
		this.listas = listas;
	}

	public List<Local> getLocais() {
		return locais;
	}

	public void setLocais(List<Local> locais) {
		this.locais = locais;
	}

	public List<Usuario> getUsuarioConvidados() {
		return usuarioConvidados;
	}

	public void setUsuarioConvidados(List<Usuario> usuarioConvidados) {
		this.usuarioConvidados = usuarioConvidados;
	}

	public List<Usuario> getUsuarioFoiConvidados() {
		return usuarioFoiConvidados;
	}

	public void setUsuarioFoiConvidados(List<Usuario> usuarioFoiConvidados) {
		this.usuarioFoiConvidados = usuarioFoiConvidados;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public boolean isTemCotacao() {
		return temCotacao;
	}

	public void setTemCotacao(boolean temCotacao) {
		this.temCotacao = temCotacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
