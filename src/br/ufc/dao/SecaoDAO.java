package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Secao;

@Repository
public class SecaoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Secao secao){
		manager.persist(secao);
	}
	
	public void alterar(Secao secao){
		manager.merge(secao);
	}
	
	public Secao recuperar(Long id){
		return manager.find(Secao.class, id);		
	}
	
	public void apagar(Long id){
		Secao ref = this.recuperar(id);
		
		if(ref!=null){
			manager.remove(ref);
		}		
	}
	
	public List<Secao> listar(){
		return manager.createQuery("select s from secao as s", Secao.class).getResultList();
	}
	
	public Secao recuperar(String titulo){
		String hql = "select s from secao as s "
					+"where s.titulo = :param_secao";
		
		Query query = manager.createQuery(hql);
		List<Secao> secoes = 
				query.setParameter("param_secao", titulo).getResultList();
		
			if(secoes.size()!=0){
				return secoes.get(0);
			}			
			return null;	
	}	

	
}
