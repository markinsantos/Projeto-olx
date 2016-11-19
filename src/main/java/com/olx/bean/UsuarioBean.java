package com.olx.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import com.olx.dao.usuario_dao;
import com.olx.dominio.Usuario;
import com.olx.util.facesUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuario_cadastro = new Usuario();;
	private List<Usuario> listaUsuario;
	private List<Usuario> listaUsuFiltro;

	// ------------------- get e set -----------------------------------
	public Usuario getUsuario_cadastro() {
		if (usuario_cadastro == null) {
			usuario_cadastro = new Usuario();
		}
		return usuario_cadastro;
	}

	public void setUsuario_cadastro(Usuario usuario_cadastro) {
		this.usuario_cadastro = usuario_cadastro;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public List<Usuario> getListaUsuFiltro() {
		return listaUsuFiltro;
	}

	public void setListaUsuFiltro(List<Usuario> listaUsuFiltro) {
		this.listaUsuFiltro = listaUsuFiltro;
	}

	// ----------------------metodos do modelo ----------------------------
	public void limpar() {
		usuario_cadastro = new Usuario();
	}

	public void salvar() {
		try {
			usuario_dao usu_dao = new usuario_dao();
			usu_dao.salvar(usuario_cadastro);
			 facesUtil.addMsgInfo(usuario_cadastro.toString());
			facesUtil.addMsgInfo("salvo com sucesso");
			usuario_cadastro = new Usuario();
		} catch (RuntimeException e) {
			e.printStackTrace();
			facesUtil.addMsgErro("erro ao salvar usuario");
		}

	}

	public void listar(){
		try {
			usuario_dao ud = new usuario_dao();
			listaUsuario = ud.listar();
			
		} catch (Exception e) {
			facesUtil.addMsgErro("erro ao carregar");
		}
	}
}
