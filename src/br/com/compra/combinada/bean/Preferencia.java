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
@Table(name="preferencia")
public class Preferencia implements Serializable{


	private static final long serialVersionUID = -7272614139219008756L;

	@Id @GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@JsonIgnore
	@OneToMany(mappedBy="preferencia", cascade={CascadeType.PERSIST})
	private List<ProdutoPreferencia> listProdutoPreferencia;
	
	

	public List<ProdutoPreferencia> getListProdutoPreferencia() {
		return listProdutoPreferencia;
	}

	public void setListProdutoPreferencia(List<ProdutoPreferencia> listProdutoPreferencia) {
		this.listProdutoPreferencia = listProdutoPreferencia;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
