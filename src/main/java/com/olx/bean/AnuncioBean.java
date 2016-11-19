package com.olx.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.olx.dao.Anuncio_dao;
import com.olx.dominio.Anuncio;
import com.olx.util.facesUtil;

@ManagedBean
@ViewScoped
public class AnuncioBean {
	Anuncio publicaCadastro = new Anuncio();
	private List<Anuncio> listaAnuncio;
	private List<Anuncio> listaAnunFiltro;

//----------------------------------------------------------get set-----------------------------------------------------------------------------
	
	public Anuncio getPublicaCadastro() {
		return publicaCadastro;
	}


	public void setPublicaCadastro(Anuncio publicaCadastro) {
		this.publicaCadastro = publicaCadastro;
	}


	public List<Anuncio> getListaAnuncio() {
		return listaAnuncio;
	}


	public void setListaAnuncio(List<Anuncio> listaAnuncio) {
		this.listaAnuncio = listaAnuncio;
	}


	public List<Anuncio> getListaAnunFiltro() {
		return listaAnunFiltro;
	}


	public void setListaAnunFiltro(List<Anuncio> listaAnunFiltro) {
		this.listaAnunFiltro = listaAnunFiltro;
	}

//------------------------------------------------ metodos modelo-----------------------------------------------------------------------
	public void salvar() {
		try {
			Anuncio_dao ad = new Anuncio_dao();
			ad.salvar(publicaCadastro);
			// facesUtil.addMsgInfo(usuario_cadastro.toString());
			facesUtil.addMsgInfo("salvo com sucesso");
			publicaCadastro = new Anuncio();
		} catch (RuntimeException e) {
			e.printStackTrace();
			facesUtil.addMsgErro("erro ao salvar Anuncio");
		}

	}
	
	public void listar(Long id){
		try {
			Anuncio_dao ad = new Anuncio_dao();
			listaAnuncio = ad.listar(id);
			
		} catch (Exception e) {
			facesUtil.addMsgErro("erro ao carregar");
		}
	}
	public void listar(){
		try {
			Anuncio_dao ad = new Anuncio_dao();
			listaAnuncio = ad.listar();
			
		} catch (Exception e) {
			facesUtil.addMsgErro("erro ao carregar");
		}
	}
}
