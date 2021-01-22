package org.cro.springbanque.models;

public class CompteASeuilRemunere extends CompteASeuil implements ICompteRemunere {
	private double taux; // Probablement 0 et négatif

	@Override
	public double getTaux() {
		return this.taux;
	}

	@Override
	public void setTaux(double taux) {
		this.taux = taux;	
	}

	@Override
	public double calculerInterets() {
		return  (this.getSolde() * this.taux);
	}

	@Override
	public void verserInterets() {
		try {
			this.operation(this.calculerInterets());
		} catch (Exception e) {
			// TODO: ... oups !? 
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + " Taux:" + this.taux + "%";
	}
}
