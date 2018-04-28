package br.biblioteca.livros.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EMPRESTIMO")
public class Emprestimo {
	
	@Id
	@GeneratedValue
	@Column(name = "EMP_ID")
	private Long idEmprestimo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EMP_DATAEMPRESTIMO", nullable = true)
	private Date dataEmprestimo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EMP_DATADEVOLUCAO", nullable = true)
	private Date dataDevolucao;
	
	@ManyToOne
	@JoinColumn(name = "ID_LIVRO")
	private Livro livro;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
		
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
	public Long getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(Long idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	@Override
	public String toString() {
		return "Emprestimo [id=" + idEmprestimo + "]";
	}
	
}
