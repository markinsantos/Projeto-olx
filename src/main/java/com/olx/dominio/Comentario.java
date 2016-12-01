package com.olx.dominio;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity 
@Table(name = "comentario")
@NamedQueries({ 
		@NamedQuery(name ="Comentario.buscar",query ="SELECT comentario FROM Comentario comentario WHERE comentario.anuncio = :anuncio")
})
public class Comentario {
	
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty (message = "campo obrigatorio")
	private String comentario;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "id_Anuncio",referencedColumnName = "id")
	private Anuncio anuncio;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Anuncio getAnuncio() {
		return anuncio;
	}
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	@Override
	public String toString() {
		return "Comentario [id=" + id + ", comentario=" + comentario + ", anuncio=" + anuncio + "]";
	}
	
	

}
