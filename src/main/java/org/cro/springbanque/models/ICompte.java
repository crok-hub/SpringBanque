package org.cro.springbanque.models;

public interface ICompte {

	public String getNumero();
	public double getSolde();
	public String getDevise();
	
	/**
	 * Ajoute ou retire le {@code montant} au solde
	 * 
	 * @param montant négatif pour les retrait, positif pour le dépôt
	 * @throws IllegalOperationException en cas d'opétation impossible
	 */
	public void operation(double montant) throws IllegalOperationException;
}
