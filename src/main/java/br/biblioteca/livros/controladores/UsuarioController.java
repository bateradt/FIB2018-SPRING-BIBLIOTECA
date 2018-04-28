package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Usuario;
import br.biblioteca.livros.services.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
		
	@RequestMapping("/usuario")
	public ModelAndView usuario() {
		
    List<Usuario> usuarios = usuarioService.listaUsuarios();
				
	return new ModelAndView("livros/listaUsuario", "usuarios", usuarios);	
	}

}
