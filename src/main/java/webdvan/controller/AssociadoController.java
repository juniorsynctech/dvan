package webdvan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webdvan.models.Rota;
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
	public String formMenuAssociado() {
		
		return "associado/formMenuAssociado.html";
	}
	
	@RequestMapping(value ="/rota", method = RequestMethod.POST)
	public String Cadastrar(Rota rota) {
		rr.save(rota);
		return "associado/formCadastroRota.html";
	}
	
	@RequestMapping(value ="/rotas", method = RequestMethod.POST)
	public String ExibeRotas(Rota rota) {
		
		return "";
	}
	
	@RequestMapping(value ="/ListarRotas", method = RequestMethod.GET)
	public String Listar() {
		
		ModelAndView mv = new ModelAndView("associado/formListaRotas.html");
		Iterable<Rota> lista = rr.findAll();
		mv.addObject("rotas", lista);		
		return "associado/formListaRotas.html";
		
	}
}
