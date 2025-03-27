package br.com.fiap.projeto_musica.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "integrante")
public class Integrante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_artista")
	private Artista artista;
	private String funcao;
	private String nome;
	private LocalDate  data_nascimento;

	public Integrante() {

	}

	public Integrante(Long id, Artista artista, String funcao, String nome, LocalDate  data_nascimento) {
		super();
		this.id = id;
		this.artista = artista;
		this.funcao = funcao;
		this.nome = nome;
		this.data_nascimento = data_nascimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate  getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate  data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

}
