package com.olx.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue
	private int id;
	private String nome;

}
