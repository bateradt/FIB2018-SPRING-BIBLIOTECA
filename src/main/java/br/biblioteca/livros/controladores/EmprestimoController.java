package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Emprestimo;
import br.biblioteca.livros.services.EmprestimoService;

@Controller
public class EmprestimoController {
	
	@Autowired
	private EmprestimoService emprestimoService;
		
	@RequestMapping("/emprestimo")
	public ModelAndView emprestimo() {
		
    List<Emprestimo> emprestimos = emprestimoService.listaEmprestimos();
				
	return new ModelAndView("livros/listaEmprestimo", "emprestimos", emprestimos);	
	}

}
