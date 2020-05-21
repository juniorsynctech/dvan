package webdvan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Geral {
	
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/index.html")
	public String retornaindex() {
		return "index";
	}
	
	@RequestMapping("/about.html")
	public String about() {
		return "about";
	}
	

}
