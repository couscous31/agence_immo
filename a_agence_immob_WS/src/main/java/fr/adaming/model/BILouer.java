package fr.adaming.model;

import java.util.Date;

public class BILouer extends BienImmobilier {
	
	private double caution;
	private double loyer;
	private double charges;
	private String typeBail;
	private boolean meubles;
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
	public BILouer(double caution, double loyer, double charges, String typeBail, boolean meubles) {
		super();
		this.caution = caution;
		this.loyer = loyer;
		this.charges = charges;
		this.typeBail = typeBail;
		this.meubles = meubles;
	}
	public BILouer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BILouer(int id, String statut, Date dateSoumission, Adresse adresse, Date dateDispo, double revenuCadastral,
			double prix) {
		super(id, statut, dateSoumission, adresse, dateDispo, revenuCadastral, prix);
		// TODO Auto-generated constructor stub
	}
	public BILouer(String statut, Date dateSoumission, Adresse adresse, Date dateDispo, double revenuCadastral,
			double prix) {
		super(statut, dateSoumission, adresse, dateDispo, revenuCadastral, prix);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BILouer [caution=" + caution + ", loyer=" + loyer + ", charges=" + charges + ", typeBail=" + typeBail
				+ ", meubles=" + meubles + "]";
	}
	
	

}
