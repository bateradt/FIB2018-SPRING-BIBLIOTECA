package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.repository.AutorRepository;
import br.biblioteca.livros.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	AutorRepository autorRepository;
	
	public List<Livro> listaLivros(){
		return this.livroRepository.findAll();
	}
	
	public Livro salvaLivro(Livro livro) {		
		Autor autor = autorRepository.findOne(1L);
		livro.setAutor(autor);
		return this.livroRepository.save(livro);
	}
	
	public Livro buscaLivro(Long id) {		
		return this.livroRepository.findOne(id);
	}
	
	public void deletaLivro(Long id) {			
		this.livroRepository.delete(id);
	}
	
}
