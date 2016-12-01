package com.olx.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.olx.conexao.HibernateUtil;
import com.olx.dominio.Comentario;


public class Comentario_dao {
	
	public void salvar(Comentario comentario){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction tran = null;
		try {
			tran = sessao.beginTransaction();
			sessao.save(comentario);
			tran.commit();
		} catch (Exception e) {
			if(tran!= null){
				tran.rollback();
			}
			System.out.println("erro ao salvar comentario");
		}finally {
			sessao.close();
		}	
		
	}

	@SuppressWarnings("unchecked")
	public List<Comentario> listar(Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Comentario> comentario = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Comentario.buscar");
			consulta.setLong("anuncio",id);
			comentario = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return comentario;
	}
}
