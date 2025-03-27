package br.com.fiap.projeto_musica.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "musica")
public class Musica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_artista")
	private Artista artista;
	@NotEmpty(message = "Valor inválido para gênero")
	@Size(min = 3, max = 40, message = "Valor inválido para gênero. Entre com uma string que"
			+ " respeite o seguinte intervalo: min 3 caracteres e max 40 caaracteres")
	private String genero;
	@PastOrPresent(message = "Data inválida")
	private LocalDate dataLancamento;
	@DecimalMin("0.05")
	private Double duracao;
	@NotEmpty(message = "Valor inválido para o título")
	@Size(min = 3, max = 200, message = "Valor inválido para título. Entre com uma string que"
			+ " respeite o seguinte intervalo: min 3 caracteres e max 200 caaracteres")
	private String titulo;

	public Musica() {

	}

	public Musica(Long id, Artista artista, String genero, LocalDate  dataLancamento, Double duracao, String titulo) {
		super();
		this.id = id;
		this.artista = artista;
		this.genero = genero;
		this.dataLancamento = dataLancamento;
		this.duracao = duracao;
		this.titulo = titulo;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate  getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate  dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Double getDuracao() {
		return duracao;
	}

	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
