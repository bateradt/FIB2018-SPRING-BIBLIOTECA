package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.services.LivroService;

@Controller
public class LivroController {

	// public static final

	@Autowired
	private LivroService livroService;

	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("Index");
	}

	@GetMapping("/livros")
	public ModelAndView livros() {
		List<Livro> livros = livroService.listaLivros();
		return new ModelAndView("livros/livros", "livros", livros);
	}

	@GetMapping("livros/novo")
	public String createForm(@ModelAttribute Livro livro) {
		return "livros/form";
	}

	@PostMapping(params = "form")
	public ModelAndView create(Livro livro) {
		livroService.salvaLivro(livro);
		return new ModelAndView("redirect:/livros");
	}

}
