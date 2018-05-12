package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Usuario;
import br.biblioteca.livros.services.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
		
	//@RequestMapping("/usuario")
	@GetMapping("/usuario")
	public ModelAndView usuario() {
		
    List<Usuario> usuarios = usuarioService.listaUsuarios();
				
	return new ModelAndView("livros/listaUsuario", "usuarios", usuarios);	
	}
	
	@GetMapping("usuario/novoUsuario")
	public String createForm(@ModelAttribute Usuario usuario) {
		return "livros/formUsuario";
	}

	@PostMapping(params = "formUsuario")
	public ModelAndView create(Usuario usuario) {
		usuarioService.salvaUsuario(usuario);
		return new ModelAndView("redirect:/usuario");
	}

}
