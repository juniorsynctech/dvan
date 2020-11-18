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
public class UsuarioController {
	
	@Autowired
	UsuarioRepository ur;
	
	@Autowired
	RotaRepository rr;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value ="/usuario", method = RequestMethod.POST)
	public String cadastrar(Usuario usuario , HttpSession session ) {

		ur.save(usuario);
		session.setAttribute("usuario", usuario);
		return "redirect:/";
		
	}
	
	
	@RequestMapping(value ="/deslogar", method = RequestMethod.GET)
	public String deslogar(HttpSession session ) {
		
		session.invalidate();
		return "redirect:/";
			
	}
	
	@GetMapping(value = "MenuCliente")
	public String menuCliente() {
		return "cliente/formMenuCliente";
	}
	
	@GetMapping(value = "/pedidoEntrega")
	public String pedido() {
		return "cliente/formNovaEntrega.html";
	}
		
}
