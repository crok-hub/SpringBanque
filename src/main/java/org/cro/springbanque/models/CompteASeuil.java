package org.cro.springbanque.models;

public class CompteASeuil extends Compte implements ICompteASeuil {
	private double seuil; // Probablement 0 et négatif
	
	@Override
	public double getSeuil() {
		return this.seuil;
	}
	
	@Override
	public void setSeuil(double seuil) {
		this.seuil = seuil;		
	}

	@Override
	public void operation(double montant) throws IllegalOperationException {
		if (this.getSolde() - montant > this.seuil) {
			super.operation(montant);
		} else {
			throw new IllegalOperationException("Seuil dépassé ! Transaction annulé.");
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + " Seuil:" + this.seuil + " " + super.getDevise();
	}

}
