package org.cro.springbanque.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("clients")
public class Client {
	
	@Id
	private String numero;
	
	private String nom;
	private String prenom;
	private int age;
	
	private List<ICompte> comptesBancaire;
	
	public Client() {}
	
	public Client(String numero, String nom, String prenom, int age) {
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.comptesBancaire = new ArrayList<ICompte>();
	}
	
	public Client(String numero, String nom, String prenom, int age, List<ICompte> comptes) {
		this(numero, nom, prenom, age);
		this.comptesBancaire = comptes;
	}

	public boolean addCompte(ICompte compte) {
		return this.comptesBancaire.add(compte);
	}
	
	public Optional<ICompte> getCompteBancaire(String numeroBancaire) {
		return this.comptesBancaire.stream().filter(c -> c.getNumero().equals(numeroBancaire)).findFirst();
	}	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(this.numero, other.numero);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.numero);
	}

	@Override
	public String toString() {
		return "[" + this.numero + "]" + this.nom + " " + this.prenom + " " + this.age + " ans\n"
				+ this.comptesBancaire.toString();
	}
	
}
