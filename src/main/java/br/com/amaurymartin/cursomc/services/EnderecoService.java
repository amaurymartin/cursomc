package br.com.amaurymartin.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amaurymartin.cursomc.domain.Endereco;
import br.com.amaurymartin.cursomc.repositories.EnderecoRepository;
import br.com.amaurymartin.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	public Endereco buscar(Integer id) throws ObjectNotFoundException {
		Optional<Endereco> obj = this.repository.findById(id);
		
		return obj.orElseThrow(() -> (
			new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName())
		)); 
	}
	
}
