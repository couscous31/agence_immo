package fr.adaming.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "contrats")
@XmlRootElement
public class Contrat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contrat")
	private int id;
	private String ref;
	@Temporal(TemporalType.DATE)
	private Date dateSignature;

	// Transfo assos avec client
	@OneToOne(cascade=CascadeType.ALL)
	private Client client;

	// Transfo assos avec bien immobilier
	@OneToOne(cascade=CascadeType.ALL)
	private BienImmobilier bi;

	// Getter et setter
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public BienImmobilier getBi() {
		return bi;
	}

	public void setBi(BienImmobilier bi) {
		this.bi = bi;
	}

	// Constructeurs
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
	}

	@Override
	public String toString() {
		return "Contrat [id=" + id + ", ref=" + ref + ", dateSignature=" + dateSignature + "]";
	}

}
