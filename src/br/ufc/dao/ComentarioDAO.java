package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;

import br.ufc.model.Comentario;

@Repository
public class ComentarioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Comentario comentario){
		manager.persist(comentario);
	}
	
	public void alterar(Comentario comentario){
		manager.merge(comentario);
	}
	
	public Comentario recuperar(Long id){
		return manager.find(Comentario.class, id);		
	}
	
	public void apagar(Long id){
		Comentario ref = this.recuperar(id);
		
		if(ref!=null){
			manager.remove(ref);
		}		
	}
	
	public List<Comentario> listar(){
		return manager.createQuery("select cm from comentario as cm", Comentario.class).getResultList();
	}	
}
