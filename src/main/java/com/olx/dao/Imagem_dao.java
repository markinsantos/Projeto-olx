package com.olx.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.olx.conexao.HibernateUtil;
import com.olx.dominio.Imagen;

public class Imagem_dao {
	
	public void salvar(Imagen imagem){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction tran = null;
		try {
			tran = sessao.beginTransaction();
			sessao.save(imagem);
			tran.commit();
		} catch (Exception e) {
			if(tran!= null){
				tran.rollback();
			}
			System.out.println("erro ao salvar");
		}finally {
			sessao.close();
		}	
		
	}
	
	public Imagen buscar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Imagen imagem  = null;
		try {
			Query consulta = sessao.getNamedQuery("Imagen.buscar");
			
			imagem = (Imagen) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return imagem;
	}
	
	public void excluir(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction tran = null;
		try {
			tran = sessao.beginTransaction();
			Imagen imagem = buscar();
			sessao.delete(imagem);
			tran.commit();
		} catch (Exception e) {
			if(tran!= null){
				tran.rollback();
			}
			System.out.println("erro ao excluir");
		}finally {
			sessao.close();
		}
}

}



