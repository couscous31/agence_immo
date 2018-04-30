package fr.adaming.model;

import java.util.Date;

public class BIAcheter extends BienImmobilier {
	
	private double prixAchat;
	private String etat;
	public double getPrixAchat() {
		return prixAchat;
	}
	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public BIAcheter(double prixAchat, String etat) {
		super();
		this.prixAchat = prixAchat;
		this.etat = etat;
	}
	public BIAcheter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BIAcheter(int id, String statut, Date dateSoumission, Adresse adresse, Date dateDispo,
			double revenuCadastral, double prix) {
		super(id, statut, dateSoumission, adresse, dateDispo, revenuCadastral, prix);
		// TODO Auto-generated constructor stub
	}
	public BIAcheter(String statut, Date dateSoumission, Adresse adresse, Date dateDispo, double revenuCadastral,
			double prix) {
		super(statut, dateSoumission, adresse, dateDispo, revenuCadastral, prix);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BIAcheter [prixAchat=" + prixAchat + ", etat=" + etat + "]";
	}

	
	

}
