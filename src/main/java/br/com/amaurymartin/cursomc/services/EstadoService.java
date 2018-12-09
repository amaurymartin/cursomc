package br.com.amaurymartin.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amaurymartin.cursomc.domain.Estado;
import br.com.amaurymartin.cursomc.repositories.EstadoRepository;
import br.com.amaurymartin.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;
	
	public Estado buscar(Integer id) throws ObjectNotFoundException {
		Optional<Estado> obj = this.repository.findById(id);
		
		return obj.orElseThrow(() -> (
			new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName())
		)); 
	}
	
}
