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
import org.hibernate.annotations.Type;

@Entity
@Table(name="produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = -4985408733251244070L;
	
	@Id @GeneratedValue
	private int id;
	
	private String nome;
	
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy="produto", cascade={CascadeType.PERSIST})
	private List<ListaProduto> listaProdutos;
	
	@ManyToOne
	@JoinColumn(name = "familia_id")
	private Familia familia;
	
	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;
	
	@ManyToOne
	@JoinColumn(name = "divisao_id")
	private Divisao divisao;

	@Type(type="text")
	private String foto;
	
	private int usuario;
	
	private int preferencia;
	
	private String barras;
	
	private String embalagem;
	
	private Timestamp interacao;
	
	private boolean ativo;
	
	@JsonIgnore
	@OneToMany(mappedBy="produto", cascade={CascadeType.PERSIST})
	private List<ProdutoPreferencia> listProdutoPreferencia;

	@JsonIgnore
	@OneToMany(mappedBy="produto", cascade={CascadeType.PERSIST})
	private List<Preferencia> listPreferencia;

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

	public List<ListaProduto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<ListaProduto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Timestamp getInteracao() {
		return interacao;
	}

	public void setInteracao(Timestamp interacao) {
		this.interacao = interacao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public int getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(int preferencia) {
		this.preferencia = preferencia;
	}

	public String getBarras() {
		return barras;
	}

	public void setBarras(String barras) {
		this.barras = barras;
	}

	public String getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Divisao getDivisao() {
		return divisao;
	}

	public void setDivisao(Divisao divisao) {
		this.divisao = divisao;
	}

	public List<ProdutoPreferencia> getListProdutoPreferencia() {
		return listProdutoPreferencia;
	}

	public void setListProdutoPreferencia(List<ProdutoPreferencia> listProdutoPreferencia) {
		this.listProdutoPreferencia = listProdutoPreferencia;
	}

	public List<Preferencia> getListPreferencia() {
		return listPreferencia;
	}

	public void setListPreferencia(List<Preferencia> listPreferencia) {
		this.listPreferencia = listPreferencia;
	}
	

}
