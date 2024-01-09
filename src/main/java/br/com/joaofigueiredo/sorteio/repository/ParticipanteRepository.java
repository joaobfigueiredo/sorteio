package br.com.joaofigueiredo.sorteio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.joaofigueiredo.sorteio.model.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Integer>{

	List<Participante> findAllByOrderByNomeAsc();



}
