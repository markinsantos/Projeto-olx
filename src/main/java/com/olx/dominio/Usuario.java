package com.olx.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "usuario")
@NamedQueries({ 
	@NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario"),
	@NamedQuery(name ="Usuario.buscar",query ="SELECT usuario FROM Usuario usuario WHERE usuario.id = :id"),
	@NamedQuery(name = "Usuario.autenticar", query = "SELECT usuario FROM Usuario usuario WHERE usuario.email = :email AND usuario.senha = :senha")
})
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty (message = "campo obrigatorio")
	private String nome;
	@NotEmpty(message = "campo obrigatorio")
	@Email
	private String email;
	@NotEmpty
	private String senha;


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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha +""
				+ "]";
	}
	

}
