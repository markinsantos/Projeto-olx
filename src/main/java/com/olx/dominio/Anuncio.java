package com.olx.dominio;

import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity 
@Table(name = "anuncio")
@NamedQueries({ 
	@NamedQuery(name = "Anuncio.listar", query = "SELECT anuncio FROM Anuncio anuncio"),
	@NamedQuery(name ="Anuncio.buscar",query ="SELECT anuncio FROM Anuncio anuncio WHERE anuncio.id = :id"),
	@NamedQuery(name ="Anuncio.buscar2",query ="SELECT anuncio FROM Anuncio anuncio WHERE anuncio.usuario = :usuario")
})
public class Anuncio {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty (message = "o campo preço e obrigatorio")
	private String nome;
	
	@NotNull (message = "o campo preço e obrigatorio")
	@DecimalMin(value = "0.00", message = "informe um valor valido")
	@DecimalMax (value = "99999.99", message = "informe um valor valido")
	@Column(name="valor", precision=7, scale= 2, nullable= false)
	private BigDecimal valor;
	@NotEmpty (message = "campo obrigatório")
	private String descricao;
	@NotEmpty (message = "campo obrigatório")
	private String contato;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "id_usuario",referencedColumnName = "id",nullable = false)
	private Usuario usuario;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	@Override
	public String toString() {
		return "Anuncio [id=" + id + ", nome=" + nome + ", valor=" + valor + ", descricao=" + descricao + ", contato="
				+ contato + ", usuario=" + usuario + "]";
	}
	
	
		
	
	

}
