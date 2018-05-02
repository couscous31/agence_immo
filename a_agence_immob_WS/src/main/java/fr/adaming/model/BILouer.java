package fr.adaming.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Louer")
public class BILouer extends BienImmobilier {

	private double caution;
	private double loyer;
	private double charges;
	private String typeBail;
	private boolean meubles;

	// Constructeurs
	public BILouer() {
		super();
	}

	public BILouer(String statut, Date dateSoumission, Adresse adresse, Date dateDispo, double revenuCadastral,
			double prix, double caution, double loyer, double charges, String typeBail, boolean meubles) {
		super(statut, dateSoumission, adresse, dateDispo, revenuCadastral, prix);
		this.caution = caution;
		this.loyer = loyer;
		this.charges = charges;
		this.typeBail = typeBail;
		this.meubles = meubles;
	}

	public BILouer(int id, String statut, Date dateSoumission, Adresse adresse, Date dateDispo, double revenuCadastral,
			double prix, double caution, double loyer, double charges, String typeBail, boolean meubles) {
		super(id, statut, dateSoumission, adresse, dateDispo, revenuCadastral, prix);
		this.caution = caution;
		this.loyer = loyer;
		this.charges = charges;
		this.typeBail = typeBail;
		this.meubles = meubles;
	}

	// Getter et setter
	public double getCaution() {
		return caution;
	}

	public void setCaution(double caution) {
		this.caution = caution;
	}

	public double getLoyer() {
		return loyer;
	}

	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}

	public double getCharges() {
		return charges;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}

	public String getTypeBail() {
		return typeBail;
	}

	public void setTypeBail(String typeBail) {
		this.typeBail = typeBail;
	}

	public boolean isMeubles() {
		return meubles;
	}

	public void setMeubles(boolean meubles) {
		this.meubles = meubles;
	}

	@Override
	public String toString() {
		return "BILouer [caution=" + caution + ", loyer=" + loyer + ", charges=" + charges + ", typeBail=" + typeBail
				+ ", meubles=" + meubles + "]";
	}

}
