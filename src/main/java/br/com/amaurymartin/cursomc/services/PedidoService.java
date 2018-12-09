package br.com.amaurymartin.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amaurymartin.cursomc.domain.Pedido;
import br.com.amaurymartin.cursomc.repositories.PedidoRepository;
import br.com.amaurymartin.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	public Pedido buscar(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> obj = this.repository.findById(id);
		
		return obj.orElseThrow(() -> (
			new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())
		)); 
	}
	
}
