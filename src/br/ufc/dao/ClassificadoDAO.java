package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificado;


@Repository
public class ClassificadoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Classificado classificado) {
		manager.persist(classificado);		
	}

	public void alterar(Classificado classificado) {
		manager.merge(classificado);
	}

	public Classificado recuperar(Long id) {
		return manager.find(Classificado.class, 1);
	}

	public void apagar(Long id) {
		Classificado ref = this.recuperar(id);
		if(ref!=null){
			manager.remove(ref);
		}
	}

	public List<Classificado> listar() {
		return manager.createQuery("select c from classificado as c",
									Classificado.class).getResultList();
	}

	public Classificado recuperar(String login) {
		
		String hql = "select c from classificado as c "
					+"where c.login = :param_login";
		
		Query query = manager.createQuery(hql);
		List<Classificado> classificados = 
				query.setParameter("param_login", login).getResultList();
		
		if(classificados.size()!=0){
			return classificados.get(0);
		}
		
		return null;
	}
	

}
