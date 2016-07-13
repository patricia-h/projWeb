package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Usuario;

@Controller
public class LoginController {

	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@RequestMapping("/loginFormulario")
	public String loginFormulario(){
		return "login_formulario";
	}
	
	@RequestMapping("/login")
	public String login(Usuario usuario, HttpSession session){
		Usuario candidato = uDAO.recuperar(usuario.getLogin());
		if(candidato!=null){
			if(candidato.getSenha().equals(usuario.getSenha())){
				session.setAttribute("usuario_logado", candidato);
				session.setAttribute("papel_sessao", candidato.getPapeis().get(0).getId());
				return "menu";
			}
		}
		return "redirect:loginFormulario";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:loginFormulario";
	}
}

