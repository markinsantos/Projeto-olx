package com.olx.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.olx.dao.usuario_dao;
import com.olx.dominio.Usuario;
import com.olx.util.facesUtil;

@ManagedBean
@SessionScoped
public class LoginBean {
	private Usuario usuarioLogado;

	public Usuario getUsuarioLogado() {
		if(usuarioLogado == null){
			usuarioLogado = new Usuario();
		}
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public String acessar(){
		try {
			usuario_dao ud = new usuario_dao();
			usuarioLogado = ud.autenticar(usuarioLogado.getEmail(), usuarioLogado.getSenha());
			if(usuarioLogado==null){
				facesUtil.addMsgInfo("senha invalida ou usuario não existe");
			
			}else{
				facesUtil.addMsgInfo("login efetuado com sucesso");
				return "/paginas/minhaConta.xhtml?faces-redirect=true";
				

			}
			
		} catch (Exception e) {
			facesUtil.addMsgErro("erro login");
		}
		return "/paginas/login.xhtml?faces-redirect=true";
	}
	
	public String sair(){
		usuarioLogado = null;
		return "/paginas/login.xhtml";
	}

}
