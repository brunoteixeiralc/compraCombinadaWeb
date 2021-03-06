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
@Table(name="lista_produto_cotacao_audit")
public class ListaProdutoCotacaoAudit implements Serializable {


	private static final long serialVersionUID = 7648619609772226580L;
	
	@Id @GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	private int quantidade;
	
	private float preco;
	
	@Column(name = "nao_contem")
	private boolean naoContem;
	
	@Column(name = "deletou_item")
	private boolean deletou;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "lista_id")
	private ListaCotacao lista;

	@Column(name = "preco_kg")
	private float precoKG;
	
	private String adicionado;
	
	@ManyToOne
	@JoinColumn(name = "produto_generico_id")
	private Produto produtoGenerico;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public ListaCotacao getLista() {
		return lista;
	}

	public void setLista(ListaCotacao lista) {
		this.lista = lista;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean isNaoContem() {
		return naoContem;
	}

	public void setNaoContem(boolean naoContem) {
		this.naoContem = naoContem;
	}

	public boolean isDeletou() {
		return deletou;
	}

	public void setDeletou(boolean deletou) {
		this.deletou = deletou;
	}
	
	public float getPrecoKG() {
		return precoKG;
	}

	public void setPrecoKG(float precoKG) {
		this.precoKG = precoKG;
	}

	public String getAdicionado() {
		return adicionado;
	}

	public void setAdicionado(String adicionado) {
		this.adicionado = adicionado;
	}

	public Produto getProdutoGenerico() {
		return produtoGenerico;
	}

	public void setProdutoGenerico(Produto produtoGenerico) {
		this.produtoGenerico = produtoGenerico;
	}

	
	

}
