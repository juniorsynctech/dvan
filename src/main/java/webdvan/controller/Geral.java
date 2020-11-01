package webdvan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webdvan.models.Usuario;
import webdvan.repository.UsuarioRepository;

@Controller
public class Geral {

	@Autowired
	HttpSession session;
	UsuarioRepository ur;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {

		return "index.html";
	}

	@RequestMapping(value = "/cadastraUsuario", method = RequestMethod.GET)
	public String form() {

		return "dvan/CadastroUsuario.html";
	}

	@RequestMapping(value = "/associado", method = RequestMethod.GET)
	public String associado() {
		return "associado/formMenuAssociado.html";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "dvan/formLogin.html";
	}

	@RequestMapping(value = "/logar", method = RequestMethod.POST)
	public ModelAndView loginUsuario(String email, String senha, HttpSession session) {

		Usuario user = ur.findByEmailAndSenha(email, senha);
		session.setAttribute("usuario", user);
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}

}
