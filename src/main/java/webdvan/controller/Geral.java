package webdvan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webdvan.models.Cidades;
import webdvan.models.Rota;
import webdvan.models.Usuario;
import webdvan.repository.CidadesRepository;
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
	
	@Autowired
	CidadesRepository cd;
	
	public ArrayList<String> cidades;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index(HttpSession session) {
		
		ModelAndView mv = new ModelAndView("index.html");

		cidades = new ArrayList<String>();
		for(Cidades c : cd.findAll()) {
			cidades.add(c.getCidade());
		}	
		mv.addObject("cidades", cidades);
		
		if (session.getAttribute("falhaLogin") != null) {
			session.removeAttribute("falhaLogin");
		}
		
		
		
		return mv;
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
	public String login(HttpServletRequest request) {
		return "dvan/formLogin.html";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUsuario(String email, String senha, HttpSession session, HttpServletResponse response) throws Exception {
		
		
		if (ur.findByEmailAndSenha(email, senha) == null) {
			session.setAttribute("falhaLogin", "Usuário não encontrado");
			return ("redirect:/login");
		} else {
			Usuario user = ur.findByEmailAndSenha(email, senha);
			session.setAttribute("usuario", user);
			return ("redirect:/");
		}
	}

	@GetMapping(value = "/pesquisarRotas")
	public String pesquisarRotas(String consulta, HttpSession session) {
		List<Rota> rotas = rr.findByConsultaContaining(consulta);
		for (Rota rota : rotas) {
			System.out.println(rota.getCidadeDestino());
		}
		session.setAttribute("entregas", rotas);
		return "redirect:/";
	}

}
