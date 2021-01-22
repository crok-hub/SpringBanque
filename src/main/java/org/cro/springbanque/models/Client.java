package org.cro.springbanque.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Client {
	private String nom;
	private String prenom;
	private int age;
	private int numero;
	
	private List<ICompte> comptesBancaire;
	
	public Client(int numero, String nom, String prenom, int age) {
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.comptesBancaire = new ArrayList<ICompte>();
	}
	
	public Client(int numero, String nom, String prenom, int age, List<ICompte> comptes) {
		this(numero, nom, prenom, age);
		this.comptesBancaire = comptes;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumero() {
		return numero;
	}

	public boolean addCompte(ICompte compte) {
		return this.comptesBancaire.add(compte);
	}
	
	public Optional<ICompte> getCompteBancaire(int numeroBancaire) {
		return this.comptesBancaire.stream().filter(c -> c.getNumero() == numeroBancaire).findFirst();
	}
	
	public String toString() {
		return "[" + this.numero + "]" + this.nom + " " + this.prenom + " " + this.age + " ans\n"
				+ this.comptesBancaire.toString();
	}
}
