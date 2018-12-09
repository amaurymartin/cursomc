package br.com.amaurymartin.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.amaurymartin.cursomc.domain.Cidade;
import br.com.amaurymartin.cursomc.services.CidadeService;

@RestController
@RequestMapping(value="/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cidade> buscar(@PathVariable Integer id) {
			return ResponseEntity.ok().body(this.service.buscar(id));
	}
	
}
