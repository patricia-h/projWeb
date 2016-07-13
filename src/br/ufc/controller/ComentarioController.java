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

import com.sun.org.apache.xpath.internal.operations.Mod;

import br.ufc.dao.ComentarioDAO;
import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class ComentarioController {

	@Autowired
	@Qualifier(value="comentarioDAO")
	private ComentarioDAO cmDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="noticiaDAO")
	private NoticiaDAO nDAO;
		
	@RequestMapping("/inserirComentarioFormulario")
	public String inserirComentarioFormulario(Long id, Model model){
		Noticia n = nDAO.recuperar(id);
		
		model.addAttribute("noticia_id", n);
		model.addAttribute("comentarios", n.getComentarios());
		return "comentario/inserir_comentario_formulario";
	}
	
	
	@RequestMapping("/inserirComentario")
	public String inserirComentario(Long usuario_id, Long noticia_id, @Valid Comentario comentario,
							   BindingResult result){		
		
		if(result.hasFieldErrors("comentario")){
			return "comentario/inserir_comentario_formulario";
		}
		
		Noticia noticia = nDAO.recuperar(noticia_id);
		comentario.setIdNoticia(noticia);
		
		Usuario usuario = uDAO.recuperar(usuario_id);
		comentario.setAutorComentario(usuario);
		
		this.cmDAO.inserir(comentario);
		
		return "comentario/comentario_inserido_ok";
	}
	
	@RequestMapping("/listarComentario")
	public String listarComentario(Model model){
				
		List<Comentario> comentarios = this.cmDAO.listar();
		model.addAttribute("comentarios", comentarios);
				
		return "comentario/listar_comentario";
	}	
	
	@RequestMapping("/apagarComentario")
	public String apagarComentario(Long id){
		
		this.cmDAO.apagar(id);
		return "redirect:listarComentario";
	}
	
	@RequestMapping("/alterarComentarioFormulario")
	public String alterarComentarioFormulario(Long id, Model model){
		
		Comentario comentario = this.cmDAO.recuperar(id);
		model.addAttribute("comentario", comentario);
		return "comentario/alterar_comentario_formulario";
	}
	
	@RequestMapping("/alterarComentario")
	public String alterarComentario(Comentario comentario){
		
		this.cmDAO.alterar(comentario);
		return "redirect:listarComentario";
	}	
}
