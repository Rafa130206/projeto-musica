package br.com.fiap.projeto_musica.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artista")
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome_banda;
	private LocalDate  data_fundacao;
	private String pais_origem;

	public Artista() {

	}

	public Artista(Long id, String nome_banda, LocalDate  data_fundacao, String pais_origem) {
		super();
		this.id = id;
		this.nome_banda = nome_banda;
		this.data_fundacao = data_fundacao;
		this.pais_origem = pais_origem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_banda() {
		return nome_banda;
	}

	public void setNome_banda(String nome_banda) {
		this.nome_banda = nome_banda;
	}

	public LocalDate  getData_fundacao() {
		return data_fundacao;
	}

	public void setData_fundacao(LocalDate  data_fundacao) {
		this.data_fundacao = data_fundacao;
	}

	public String getPais_origem() {
		return pais_origem;
	}

	public void setPais_origem(String pais_origem) {
		this.pais_origem = pais_origem;
	}

}
