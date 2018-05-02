package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bien_immobiliers")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
@XmlRootElement
public class BienImmobilier {

	// attributs
	@Id
	@Column(name="id_bi")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String statut;
	@Temporal(TemporalType.DATE)
	private Date dateSoumission;
	@Embedded
	private Adresse adresse;
	@Temporal(TemporalType.DATE)
	private Date dateDispo;
	private double revenuCadastral;
	private double prix;
	@Lob
	private byte[] photoBI;
	@Transient
	private String imageBI;
	private double lat;
	private double lng;

	
	//transformations UML en java
	//CLASSE STANDARD
	@ManyToOne
	@JoinColumn(name="cs_id", referencedColumnName="id")
	private ClasseStandard classeStandard;
	
	//CONTRAT
	@OneToOne(mappedBy="bi")
	private Contrat contrat;
	
	//VISITE
	@JsonIgnore
	@OneToMany(mappedBy="bienImmo")
	private List<Visite> listeVisite;
	
	//PROPRIETAIRE
	@ManyToOne
	@JoinColumn(name="prop_id", referencedColumnName="id")
	private Proprietaire proprietaire;

	// constructeurs
	public BienImmobilier() {
		super();
	}

	public BienImmobilier(String statut, Date dateSoumission, Adresse adresse, Date dateDispo, double revenuCadastral,
			double prix) {
		super();
		this.statut = statut;
		this.dateSoumission = dateSoumission;
		this.adresse = adresse;
		this.dateDispo = dateDispo;
		this.revenuCadastral = revenuCadastral;
		this.prix = prix;
	}

	public BienImmobilier(int id, String statut, Date dateSoumission, Adresse adresse, Date dateDispo,
			double revenuCadastral, double prix) {
		super();
		this.id = id;
		this.statut = statut;
		this.dateSoumission = dateSoumission;
		this.adresse = adresse;
		this.dateDispo = dateDispo;
		this.revenuCadastral = revenuCadastral;
		this.prix = prix;
	}

	// getters et setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateSoumission() {
		return dateSoumission;
	}

	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Date getDateDispo() {
		return dateDispo;
	}

	public void setDateDispo(Date dateDispo) {
		this.dateDispo = dateDispo;
	}

	public double getRevenuCadastral() {
		return revenuCadastral;
	}

	public void setRevenuCadastral(double revenuCadastral) {
		this.revenuCadastral = revenuCadastral;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	public byte[] getPhotoBI() {
		return photoBI;
	}

	public void setPhotoBI(byte[] photoBI) {
		this.photoBI = photoBI;
	}

	public String getImageBI() {
		return imageBI;
	}

	public void setImageBI(String imageBI) {
		this.imageBI = imageBI;
	}

	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}

	
	
	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public List<Visite> getListeVisite() {
		return listeVisite;
	}

	public void setListeVisite(List<Visite> listeVisite) {
		this.listeVisite = listeVisite;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	
	
	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	// to string
	@Override
	public String toString() {
		return "BienImmobilier [id=" + id + ", statut=" + statut + ", dateSoumission=" + dateSoumission + ", adresse="
				+ adresse + ", dateDispo=" + dateDispo + ", revenuCadastral=" + revenuCadastral + ", prix=" + prix
				+ "]";
	}

}
