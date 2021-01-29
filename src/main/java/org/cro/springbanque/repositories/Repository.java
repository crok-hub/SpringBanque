package org.cro.springbanque.repositories;

import java.util.Collection;

import org.cro.springbanque.models.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository<T, ID> extends MongoRepository<Client, String>{

	public Collection<Client> getAll();
	
	public Client findById(String id);
	
	public Collection<Client> findByName(String nom);
	
	public Client save(Client client);
	
	public Client delete(String id);
	
}
