package org.cro.springbanque.controlers;


import java.util.Collection;
import java.util.Optional;

import org.cro.springbanque.models.Client;
import org.cro.springbanque.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clients")
public class ClientControler {
	
	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<Collection<Client>> clients() {
		Collection<Client> clients = this.service.getAll();
		if (clients.isEmpty()) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(clients);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> findById(@PathVariable String id) {
		return Optional
				.ofNullable(this.service.findById(id))
				.map(c -> ResponseEntity.ok().body(c))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nom/{nom}")
	public ResponseEntity<Collection<Client>> findByName(@PathVariable String nom) {
		Collection<Client> clients = this.service.findByName(nom);	
		if (clients.isEmpty()) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(clients);
	}
	
//	@PostMapping
//	public ResponseEntity<Void> create(@RequestBody Client client) {
//		if (this.service.create(client)) return new ResponseEntity<Void>( HttpStatus.CREATED );
//		return new ResponseEntity<Void>( HttpStatus.UNPROCESSABLE_ENTITY );
//	}
//	
//	@PutMapping("/{id}")
//	public Client update(@PathVariable String id, @RequestBody Client client) {
//		return this.service.update(id, client);
//	}
	
	@PutMapping("/{id}")
	public Client update(@PathVariable String id, @RequestBody Client client) {
		return this.service.update(id, client);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Client delete(@PathVariable String id) {
		return this.service.delete(id);
	}
	
}
