package br.biblioteca.livros.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="LIVRO")
public class Livro {
	
	@Id
	@GeneratedValue
	@Column(name = "LIV_ID")
	private Long idLivro;
	
	@Column(name = "LIV_TITULO", nullable = false, length = 45)
	private String titulo;
	
	@Column(name = "LIV_FOTO", nullable = true, length = 200)
	private String foto;
	
	@Column(name = "LIV_QUANTIDADE")
	private int quantidade;
	
	public int getQuantidadePaginas() {
		return quantidadePaginas;
	}
	public void setQuantidadePaginas(int quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}

	@Column(name = "LIV_QUANTIDADEPAGINAS")
	private int quantidadePaginas;
	
	@ManyToOne
	@JoinColumn(name = "ID_AUTOR")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Autor autor;
	
	@OneToMany(mappedBy = "livro")
	private List<Review> review = new ArrayList<>();
	
	public List<Review> getReview() {
		return review;
	}
	public void setReview(List<Review> review) {
		this.review = review;
	}
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	@OneToMany(mappedBy = "livro")
	private List<Emprestimo> emprestimos = new ArrayList<>();
	
	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public Long getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	} 

	@Override
	public String toString() {
		return "Livro [id=" + idLivro + ", nome=" + titulo + ", quantidadePaginas=" + quantidadePaginas + "]";
	}

}
