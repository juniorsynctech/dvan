package webdvan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webdvan.models.Cidades;
import webdvan.models.Endereco;
import webdvan.models.Entrega;
import webdvan.models.Rota;
import webdvan.models.Usuario;
import webdvan.repository.CidadesRepository;
import webdvan.repository.EnderecoRepository;
import webdvan.repository.EntregaRepository;
import webdvan.repository.RotaRepository;
import webdvan.repository.UsuarioRepository;

@Controller
public class AssociadoController {
	
	@Autowired
	private RotaRepository rr;
	@Autowired
	private UsuarioRepository ur;
		
	@Autowired
	private EnderecoRepository er;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private CidadesRepository cd;

	public ArrayList<String> cidades;
		
	@RequestMapping(value ="/CadastroRota", method = RequestMethod.GET)
	public ModelAndView formCadastroRota(HttpSession session) {
		if (session.getAttribute("usuario") == null) {
			ModelAndView mv = new ModelAndView("redirect:/");
			return mv;
		}
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
		if (session.getAttribute("usuario") == null) {
			ModelAndView mv = new ModelAndView("redirect:/");
			return mv;
		}
		ModelAndView mv = new ModelAndView("associado/formEditarPerfil");
		Usuario user = (Usuario) session.getAttribute("usuario");
		mv.addObject("usuario", user);
		System.out.println(user.getEmail()+" "+user.getSenha());
		return mv;
	}
	
	@RequestMapping(value = "/editarPerfil", method = RequestMethod.POST)
	public ModelAndView editarPerfil(Usuario usuario, HttpSession session, Endereco endereco) {
		ModelAndView mv = new ModelAndView("associado/formMenuAssociado");
		Usuario user = (Usuario) session.getAttribute("usuario");
		usuario.setEnderecos(endereco);
		usuario.setId(user.getId());
		usuario.setTipo(user.getTipo());
		usuario.setTelefone(user.getTelefone());
		ur.save(usuario);
		session.setAttribute("usuario", usuario);	
		
		return mv;
	}
	
	@RequestMapping(value ="/MenuAssociado", method = RequestMethod.GET)
	public ModelAndView formMenuAssociado(HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("usuario") == null) {
			ModelAndView mv = new ModelAndView("redirect:/");
			return mv;
		}
		ModelAndView mv = new ModelAndView("associado/formMenuAssociado.html");
		Usuario user = (Usuario) session.getAttribute("usuario");
		List<Entrega> listaEntregaUsuario = entregaRepository.findByIdAssociado(user.getId());
		List<Rota> listaRotas = rr.findAll();
		List<Usuario> listaUsuario = ur.findAll();
		List<Endereco> listaEndereco = er.findAll();
		request.setAttribute("listaEntrega", listaEntregaUsuario);
		request.setAttribute("listaRota", listaRotas);
		request.setAttribute("listaUsuario", listaUsuario);
		request.setAttribute("listaEndereco", listaEndereco);		
		return mv;
	}
	
	@RequestMapping(value ="/rota", method = RequestMethod.POST)
	public String cadastrar(Rota rota , HttpSession session) {
		Usuario us = (Usuario)session.getAttribute("usuario");
		rota.setIdUsuario(us.getId());
		rota.setConsulta();
		rr.save(rota);
		return "redirect:/CadastroRota";
	}
	
	@RequestMapping(value ="/rotas", method = RequestMethod.POST)
	public String ExibeRotas(Rota rota) {
		
		return "";
	}
	
	@RequestMapping(value ="/ListarRotas", method = RequestMethod.GET)
	public ModelAndView Listar(HttpSession session) {
		if (session.getAttribute("usuario") == null) {
			ModelAndView mv = new ModelAndView("redirect:/");
			return mv;
		}
		Usuario user = (Usuario) session.getAttribute("usuario");
		
		ModelAndView mv = new ModelAndView("associado/formListaRotas.html");
		Iterable<Rota> lista = rr.findByIdUsuario(user.getId());
		mv.addObject("rotas", lista);		
		return mv;
	}
	
	@GetMapping(value = "/ativarRota?{id}")
	public ModelAndView ativarRota(@PathVariable Long id, HttpSession session) {
		if (session.getAttribute("usuario") == null) {
			ModelAndView mv = new ModelAndView("redirect:/");
			return mv;
		}
		Optional<Rota> rt = rr.findById(id);
		Rota rota = rt.get();
		rota.setStatus(1);
		rr.save(rota);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListarRotas");
		return mv;
		
	}
	
	@GetMapping(value = "/desativarRota?{id}")
	public ModelAndView desativarRota(@PathVariable Long id, HttpSession session) {
		if (session.getAttribute("usuario") == null) {
			ModelAndView mv = new ModelAndView("redirect:/");
			return mv;
		}
		Optional<Rota> rt = rr.findById(id);
		Rota rota = rt.get();
		rota.setStatus(2);
		rr.save(rota);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListarRotas");
		return mv;
	}
	
	@GetMapping(value="/atualizarStatus?{id}")
	public String atualizarStatus(@PathVariable long id, HttpSession session) {
		if (session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		Entrega entrega = entregaRepository.findById(id).get();
		entrega.setStatus((entrega.getStatus()+1));
		entregaRepository.save(entrega);
		return "redirect:/MenuAssociado";
	}
}
