package br.com.compra.combinada.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="fabricante")
public class Fabricante implements Serializable{

	private static final long serialVersionUID = -85874286489974127L;

	@Id @GeneratedValue
	private int id;
	
	@Column(name = "razao_social")
	private String razaoSocial;
	
	@Column(name = "nome_fantasia")
	private String nomeFantasia;
	
	private String endereco;
	
	private String numero;
	
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name = "municipio_id")
	private Municipio municipio;
	
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;
	
	private String cep;
	
	private String telefone;
	
	private String ie;
	
	private String cnpj;
	
	private String email;
	
	private Timestamp interacao;
	
	@JsonIgnore
	@OneToMany(mappedBy="fabricante", cascade={CascadeType.PERSIST})
	private List<Marca> marcas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getInteracao() {
		return interacao;
	}

	public void setInteracao(Timestamp interacao) {
		this.interacao = interacao;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	

}
