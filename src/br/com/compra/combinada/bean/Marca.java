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
@Table(name="marca")
public class Marca implements Serializable{

	private static final long serialVersionUID = -5755141584108588138L;
	
	@Id @GeneratedValue
	private int id;
	
	private String nome;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "fabricante_id")
	private Fabricante fabricante;
	
	private Timestamp interacao;
	
	@JsonIgnore
	@OneToMany(mappedBy="marca", cascade={CascadeType.PERSIST})
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

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Timestamp getInteracao() {
		return interacao;
	}

	public void setInteracao(Timestamp interacao) {
		this.interacao = interacao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	

}
