package com.olx.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.olx.dao.usuario_dao;
import com.olx.dominio.Usuario;

public class usu_dao_teste {
	
	@Test
	@Ignore
	public void salvar(){
		Usuario u1 = new Usuario();
		u1.setEmail("marcos");
		u1.setNome("marcos");
		u1.setSenha("marcos");
		u1.setTipo(2);
		
		usuario_dao ud= new usuario_dao();
		
		ud.salvar(u1);
	}
	
	@Test
	@Ignore
	public void listar(){
		usuario_dao ud = new usuario_dao();
		List<Usuario> usuarios = ud.listar();
		for(Usuario usuario:usuarios){
			System.out.println(usuario+"   ");
		}
	}

	@Test
	@Ignore
	public void buscar(){
		usuario_dao ud = new usuario_dao();
		Usuario usuario = ud.buscar(3L);
		System.out.println(usuario);
		
	}
	
	@Test
	public void excluir(){
		usuario_dao ud = new usuario_dao();
		Usuario usuario = ud.buscar(2L);
		ud.excluir(usuario);
	}
	public void excluirPorCod(){
		usuario_dao ud = new usuario_dao();
		ud.excluir(2L);
	}
}

