package br.ufc.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Papel;

@Repository
public class PapelDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Papel papel){
		manager.persist(papel);
	}
	
	public void alterar(Papel papel){
		manager.merge(papel);
	}
	
	public Papel recuperar(Long id){
		return manager.find(Papel.class, id);		
	}
	
	public void apagar(Long id){
		Papel ref = this.recuperar(id);
		
		if(ref!=null){
			manager.remove(ref);
		}		
	}
	
	public List<Papel> listar(){
		return manager.createQuery("select p from papel as p", Papel.class).getResultList();
	}
	
	public Papel recuperar(String papel){
		String hql = "select p from papel as p "
					+"where p.papel = :param_papel";
		
		Query query = manager.createQuery(hql);
		List<Papel> papeis = 
				query.setParameter("param_papel", papel).getResultList();
		
			if(papeis.size()!=0){
				return papeis.get(0);
			}			
			return null;	
	}	
	
}
