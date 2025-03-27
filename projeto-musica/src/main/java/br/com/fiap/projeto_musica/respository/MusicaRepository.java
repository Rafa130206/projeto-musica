package br.com.fiap.projeto_musica.respository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.projeto_musica.model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long>{
	
	@Query("from Musica mus where mus.duracao >= :duracao_longa")
	public List<Musica> retornaListaMusicasLongas(Double duracao_longa);
	
	@Query("from Musica mus where mus.dataLancamento >= :dt")
	public List<Musica> retornaMusicasNovas(LocalDate dt);

}
