package br.com.amaurymartin.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amaurymartin.cursomc.domain.Cidade;
import br.com.amaurymartin.cursomc.repositories.CidadeRepository;
import br.com.amaurymartin.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public Cidade buscar(Integer id) throws ObjectNotFoundException {
		Optional<Cidade> obj = this.repository.findById(id);
		
		return obj.orElseThrow(() -> (
			new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName())
		)); 
	}
	
}
