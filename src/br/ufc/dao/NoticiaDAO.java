package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Noticia;


@Repository
public class NoticiaDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Noticia noticia){
		manager.persist(noticia);
	}
	
	public void alterar(Noticia noticia){
		manager.merge(noticia);
	}
	
	public Noticia recuperar(Long id){
		return manager.find(Noticia.class, id);		
	}
	
	public void apagar(Long id){
		Noticia ref = this.recuperar(id);
		
		if(ref!=null){
			manager.remove(ref);
		}		
	}
	
	public List<Noticia> listar(){
		return manager.createQuery("select n from noticia as n", Noticia.class).getResultList();
	}
	
	public Noticia recuperar(String titulo){
		String hql = "select n from noticia as n "
					+"where n.titulo = :param_titulo";
		
		Query query = manager.createQuery(hql);
		List<Noticia> noticias = 
				query.setParameter("param_titulo", titulo).getResultList();
		
			if(noticias.size()!=0){
				return noticias.get(0);
			}			
			return null;	
	}	

}
