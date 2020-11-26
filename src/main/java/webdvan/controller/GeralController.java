package webdvan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webdvan.dto.BuscaEntrega;
import webdvan.models.Cidades;
import webdvan.models.Rota;
import webdvan.models.Usuario;
import webdvan.repository.CidadesRepository;
import webdvan.repository.RotaRepository;
import webdvan.repository.UsuarioRepository;

@Controller
public class GeralController {

	@Autowired
	HttpSession session;

	@Autowired
	UsuarioRepository ur;

	@Autowired
	RotaRepository rr;

	@Autowired
	CidadesRepository cd;

	public ArrayList<String> cidades;

	BuscaEntrega buscaEntrega;
	public ArrayList<BuscaEntrega> buscaEntregaLista;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index(HttpSession session) {

		ModelAndView mv = new ModelAndView("index.html");

		cidades = new ArrayList<String>();
		for (Cidades c : cd.findAll()) {
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

	@RequestMapping(value = "/cadastraUsuario?{idRota}", method = RequestMethod.GET)
	public String formRota(@PathVariable Long idRota, HttpSession session) {
		Rota rota = rr.findById(idRota).get();
		session.setAttribute("rota", rota);
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
	public String loginUsuario(String email, String senha, HttpSession session, HttpServletResponse response)
			throws Exception {

		if (ur.findByEmailAndSenha(email, senha) == null) {
			session.setAttribute("falhaLogin", "Usuário não encontrado");
			return ("redirect:/login");
		} else {
			Usuario user = ur.findByEmailAndSenha(email, senha);
			session.setAttribute("usuario", user);
			if (session.getAttribute("rota") != null) {
				return ("redirect:/pedidoEntrega");
			}
			return ("redirect:/");
		}
	}

	@RequestMapping(value = "/pesquisarRotas", method = RequestMethod.GET)
	public ModelAndView pesquisarRotas(String consulta, HttpSession session) {

		ModelAndView mv = new ModelAndView("redirect:/");

		List<Rota> rotas = rr.findByConsultaContaining(consulta);
		buscaEntregaLista = new ArrayList<>();

		for (Rota r : rotas) {

			Usuario us = ur.findById(rotas.get(0).getIdUsuario()).get();
			buscaEntrega = new BuscaEntrega();
			buscaEntrega.setContatoAssociado(us.getTelefone());
			buscaEntrega.setConsulta(r.getConsulta());
			buscaEntrega.setNomeAssociado(us.getEmail());
			buscaEntrega.setIdRota(r.getId());
			buscaEntregaLista.add(buscaEntrega);
		}

		session.setAttribute("buscaEntregaLista", buscaEntregaLista);

		return mv;
	}

	@PostMapping(value = "/limparLista")
	public ModelAndView limparLista(HttpSession session) {
		session.removeAttribute("buscaEntregaLista");
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}

}
