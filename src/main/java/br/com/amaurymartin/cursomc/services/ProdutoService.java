package br.com.amaurymartin.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amaurymartin.cursomc.domain.Produto;
import br.com.amaurymartin.cursomc.repositories.ProdutoRepository;
import br.com.amaurymartin.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public Produto buscar(Integer id) throws ObjectNotFoundException {
		Optional<Produto> obj = this.repository.findById(id);
		
		return obj.orElseThrow(() -> (
			new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName())
		)); 
	}
	
}
