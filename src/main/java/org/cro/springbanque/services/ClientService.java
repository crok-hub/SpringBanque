package org.cro.springbanque.services;

import java.util.Collection;

import org.cro.springbanque.models.Client;
import org.cro.springbanque.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Collection<Client> getAll() {
		return this.repository.getAll();
	}
	
	public Client findById(String id) {
		return this.repository.findById(id);
	}

	public Collection<Client> findByName(String nom) {
		return this.repository.findByName(nom);
	}

	@Deprecated
	public boolean create(Client client) {
		return this.repository.create(client);
	}

	@Deprecated
	public Client update(String id, Client client) {
		return this.repository.update(id, client);
	}
	
	public Client save(Client client) {
		return this.repository.save(client);
	}
	
	public Client delete(String id) {
		return this.repository.delete(id);
	}

}
