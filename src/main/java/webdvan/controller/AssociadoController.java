package webdvan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class AssociadoController {
	
	@Autowired
	private RotaRepository rr;
	@Autowired
	private UsuarioRepository ur;
		
	@Autowired
	private CidadesRepository cd;

	public ArrayList<String> cidades;
		
	@RequestMapping(value ="/CadastroRota", method = RequestMethod.GET)
	public ModelAndView formCadastroRota() {
		ModelAndView mv = new ModelAndView("associado/formCadastroRota.html");

		cidades = new ArrayList<String>();
		for(Cidades c : cd.findAll()) {
			cidades.add(c.getCidade());
		}	
		mv.addObject("cidades", cidades);
		return mv;
	}
	
	@GetMapping(value = "/editarPerfil")
	public ModelAndView formEditarPerfil(HttpSession session) {
		ModelAndView mv = new ModelAndView("associado/formEditarPerfil");
		Usuario user = (Usuario) session.getAttribute("usuario");
		mv.addObject("usuario", user);
		System.out.println(user.getEmail()+" "+user.getSenha());
		return mv;
	}
	
	@RequestMapping(value = "/editarPerfil", method = RequestMethod.POST)
	public ModelAndView editarPerfil(Usuario usuario, HttpSession session) {
		ModelAndView mv = new ModelAndView("associado/formMenuAssociado");
		Usuario user = (Usuario) session.getAttribute("usuario");
		usuario.setId(user.getId());
		ur.save(usuario);
		session.setAttribute("usuario", usuario);		
		return mv;
	}
	
	@RequestMapping(value ="/MenuAssociado", method = RequestMethod.GET)
	public ModelAndView formMenuAssociado(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("associado/formMenuAssociado.html");
		mv.addObject("sessao", session);
		List<Rota> lista = rr.findAll();
		mv.addObject("rotas", lista);	
			
		
		
		return mv;
	}
	
	@RequestMapping(value ="/rota", method = RequestMethod.POST)
	public String cadastrar(Rota rota , HttpSession session) {
		
		Usuario us = (Usuario)session.getAttribute("usuario");
		rota.setIdUsuario(us.getId());
		rota.setConsulta();
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
