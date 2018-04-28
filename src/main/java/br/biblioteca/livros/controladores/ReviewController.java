package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Review;
import br.biblioteca.livros.services.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
		
	@RequestMapping("/review")
	public ModelAndView review () {
		
    List<Review> reviews = reviewService.listaReviews();
				
	return new ModelAndView("livros/listaReview", "reviews", reviews);	
	}

}
