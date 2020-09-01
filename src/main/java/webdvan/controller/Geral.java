package webdvan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Geral {
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping(value ="", method = RequestMethod.GET)
	public String index() {
		
		//if(!this.session.isNew()) {
		//	return "dvan/CadastroUsuario.html";	
		//}
		return "index.html";
	}
	
	@RequestMapping(value ="/cadastraUsuario", method = RequestMethod.GET)
	public String form() {
		return "dvan/CadastroUsuario.html";
	}
	
	@RequestMapping(value ="/associado", method = RequestMethod.GET)
	public String associado() {
		return "associado/formMenuAssociado.html";
	}
		
	
}
