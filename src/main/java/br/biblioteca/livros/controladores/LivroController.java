package br.biblioteca.livros.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.services.AutorService;
import br.biblioteca.livros.services.LivroService;
import br.biblioteca.livros.util.FileSaver;

@Controller
public class LivroController {

	// public static final

	@Autowired
	private LivroService livroService;
	
	@Autowired
	private FileSaver fileSaver;
	
	@Autowired
	private AutorService autorService;

	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("Index");
	}

	@GetMapping("/livros")
	public ModelAndView livros() {
		List<Livro> livros = livroService.listaLivros();
		return new ModelAndView("livros/livros", "livros", livros);
	}

//	@GetMapping("livros/novo")
//	public String createForm(@ModelAttribute Livro livro) {
//		return "livros/form";
//	}
	
	@GetMapping("livros/novo")
	public ModelAndView createForm(@ModelAttribute Livro livro) {
		
		ModelAndView modelAndView = new ModelAndView("livros/form");
		
		List<Autor> autores = autorService.listaAutores();
		
		modelAndView.addObject("autores", autores);
		
		return modelAndView;
	}

	@PostMapping(params = "form")
	public ModelAndView create(@RequestParam("capaUrl") MultipartFile capaUrl,
			@ModelAttribute("livro") @Valid Livro livro, BindingResult bindingResult, Model model) {
//		
//		if (capaUrl.getOriginalFilename().equals("")) {
//			model.addAttribute("message", "A capa não pode ser vazia");
//			return new ModelAndView("livros/form");
//		} else {
//			if (capaUrl.getContentType().equals("image/jpeg")) {
//				String webPath = fileSaver.write("uploaded-images", capaUrl);
//				livro.setCapa(webPath);
//			} else {
//				model.addAttribute("message", "Arquivo em formato errado. Permitido apenas jpg");
//				return new ModelAndView("livros/form");
//			}
//		}
		
//		if (bindingResult.hasErrors()) {
//			return new ModelAndView("livros/form");
//		}
		
		if (livro.getIdLivro() != null) {
			if (capaUrl.getOriginalFilename().length() > 0) {
				incluiCapa(capaUrl, livro, model);
			}
		} else {
			if (capaUrl.getOriginalFilename().equals("")) {
				model.addAttribute("capa", "A capa não pode ser vazia");
			} else {
				incluiCapa(capaUrl, livro, model);
			}
		}
		
		if (bindingResult.hasErrors()  || model.containsAttribute("message")) {
			List<Autor> autores = autorService.listaAutores();
			return new ModelAndView("livros/form", "autores", autores);
		}

		livroService.salvaLivro(livro);
		return new ModelAndView("redirect:/livros");
	}

	@GetMapping("livros/alterar/{idLivro}")
	public ModelAndView alterar(@PathVariable("idLivro") Long id) {
		Livro livro = this.livroService.buscaLivro(id);
		return new ModelAndView("livros/form", "livro", livro);
	}

	@GetMapping("livros/excluir/{idLivro}")
	public ModelAndView excluir(@PathVariable("idLivro") Long id) {
		this.livroService.deletaLivro(id);
		return new ModelAndView("redirect:/livros");
	}
	
	private void incluiCapa(MultipartFile capaUrl, Livro livro, Model model) {
		if (capaUrl.getContentType().equals("image/jpeg")) {
			String webPath = fileSaver.write("uploaded-images", capaUrl);
			livro.setCapa(webPath);
		} else {
			model.addAttribute("capa", "Arquivo em formato errado. Permitido apenas jpg");
		}
	}

}
