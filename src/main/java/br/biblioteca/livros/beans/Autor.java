package br.biblioteca.livros.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="AUTOR")
public class Autor {
	
	@Id
	@GeneratedValue
	@Column(name = "AUT_ID")
	private Long idAutor;
	
	@Column(name = "AUT_NOME", nullable = false, length = 45)
	private String nome;
	
	@OneToMany(mappedBy = "autor", fetch = FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Livro> livros = new ArrayList<>();
	
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	public Long getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String Nome) {
		nome = Nome;
	}
	
	@Override
	public String toString() {
		return "Autor [id=" + idAutor + ", nome=" + nome + "]";
	}


}
