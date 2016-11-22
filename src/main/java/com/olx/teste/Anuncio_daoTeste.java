package com.olx.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.olx.dao.Anuncio_dao;
import com.olx.dao.usuario_dao;
import com.olx.dominio.Anuncio;
import com.olx.dominio.Usuario;

public class Anuncio_daoTeste {
	@Test
	public void salvar() {
		usuario_dao ud = new usuario_dao();
		Usuario usu = ud.buscar(2L);
		Anuncio a1 = new Anuncio();
		a1.setValor(68);
		a1.setNome("bicicleta monark");
		a1.setDescricao("produto x");
		a1.setUsuario(usu);
		a1.setContato("3456-789");

		Anuncio_dao ad = new Anuncio_dao();

		ad.salvar(a1);
	}
	
	@Test
	@Ignore
	public void buscar(){
		Anuncio_dao ad = new Anuncio_dao();
		Anuncio anuncio = ad.buscar(1L);
		System.out.println(anuncio);
	}

	@Test
	@Ignore
	public void listar(){
		Anuncio_dao ad = new Anuncio_dao();
		List<Anuncio> listaAnuncio = ad.listar();
		for(Anuncio anuncio:listaAnuncio){
			System.out.println(anuncio+"   ");
		}
	}

	@Test
	@Ignore
	public void listar1(){
		Anuncio_dao ad = new Anuncio_dao();
		List<Anuncio> listaAnuncio = ad.listar(1L);
		for(Anuncio anuncio:listaAnuncio){
			System.out.println(anuncio+"   ");
		}
	}

}
