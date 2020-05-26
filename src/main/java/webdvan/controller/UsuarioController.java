package webdvan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import webdvan.models.Usuario;
import webdvan.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository ur;
	
	@RequestMapping(value ="CadastroUsuario", method = RequestMethod.GET)
	public String form() {
		return "formCadastroUsuario.html";
	}
	
	@RequestMapping(value ="/usuario", method = RequestMethod.POST)
	public String cadastrar(Usuario usuario) {
		ur.save(usuario);
		return "index.html";
	}

}
