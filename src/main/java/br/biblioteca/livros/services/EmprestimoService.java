package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Emprestimo;
import br.biblioteca.livros.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	EmprestimoRepository emprestimoRepository;
	
	public List<Emprestimo> listaEmprestimos(){
		return emprestimoRepository.findAll();
	}
	
}
