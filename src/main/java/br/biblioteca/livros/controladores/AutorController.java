package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.services.AutorService;

@Controller
public class AutorController {
	
	//public static final 
	
	@Autowired
	private AutorService autorService;
	
//	@RequestMapping("/")
//	public ModelAndView home() {
//		return new ModelAndView("Index");
//	}
	
	@RequestMapping("/autor")
	public ModelAndView autor() {
		
    List<Autor> autores = autorService.listaAutores();
		
//		for (Livro livro : livros) {
//			
//			System.out.println(livro.getNome());
//		}
		
	  return new ModelAndView("livros/listaAutor", "autores", autores);	
	}

}
