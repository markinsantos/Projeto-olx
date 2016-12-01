package com.olx.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import com.olx.dao.Comentario_dao;
import com.olx.dominio.Anuncio;
import com.olx.dominio.Comentario;
import com.olx.util.facesUtil;

@ManagedBean
@ViewScoped
public class ComentarioBean {
	
	private Comentario comentario = new Comentario();
	private List<Comentario> listaComentario;

	
	public List<Comentario> getListaComentario() {
		return listaComentario;
	}

	public void setListaComentario(List<Comentario> listaComentario) {
		this.listaComentario = listaComentario;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}
	
	public void salvar(Anuncio anuncio){
		
		try {
			
			Comentario_dao cd = new Comentario_dao();
			comentario.setAnuncio(anuncio);
			cd.salvar(comentario);
			facesUtil.addMsgInfo("salvo com sucesso");
			comentario = new Comentario();
		} catch (Exception e) {
			e.printStackTrace();
			facesUtil.addMsgErro("erro ao salvar usuario");
		}
		
	}
	
	public void listar(Long id) {
		try {
			Comentario_dao cd = new Comentario_dao();
			listaComentario = cd.listar(id);

		} catch (Exception e) {
			facesUtil.addMsgErro("erro ao carregar");
		}
	}


}
