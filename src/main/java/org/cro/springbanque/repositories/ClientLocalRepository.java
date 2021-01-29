package org.cro.springbanque.repositories;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.cro.springbanque.models.Client;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

//@Repository
public class ClientLocalRepository {

	private Set<Client> clients = new HashSet<Client>(List.of(new Client("2464986", "ROMANO", "Cyril", 20),
			new Client("795620133", "ROMANO", "Marco", 55), new Client("457992023", "STRIFE", "Clad", 23)));

	/**
	 * La liste compléte des client. Peux retourné une liste vide.
	 * 
	 * @return une liste de <code>Client</code> ou vide
	 */
	public Collection<Client> getAll() {
		return this.clients;
	}

	/**
	 * Recherche par ID strict. Retourne le <code>Client</code> si l'ID existe, null
	 * sinon.
	 * 
	 * @param id - l'identifiant interne du client
	 * @return un client existant, <code>null</code> sinon
	 */
	public Client findById(String id) {
		return this.clients.stream().filter(c -> c.getNumero().equals(id)).findFirst().orElse(null);
	}

	/**
	 * Recherche par NOM. Non sensible a la case. Retourne une
	 * <code>Collection</code> de <code>Client</code>
	 * 
	 * @param nom - le NOM du client recherché
	 * @return une <code>Collection</code> de <code>Client</code>, une
	 *         <code>Collection</code> vide sinon
	 */
	public Collection<Client> findByName(String nom) {
		return this.clients.stream().filter(c -> c.getNom().equalsIgnoreCase(nom)).collect(Collectors.toList());
	}

	/**
	 * Ajoute de façon unique le <code>Client</code> en fonction de son ID.
	 * 
	 * @deprecated <p> Utilisez {@link ClientRepository#save(Client)} plutôt.
	 * 
	 * @param client
	 * @return <code>true</code> s'il à été ajouté, <code>false</code> sinon
	 */
	@Deprecated
	public boolean create(Client client) {
		return this.clients.add(client);
	}

	/**
	 * Modifie un <code>Client</code>.
	 * 
	 * @param id 
	 * @param client
	 * @return
	 */
	@Deprecated
	public Client update(String id, Client client) {
		Client newClient = this.findById(id);
		newClient.setNom(client.getNom());
		newClient.setPrenom(client.getPrenom());
		newClient.setAge(client.getAge());
		return newClient;
	}

	public Client save(Client client) {
		this.clients.add(client);
		return client;
	}

	public Client delete(String id) {
		Client oldClient = this.clients.stream().filter(c -> c.getNumero().equals(id)).findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		this.clients.remove(oldClient);
		return oldClient;
	}

}
