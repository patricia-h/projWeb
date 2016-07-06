package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class NoticiaController {

	@Autowired
	@Qualifier(value="noticiaDAO")
	private NoticiaDAO nDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	

	@Autowired
	@Qualifier(value="secaoDAO")
	private SecaoDAO sDAO;
	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(Model model){
		List<Secao> secoes = sDAO.listar();
		model.addAttribute("secoes", secoes);
		return "noticia/inserir_noticia_formulario";
	}	
	
	@RequestMapping("/inserirNoticia")
	public String inserirNoticia(Long usuario_id, @Valid Noticia noticia,
								HttpServletRequest request, BindingResult result){
		System.out.println("ola");
		
		if(result.hasFieldErrors("titulo")){
			return "noticia/inserir_noticia_formulario";
		}
		
		Usuario usuario = new Usuario(); 
		usuario=(uDAO.recuperar(usuario_id));
		noticia.setIdAutor(usuario);		
		
		Secao s = new Secao();
		s=(this.sDAO.recuperar((long) Integer.parseInt(request.getParameter("secoes"))));
		noticia.setIdSecao(s);
					
		this.nDAO.inserir(noticia);
		
		return "noticia/noticia_inserido_ok";
	}
	
	@RequestMapping("/listarNoticia")
	public String listarNoticia(Model model){
				
		List<Noticia> noticias = this.nDAO.listar();
		model.addAttribute("noticias", noticias);
				
		return "noticia/listar_noticia";
	}	
	
	@RequestMapping("/apagarNoticia")
	public String apagarNoticia(Long id){
		
		this.nDAO.apagar(id);
		return "redirect:listarNoticia";
	}
	
	@RequestMapping("/alterarNoticiaFormulario")
	public String alterarNoticiaFormulario(Long id, Model model){
		
		Noticia noticia = this.nDAO.recuperar(id);
		model.addAttribute("noticia", noticia);
		return "noticia/alterar_noticia_formulario";
	}
	
	@RequestMapping("/alterarNoticia")
	public String alterarNoticia(Noticia noticia){
		
		this.nDAO.alterar(noticia);
		return "redirect:listarNoticia";
	}
	
}
