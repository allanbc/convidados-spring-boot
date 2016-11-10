package com.bcampos.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bcampos.festa.model.Convidado;
import com.bcampos.festa.model.Convidados;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	private static final String LISTA_VIEW = "ListaConvidados";
	
	@Autowired
	private Convidados convidados;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView(LISTA_VIEW);
		mv.addObject("convidados", convidados.getListaConvidados());
		mv.addObject(new Convidado());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String Salvar(Convidado convidado){
		this.convidados.adicionar(convidado);
		return "redirect:/convidados";
		
	}
}
