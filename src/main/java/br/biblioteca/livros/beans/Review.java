package br.biblioteca.livros.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="REVIEW")
public class Review {
	
	@Id
	@GeneratedValue
	@Column(name = "REV_ID")
	private Long reviewId;
	
	@Column(name = "REV_AVALIACAO")
	private int avaliacao;
	
	@Column(name = "REV_COMENTARIO", nullable = true, length = 45)
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "ID_LIVRO")
	private Livro livro;
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Long getReviewId() {
		return reviewId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	public int getAvalidacao() {
		return avaliacao;
	}
	public void setAvalidacao(int avalidacao) {
		this.avaliacao = avalidacao;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	@Override
	public String toString() {
		return "Livro [reviewId=" + reviewId + ", avaliacao=" + avaliacao + ", comentario=" + comentario + "]";
	}

 
}
