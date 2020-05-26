package webdvan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Geral {
	
	@RequestMapping(value ="", method = RequestMethod.GET)
	public String index() {
		return "index.html";
	}
	
	@RequestMapping(value ="/associado", method = RequestMethod.GET)
	public String associado() {
		return "associado.html";
	}
	
	@RequestMapping(value ="/cliente", method = RequestMethod.GET)
	public String cliente() {
		return "cliente.html";
	}
	
	@RequestMapping(value ="/dvan", method = RequestMethod.GET)
	public String dvan() {
		return "dvan.html";
	}

}
