package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Usuario;

@Repository
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Usuario usuario) {
		manager.persist(usuario);		
	}

	public void alterar(Usuario usuario) {
		manager.merge(usuario);
	}

	public Usuario recuperar(Long id) {
		return manager.find(Usuario.class, id);
	}

	public void apagar(Long id) {
		Usuario ref = this.recuperar(id);
		if(ref!=null){
			manager.remove(ref);
		}
	}

	public List<Usuario> listar() {
		return manager.createQuery("select u from usuario as u",
									Usuario.class).getResultList();
	}

	public Usuario recuperar(String login) {
		
		String hql = "select u from usuario as u "
					+"where u.login = :param_login";
		
		Query query = manager.createQuery(hql);
		List<Usuario> usuarios = 
				query.setParameter("param_login", login).getResultList();
		
		if(usuarios.size()!=0){
			return usuarios.get(0);
		}
		
		return null;
	}
	
	
}
