package br.ufc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.NoticiaDAO;
import br.ufc.model.Noticia;

@Transactional
@Controller
public class NoticiaController {

	@Autowired
	@Qualifier(value="noticiaDAO")
	private NoticiaDAO nDAO;
	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(){
		return "noticia/inserir_noticia_formulario";
	}	
	
	@RequestMapping("/inserirNoticia")
	public String inserirNoticia(@Valid Noticia noticia,
							   BindingResult result){
	
		if(result.hasFieldErrors("titulo")){
			return "noticia/inserir_noticia_formulario";
		}
		
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
