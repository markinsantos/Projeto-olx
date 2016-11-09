package com.olx.conexao;

import org.hibernate.Session;

public class ConectaHibernateMysq {

	public static void main(String[] args) {
		Session sessao = null;
		sessao = HibernateUtil.getSessionFactory().openSession();
		System.out.println("conectou");
		sessao.close();

	}

}
