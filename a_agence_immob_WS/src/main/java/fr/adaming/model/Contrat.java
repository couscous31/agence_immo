package fr.adaming.model;

import java.util.Date;

public class Contrat {
	
	 private int id;
	 private String ref;
	 private Date dateSignature;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public Date getDateSignature() {
		return dateSignature;
	}
	public void setDateSignature(Date dateSignature) {
		this.dateSignature = dateSignature;
	}
	public Contrat(int id, String ref, Date dateSignature) {
		super();
		this.id = id;
		this.ref = ref;
		this.dateSignature = dateSignature;
	}
	public Contrat(String ref, Date dateSignature) {
		super();
		this.ref = ref;
		this.dateSignature = dateSignature;
	}
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Contrat [id=" + id + ", ref=" + ref + ", dateSignature=" + dateSignature + "]";
	}

}
