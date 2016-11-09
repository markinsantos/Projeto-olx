package com.olx.teste;

import org.junit.Test;

import com.olx.conexao.HibernateUtil;

public class gerarTabelasTeste {
	
	@Test
	public void gerar(){
		HibernateUtil.getSessionFactory().openSession();
		HibernateUtil.getSessionFactory().close();
	}

}
