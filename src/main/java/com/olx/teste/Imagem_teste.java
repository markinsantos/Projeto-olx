package com.olx.teste;


import org.junit.Ignore;
import org.junit.Test;

import com.olx.dao.Imagem_dao;
import com.olx.dominio.Imagen;

public class Imagem_teste {
	
	@Test
	@Ignore
	public void listar(){
		Imagen imagem = new Imagen();
		Imagem_dao id = new Imagem_dao();
		imagem = id.buscar();
		
			System.out.println(imagem.getCaminho()+"   ");
		
	}
	
	@Test
	public void excluir(){
		Imagem_dao id = new Imagem_dao();
		Imagen imagem = id.buscar();
		id.excluir();
	}

}
