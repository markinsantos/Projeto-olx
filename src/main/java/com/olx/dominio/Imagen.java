package com.olx.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name ="imagem")
@NamedQueries({ 
	@NamedQuery(name = "Imagen.buscar", query = "SELECT imagem FROM Imagen imagem")
})
public class Imagen {

	@GeneratedValue
	@Id
	private Long id;
	@NotEmpty (message = "campo obrigatorio")
	private String caminho;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	@Override
	public String toString() {
		return "Imagen [caminho=" + caminho + "]";
	}
	
	
}
