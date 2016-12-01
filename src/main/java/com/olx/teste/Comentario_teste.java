package com.olx.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.olx.dao.Anuncio_dao;
import com.olx.dao.Comentario_dao;
import com.olx.dominio.Anuncio;
import com.olx.dominio.Comentario;


public class Comentario_teste {

	@Test
	@Ignore
	public void salvar(){
		Comentario comentario = new Comentario();
		
		Anuncio_dao ad = new Anuncio_dao();
		Anuncio anuncio = ad.buscar(2L);
		comentario.setComentario("como faço para adquirir oproduto?");
		comentario.setAnuncio(anuncio);

		Comentario_dao cd = new Comentario_dao();
		cd.salvar(comentario);
		
	}
	
	@Test
	public void listar1(){
		Comentario_dao cd = new Comentario_dao();
		List<Comentario> listaComentario = cd.listar(1L);
		for(Comentario comentario:listaComentario){
			System.out.println(comentario.getComentario()+"   ");
		}
	}
}
