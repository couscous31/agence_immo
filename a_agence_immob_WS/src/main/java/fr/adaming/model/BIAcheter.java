package fr.adaming.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Acheter")
public class BIAcheter extends BienImmobilier {

	private double prixAchat;
	private String etat;

	// Constructeurs
	public BIAcheter() {
		super();
	}

	public BIAcheter(String statut, Date dateSoumission, Adresse adresse, Date dateDispo, double revenuCadastral,
			double prix, double prixAchat, String etat) {
		super(statut, dateSoumission, adresse, dateDispo, revenuCadastral, prix);
		this.prixAchat = prixAchat;
		this.etat = etat;
	}

	public BIAcheter(int id, String statut, Date dateSoumission, Adresse adresse, Date dateDispo,
			double revenuCadastral, double prix, double prixAchat, String etat) {
		super(id, statut, dateSoumission, adresse, dateDispo, revenuCadastral, prix);
		this.prixAchat = prixAchat;
		this.etat = etat;
	}

	// Getter et setter
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

	@Override
	public String toString() {
		return "BIAcheter [prixAchat=" + prixAchat + ", etat=" + etat + "]";
	}

}
