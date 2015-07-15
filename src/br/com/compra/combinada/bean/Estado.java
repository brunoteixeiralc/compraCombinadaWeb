package br.com.compra.combinada.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="estado")
public class Estado implements Serializable{


	private static final long serialVersionUID = 4339919602554204031L;

	@Id @GeneratedValue
	private int id;
	
	private String nome;
	
	private String sigla;
	
	private Timestamp interacao;
	
	@JsonIgnore
	@OneToMany(mappedBy="estado", cascade={CascadeType.PERSIST})
	private List<Municipio> municipios;
	
	@JsonIgnore
	@OneToMany(mappedBy="estado", cascade={CascadeType.PERSIST})
	private List<Fabricante> fabricantes;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Timestamp getInteracao() {
		return interacao;
	}

	public void setInteracao(Timestamp interacao) {
		this.interacao = interacao;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	

}
