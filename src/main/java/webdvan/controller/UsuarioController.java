package webdvan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webdvan.dto.RequisicaoEntrega;
import webdvan.models.Endereco;
import webdvan.models.Entrega;
import webdvan.models.Rota;
import webdvan.models.Usuario;
import webdvan.repository.EnderecoRepository;
import webdvan.repository.EntregaRepository;
import webdvan.repository.RotaRepository;
import webdvan.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository ur;
	
	@Autowired
	RotaRepository rr;
	
	@Autowired
	EnderecoRepository er;
	
	@Autowired
	EntregaRepository entregaRepository;
	
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
	public String menuCliente(HttpSession session, HttpServletRequest request) {
		Usuario user = (Usuario) session.getAttribute("usuario");
		List<Entrega> listaEntregaUsuario = entregaRepository.findByIdCliente(user.getId());
		List<Rota> listaRotas = rr.findAll();
		List<Usuario> listaUsuario = ur.findAll();
		List<Endereco> listaEndereco = er.findAll();
		request.setAttribute("listaEntrega", listaEntregaUsuario);
		request.setAttribute("listaRota", listaRotas);
		request.setAttribute("listaUsuario", listaUsuario);
		request.setAttribute("listaEndereco", listaEndereco);
		return "cliente/formMenuCliente";
	}
	
	@GetMapping(value = "/pedidoEntrega")
	public String pedido() {
		return "cliente/formNovaEntrega.html";
	}
	
	@GetMapping(value = "/pedidoEntrega?{id}")
	public ModelAndView pedidoEntrega(@PathVariable Long id, HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("cliente/formNovaEntrega.html");
		session.removeAttribute("buscaEntregaLista");
		return mv;
	}
	
	@PostMapping(value = "/pedidoEntrega")
	public String pedidoEntrega(RequisicaoEntrega reqEntrega, HttpSession session) {
		List<Endereco> enderecos = reqEntrega.toEndereco();
		
		Usuario	user = (Usuario) session.getAttribute("usuario");

		for (Endereco endereco : enderecos) {
			endereco.setIdAssociado(user.getId());
			er.save(endereco);
		}
		
		Entrega entrega = new Entrega();
		entrega.setIdEnderecoSaida(enderecos.get(0).getId());
		entrega.setIdEnderecoChegada(enderecos.get(1).getId());
		Rota rota = (Rota) session.getAttribute("rota");
		
		entrega.setNome(reqEntrega.getNome());
		entrega.setIdAssociado(rota.getIdUsuario());
		entrega.setIdCliente(user.getId());
		entrega.setIdRota(rota.getId());
		entrega.setStatus(1);
		
		entregaRepository.save(entrega);
		
		return "redirect:/MenuCliente";
	}
	
	@GetMapping(value="/entregue?{id}")
	public String entregue(@PathVariable long id) {
		Entrega entrega = entregaRepository.findById(id).get();
		entrega.setStatus(5);
		entregaRepository.save(entrega);
		return "redirect:/MenuCliente";
	}
		
}
