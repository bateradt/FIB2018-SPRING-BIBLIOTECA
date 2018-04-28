package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.services.LivroService;

@Controller
public class LivroController {
	
	//public static final 
	
	@Autowired
	private LivroService livroService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("Index");
	}
	
	@RequestMapping("/livros")
	public ModelAndView livros() {
		
    List<Livro> livros = livroService.listaLivros();
		
//		for (Livro livro : livros) {
//			
//			System.out.println(livro.getNome());
//		}
		
	  return new ModelAndView("livros/livros", "livros", livros);	
	}

}
