package org.cro.springbanque.models;

public abstract class Compte implements ICompte {
	private String numero;
	private double solde;
	private String devise;
	
	@Override
	public String getNumero() {
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

	public boolean equals(ICompte obj) {
		return this.numero.equals(obj.getNumero());
	}

	
	@Override
	public String toString() {
		return this.numero + "{" + this.solde + " " + this.devise + "}";
	}
	

}
