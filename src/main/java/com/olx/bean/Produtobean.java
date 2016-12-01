package com.olx.bean;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import com.olx.dao.Anuncio_dao;

import com.olx.dominio.Anuncio;


import com.olx.util.facesUtil;

@ManagedBean
@SessionScoped
public class Produtobean {
	Anuncio publicaCadastro = new Anuncio();

	private List<Anuncio> listaAnuncio;
	private List<Anuncio> listaAnunFiltro;
	private String nome;
	

	// ----------------------------------------------------------get
	// set-----------------------------------------------------------------------------

	public Anuncio getPublicaCadastro() {
		return publicaCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	// ------------------------------------------------ metodos
	// modelo-----------------------------------------------------------------------
	

	public void limpar() {
		publicaCadastro = new Anuncio();
	}

	public void listar(Long id) {
		try {
			Anuncio_dao ad = new Anuncio_dao();
			listaAnuncio = ad.listar(id);

		} catch (Exception e) {
			facesUtil.addMsgErro("erro ao carregar");
		}
	}

	public void busca() {

	}

	public void listar() {
		try {
			Anuncio_dao ad = new Anuncio_dao();
			listaAnuncio = ad.listar();

		} catch (Exception e) {
			facesUtil.addMsgErro("erro ao carregar");
		}
	}

	
	public void carregar(){
		try {
			String valor = facesUtil.getParam("codigo2");
			if(valor != null){
				Long cod = Long.parseLong(valor);
				
				Anuncio_dao ad = new Anuncio_dao();
				publicaCadastro = ad.buscar(cod);
				System.out.println(publicaCadastro.getDescricao());
			}
		} catch (Exception e) {
			facesUtil.addMsgErro("erro ao carregar");
		}
	}
	
}
