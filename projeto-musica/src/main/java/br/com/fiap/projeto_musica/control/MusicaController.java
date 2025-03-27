package br.com.fiap.projeto_musica.control;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.projeto_musica.model.Musica;
import br.com.fiap.projeto_musica.respository.MusicaRepository;

@RestController
@RequestMapping(value = "/musicas")
public class MusicaController {

	@Autowired
	private MusicaRepository repM;

	@GetMapping(value = "/todas")
	public List<Musica> retornaTodasMusicas() {
		return repM.findAll();
	}

	@GetMapping(value = "/{id}")
	public Musica buscaPorID(@PathVariable Long id) {

		Optional<Musica> op = repM.findById(id);

		if (op.isPresent()) {
			return op.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(value = "/longas")
	public List<Musica> retornaMusicasLongaDuracao() {

		List<Musica> todas = repM.findAll();
		List<Musica> longas = new ArrayList<Musica>();

		for (Musica mus : todas) {

			if (mus.getDuracao() >= 4.0) {
				longas.add(mus);
			}

		}

		return longas;

	}
	
	@GetMapping(value = "/longas_otimizadas")
	public List<Musica> retornaMusicasLongas(){
		return repM.retornaListaMusicasLongas(4.0);
	}
	
	
	@GetMapping(value = "/musicas_novas")
	public List<Musica> retornaMusicasNovas(){
		return repM.retornaMusicasNovas(LocalDate.of(1985, 1, 1));
	}

	@PostMapping(value = "/inserir")
	public Musica inserirMusica(@RequestBody Musica musica) {
		repM.save(musica);
		return musica;
	}

	@PutMapping(value = "/atualizar/{id}")
	public Musica atualizarMusica(@RequestBody Musica musica, @PathVariable Long id) {

		Optional<Musica> op = repM.findById(id);

		if (op.isPresent()) {

			Musica musica_atual = op.get();

			musica_atual.setDataLancamento(musica.getDataLancamento());
			musica_atual.setDuracao(musica.getDuracao());
			musica_atual.setGenero(musica.getGenero());
			musica_atual.setTitulo(musica.getTitulo());

			repM.save(musica_atual);

			return musica_atual;

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(value = "/remover/{id}")
	public Musica removerMusica(@PathVariable Long id) {

		Optional<Musica> op = repM.findById(id);
		
		if(op.isPresent()) {
			
			Musica musica = op.get();
			repM.delete(musica);
			return musica;
			
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

}
