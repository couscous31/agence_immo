package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "proprietaires")
@XmlRootElement
public class Proprietaire implements Serializable {

	// attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@Embedded
	private Adresse adresse;
	private String telPerso;
	private String telPro;

	//transformation uml en java
	@OneToMany(mappedBy="proprietaire")
	private List<BienImmobilier> listeBienImmobiliers;
	
	// contructeurs
	public Proprietaire() {
		super();
	}

	public Proprietaire(String nom, Adresse adresse, String telPerso, String telPro) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.telPerso = telPerso;
		this.telPro = telPro;
	}

	public Proprietaire(int id, String nom, Adresse adresse, String telPerso, String telPro) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.telPerso = telPerso;
		this.telPro = telPro;
	}

	// getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTelPerso() {
		return telPerso;
	}

	public void setTelPerso(String telPerso) {
		this.telPerso = telPerso;
	}

	public String getTelPro() {
		return telPro;
	}

	public void setTelPro(String telPro) {
		this.telPro = telPro;
	}


	public List<BienImmobilier> getListeBienImmobiliers() {
		return listeBienImmobiliers;
	}

	public void setListeBienImmobiliers(List<BienImmobilier> listeBienImmobiliers) {
		this.listeBienImmobiliers = listeBienImmobiliers;
	}

	// ToString
	@Override
	public String toString() {
		return "Proprietaire [id=" + id + ", nom=" + nom + ", telPerso=" + telPerso + ", telPro=" + telPro + "]";
	}

}
