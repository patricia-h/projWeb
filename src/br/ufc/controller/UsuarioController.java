package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.PapelDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;
import br.ufc.util.AulaFileUtil;

@Transactional
@Controller
public class UsuarioController {
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="papelDAO")
	private PapelDAO pDAO;
	
	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario(Model model){
		List<Papel> papeis = pDAO.listar();
		model.addAttribute("papeis", papeis);
		return "usuario/inserir_usuario_formulario";
	}
	
	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(@Valid Usuario usuario, 
							   BindingResult result,HttpServletRequest req,
							   @RequestParam(value="imagem", required=false) MultipartFile imagem 
							   ){
		
		if(result.hasFieldErrors("nome")){
			return "usuario/inserir_usuario_formulario";
		}
		
	
		List<Papel> p = new ArrayList<Papel>();
		
		p.add(this.pDAO.recuperar((long) Integer.parseInt(req.getParameter("papeis"))));
		usuario.setPapeis(p);
		
		
		
		String path = servletContext.getRealPath("/")+"resources/images/"+usuario.getLogin()+".png";
		
		AulaFileUtil.salvarImagem(path, imagem);
		
		this.uDAO.inserir(usuario);
		
		return "usuario/usuario_inserido_ok";
	}
	
	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model){
		
		
		List<Usuario> usuarios = this.uDAO.listar();
		model.addAttribute("usuarios", usuarios);
		
		
		return "usuario/listar_usuario";
	}	
	
	@RequestMapping("/apagarUsuario")
	public String apagarUsuario(Long id){
		
		this.uDAO.apagar(id);
		return "redirect:listarUsuario";
	}
	
	@RequestMapping("/alterarUsuarioFormulario")
	public String alterarUsuarioFormulario(Long id, Model model){
		
		Usuario usuario = this.uDAO.recuperar(id);
		model.addAttribute("usuario", usuario);
		return "usuario/alterar_usuario_formulario";
	}
	
	@RequestMapping("/alterarUsuario")
	public String alterarUsuario(Usuario usuario){
		
		this.uDAO.alterar(usuario);
		return "redirect:listarUsuario";
	}
}
