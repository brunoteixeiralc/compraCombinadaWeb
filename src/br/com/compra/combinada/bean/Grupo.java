package br.com.compra.combinada.bean;

import java.io.Serializable;
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
@Table(name="grupo")
public class Grupo implements Serializable{

	private static final long serialVersionUID = -5755141584108588138L;
	
	@Id @GeneratedValue
	private int id;
	
	private String nome;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "divisao_id")
	private Divisao divisao;
	
	@JsonIgnore
	@OneToMany(mappedBy="grupo", cascade={CascadeType.PERSIST})
	private List<SubGrupo> subGrupos;

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

	public Divisao getDivisao() {
		return divisao;
	}

	public void setDivisao(Divisao divisao) {
		this.divisao = divisao;
	}

	public List<SubGrupo> getSubGrupos() {
		return subGrupos;
	}

	public void setSubGrupos(List<SubGrupo> subGrupos) {
		this.subGrupos = subGrupos;
	}
	
	

}
