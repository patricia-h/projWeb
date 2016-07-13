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

import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class ClassificadoController {

	@Autowired
	@Qualifier(value="classificadoDAO")
	private ClassificadoDAO cDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
		
	@RequestMapping("/inserirClassificadoFormulario")
	public String inserirClassificadoFormulario(){
		return "classificado/inserir_classificado_formulario";
	}
	
	
	@RequestMapping("/inserirClassificado")
	public String inserirClassificado(Long usuario_id, @Valid Classificado classificado,
							   BindingResult result){
	
		if(result.hasFieldErrors("classificado")){
			return "classificado/inserir_classificado_formulario";
		}
		Usuario usuario = uDAO.recuperar(usuario_id);
		classificado.setAutor(usuario);
		
		this.cDAO.inserir(classificado);
		
		return "classificado/classificado_inserido_ok";
	}
	
	@RequestMapping("/listarClassificado")
	public String listarClassificado(Model model){
				
		List<Classificado> classificados = this.cDAO.listar();
		model.addAttribute("classificados", classificados);
				
		return "classificado/listar_classificado";
	}	
	
	@RequestMapping("/apagarClassificado")
	public String apagarClassificado(Long id){
		
		this.cDAO.apagar(id);
		return "redirect:listarClassificado";
	}
	
	@RequestMapping("/alterarClassificadoFormulario")
	public String alterarClassificadoFormulario(Long id, Model model){
		Classificado classificado = this.cDAO.recuperar(id);
		model.addAttribute("classificado", classificado);
		return "classificado/alterar_classificado_formulario";
	}
	
	@RequestMapping("/alterarClassificado")
	public String alterarClassificado(Classificado classificado, Long usuario){
		
		Usuario u = uDAO.recuperar(usuario);
		classificado.setAutor(u);
		
		this.cDAO.alterar(classificado);
		return "redirect:listarClassificado";
	}

}
