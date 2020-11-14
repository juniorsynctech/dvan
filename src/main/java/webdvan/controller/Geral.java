package webdvan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webdvan.models.Rota;
import webdvan.models.Usuario;
import webdvan.repository.RotaRepository;
import webdvan.repository.UsuarioRepository;

@Controller
public class Geral {

	@Autowired
	HttpSession session;
	
	@Autowired
	UsuarioRepository ur;
	
	@Autowired
	RotaRepository rr;

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
	public ModelAndView loginUsuario(String email, String senha, HttpSession session) throws Exception {

		try {
			Usuario user = ur.findByEmailAndSenha(email, senha);
			session.setAttribute("usuario", user);
			ModelAndView mv = new ModelAndView("redirect:/");
			return mv;
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("redirect:/login");
			mv.addObject("falhaLogin", "Usuário não encontrado");
			return mv;
		}
	}
	
	@GetMapping(value="/pesquisarRotas")
	public ModelAndView pesquisarRotas(String consulta) {
		ModelAndView mv = new ModelAndView("redirect:/");
		List<Rota> rotas = rr.findByCidadeDestino(consulta);
		mv.addObject(rotas);
		return mv;
	}

}
