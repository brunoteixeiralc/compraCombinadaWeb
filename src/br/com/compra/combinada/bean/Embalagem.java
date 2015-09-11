package br.com.compra.combinada.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="embalagem")
public class Embalagem {
	
	private static final long serialVersionUID = 4339919602554204031L;

	@Id @GeneratedValue
	@JoinColumn(name="Id")
	private int id;
	
	private String nome;
	
	private String descricao;
	
	private String sigla;
	
	@JsonIgnore
	@OneToMany(mappedBy="embalagem", cascade={CascadeType.PERSIST})
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	

}
