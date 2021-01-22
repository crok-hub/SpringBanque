package org.cro.springbanque.models;

public interface ICompteRemunere extends ICompte {
	public double getTaux();
	public void setTaux(double taux);
	
	public double calculerInterets();
	public void verserInterets();
}
