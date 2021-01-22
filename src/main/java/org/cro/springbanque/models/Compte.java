package org.cro.springbanque.models;

public abstract class Compte implements ICompte {
	private int numero;
	private double solde;
	private String devise;
	
	@Override
	public int getNumero() {
		return this.numero;
	}

	@Override
	public double getSolde() {
		return this.solde;
	}

	@Override
	public String getDevise() {
		return this.devise;
	}

	@Override
	public void operation(double montant) throws IllegalOperationException {
		this.solde += montant;
	}

	@Override
	public String toString() {
		return this.numero + "{" + this.solde + " " + this.devise + "}";
	}
	

}
