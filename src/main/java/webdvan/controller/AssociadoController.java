package webdvan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import webdvan.models.Rota;
import webdvan.repository.RotaRepository;

@Controller
public class AssociadoController {
	
	@Autowired
	private RotaRepository rr;
	
	@RequestMapping(value ="CadastroRota", method = RequestMethod.GET)
	public String formCadastroRota() {
		return "formCadastroRota.html";
	}
	
	@RequestMapping(value ="/rota", method = RequestMethod.POST)
	public String form(Rota rota) {
		
		rr.save(rota);
		return "formCadastroRota.html";
	}

}
