package webdvan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webdvan.models.Rota;
import webdvan.models.Usuario;
import webdvan.repository.RotaRepository;

@Controller
public class AssociadoController {
	
	@Autowired
	private RotaRepository rr;
		
	@RequestMapping(value ="/CadastroRota", method = RequestMethod.GET)
	public String formCadastroRota() {
		return "associado/formCadastroRota.html";
	}
	
	@RequestMapping(value ="/MenuAssociado", method = RequestMethod.GET)
	public ModelAndView formMenuAssociado() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("associado/formMenuAssociado.html");
		List<Rota> lista = rr.findAll();
		mv.addObject("rotas", lista);	
			
		
		
		return mv;
	}
	
	@RequestMapping(value ="/rota", method = RequestMethod.POST)
	public String cadastrar(Rota rota , HttpSession session) {
		
		Usuario us = (Usuario)session.getAttribute("usuario");
		rota.setIdUsuario(us.getId());
		rr.save(rota);
		return "associado/formCadastroRota.html";
	}
	
	@RequestMapping(value ="/rotas", method = RequestMethod.POST)
	public String ExibeRotas(Rota rota) {
		
		return "";
	}
	
	@RequestMapping(value ="/ListarRotas", method = RequestMethod.GET)
	public ModelAndView Listar() {
		
		ModelAndView mv = new ModelAndView("associado/formListaRotas.html");
		Iterable<Rota> lista = rr.findAll();
		mv.addObject("rotas", lista);		
		return mv;
		
	}
}
