package br.com.joaofigueiredo.sorteio.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaofigueiredo.sorteio.model.Participante;
import br.com.joaofigueiredo.sorteio.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
	
	@Autowired
	private ParticipanteRepository repository;

	public void salvar(@Valid Participante participante) {
		repository.save(participante);
	}

	public List<Participante> buscarTodos() {
		return repository.findAll();
	}

	public Optional<Participante> buscarPorId(Integer id) {
		return repository.findById(id);
	}

	public void remover(Participante participante) {
		repository.delete(participante);
	}

}
