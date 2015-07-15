package br.com.compra.combinada.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="configuracao")
public class Configuracao implements Serializable {


	private static final long serialVersionUID = 7448165380545942809L;

	@Id @GeneratedValue
	private int id;
	
	private String servidor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}
	

	
}
