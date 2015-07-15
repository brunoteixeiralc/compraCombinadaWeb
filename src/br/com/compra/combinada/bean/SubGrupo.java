package br.com.compra.combinada.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="subgrupo")
public class SubGrupo implements Serializable{

	private static final long serialVersionUID = 192781139008950396L;

	@Id @GeneratedValue
	private int id;
	
	private String nome;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "grupo_id")
	private Grupo grupo;
	
	@JsonIgnore
	@OneToMany(mappedBy="subGrupo", cascade={CascadeType.PERSIST})
	private List<Familia> familias;
	
	private Timestamp interacao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Timestamp getInteracao() {
		return interacao;
	}

	public void setInteracao(Timestamp interacao) {
		this.interacao = interacao;
	}

	public List<Familia> getFamilias() {
		return familias;
	}

	public void setFamilias(List<Familia> familias) {
		this.familias = familias;
	}
	
	
	

}
