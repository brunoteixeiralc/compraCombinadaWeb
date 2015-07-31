package br.com.compra.combinada.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="preferencia_produto")
public class ProdutoPreferencia implements Serializable{

	private static final long serialVersionUID = -4985408733251244070L;
	
	@Id @GeneratedValue
	private int id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "preferencia_id")
	private Preferencia preferencia;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
