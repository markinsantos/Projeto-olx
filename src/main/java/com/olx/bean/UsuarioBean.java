package com.olx.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.olx.util.facesUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	public void salvar(){
		facesUtil.addMsgInfo("salvo com sucesso");
	}

}
