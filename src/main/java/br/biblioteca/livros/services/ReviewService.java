package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Review;
import br.biblioteca.livros.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	ReviewRepository reviewRepository;
	
	public List<Review> listaReviews(){
		return reviewRepository.findAll();
	}
	
}
