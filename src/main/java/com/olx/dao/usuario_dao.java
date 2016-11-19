package com.olx.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.olx.conexao.HibernateUtil;
import com.olx.dominio.Usuario;

public class usuario_dao {
	
	
	
	
	public void salvar(Usuario usuario){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction tran = null;
		try {
			tran = sessao.beginTransaction();
			sessao.save(usuario);
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
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> usuarios = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Usuario.listar");
			usuarios = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return usuarios;
	}
   
	public Usuario buscar(Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario  = null;
		try {
			Query consulta = sessao.getNamedQuery("Usuario.buscar");
			consulta.setLong("id",id);
			usuario = (Usuario) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return usuario;
	}

	public void excluir(Usuario usuario){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction tran = null;
		try {
			tran = sessao.beginTransaction();
			sessao.delete(usuario);
			tran.commit();
		} catch (Exception e) {
			if(tran!= null){
				tran.rollback();
			}
			System.out.println("erro ao salvar");
		}finally {
			sessao.close();
		}}
		
		public void excluir(Long id){
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			Transaction tran = null;
			try {
				tran = sessao.beginTransaction();
				Usuario usuario = buscar(id);
				sessao.delete(usuario);
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
		
		
		public void editar(Usuario usuario){
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			Transaction tran = null;
			try {
				tran = sessao.beginTransaction();
				sessao.update(usuario);
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
		
		public Usuario autenticar(String email, String senha){
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			Usuario usuario  = null;
			try {
				Query consulta = sessao.getNamedQuery("Usuario.autenticar");
				consulta.setString("email",email);
				consulta.setString("senha",senha);
				usuario = (Usuario) consulta.uniqueResult();
			} catch (RuntimeException ex) {
				throw ex;
			}finally {
				sessao.close();
			}
			
			return usuario;
			
		}
		
}
