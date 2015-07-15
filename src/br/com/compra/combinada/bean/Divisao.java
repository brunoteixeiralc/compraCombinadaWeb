package br.com.compra.combinada.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="divisao")
public class Divisao implements Serializable {

	private static final long serialVersionUID = -741936693263373118L;

	@Id @GeneratedValue
	private int id;
	
	private String nome;
	
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy="divisao", cascade={CascadeType.PERSIST})
	private List<Grupo> grupos;
	
	@JsonIgnore
	@OneToMany(mappedBy="divisao", cascade={CascadeType.PERSIST})
	private List<Produto> produtos;
	
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

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


}
