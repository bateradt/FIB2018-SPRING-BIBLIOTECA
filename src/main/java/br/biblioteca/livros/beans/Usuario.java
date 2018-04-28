package br.biblioteca.livros.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue
	@Column(name = "USU_ID")
	private Long usuarioId;
	
	@Column(name = "USU_USUARIO", nullable = false, length = 45)
	private String userName;
	
	@Column(name = "USU_EMAIL", nullable = false, length = 45)
	private String email;
	
	@Column(name = "USU_SENHA", nullable = false, length = 45)
	private String password;
	
	@OneToMany(mappedBy = "usuario")
	private List<Emprestimo> emprestimos = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuario")
	private List<Review> reviews = new ArrayList<>();
	
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	public List<Review> getReview() {
		return reviews;
	}
	public void setReview(List<Review> review) {
		this.reviews = review;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Usuario [reviewId=" + usuarioId + ", userName=" + userName + "]";
	}

}
