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


import br.ufc.dao.PapelDAO;
import br.ufc.model.Papel;

@Transactional
@Controller
public class PapelController {

	@Autowired
	@Qualifier(value="papelDAO")
	private PapelDAO pDAO;
		
	@RequestMapping("/inserirPapelFormulario")
	public String inserirPapelFormulario(){
		return "papel/inserir_papel_formulario";
	}
	
	
	@RequestMapping("/inserirPapel")
	public String inserirPapel(@Valid Papel papel,
							   BindingResult result){
	
		if(result.hasFieldErrors("papel")){
			return "papel/inserir_papel_formulario";
		}
		
		this.pDAO.inserir(papel);
		
		return "papel/papel_inserido_ok";
	}
	
	@RequestMapping("/listarPapel")
	public String listarPapel(Model model){
				
		List<Papel> papeis = this.pDAO.listar();
		model.addAttribute("papeis", papeis);
				
		return "papel/listar_papel";
	}	
	
	@RequestMapping("/apagarPapel")
	public String apagarPapel(Long id){
		
		this.pDAO.apagar(id);
		return "redirect:listarPapel";
	}
	
	@RequestMapping("/alterarPapelFormulario")
	public String alterarPapelFormulario(Long id, Model model){
		
		Papel papel = this.pDAO.recuperar(id);
		model.addAttribute("papel", papel);
		return "papel/alterar_papel_formulario";
	}
	
	@RequestMapping("/alterarPapel")
	public String alterarPapel(Papel papel){
		
		this.pDAO.alterar(papel);
		return "redirect:listarPapel";
	}
}
