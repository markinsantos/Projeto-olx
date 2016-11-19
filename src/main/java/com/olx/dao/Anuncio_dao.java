package com.olx.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.olx.conexao.HibernateUtil;
import com.olx.dominio.Anuncio;




public class Anuncio_dao {
	
	public void salvar(Anuncio anuncio){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction tran = null;
		try {
			tran = sessao.beginTransaction();
			sessao.save(anuncio);
			tran.commit();
		} catch (Exception e) {
			if(tran!= null){
				tran.rollback();
			}
			System.out.println("erro ao salvar");
			throw e;
			
		}finally {
			sessao.close();
		}	
		
	}

	@SuppressWarnings("unchecked")
	public List<Anuncio> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Anuncio> anuncio = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Anuncio.listar");
			anuncio = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return anuncio;
	}
	
	@SuppressWarnings("unchecked")
	public List<Anuncio> listar(Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Anuncio> anuncio = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Anuncio.buscar2");
			consulta.setLong("usuario",id);
			anuncio = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return anuncio;
	}

	public Anuncio buscar(Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Anuncio anuncio  = null;
		try {
			Query consulta = sessao.getNamedQuery("Anuncio.buscar");
			consulta.setLong("id",id);
			anuncio = (Anuncio) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return anuncio;
	}
	
	public void excluir(Anuncio anuncio){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction tran = null;
		try {
			tran = sessao.beginTransaction();
			sessao.delete(anuncio);
			tran.commit();
		} catch (Exception e) {
			if(tran!= null){
				tran.rollback();
			}
			System.out.println("erro ao salvar");
		}finally {
			sessao.close();
		}}
}
