package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "clients")
@XmlRootElement
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cl")
	private int id;
	private String nom;
	@Embedded
	private Adresse adresse;
	private String telephone;
	private String email;

	// Transfo assos avec conseiller immobilier
	@ManyToOne
	@JoinColumn(name = "c_id", referencedColumnName = "id_c")
	private ConseillerImmobilier ci;

	// Transfo assos avec contrat
	@OneToOne(mappedBy = "client")
	@JsonIgnore
	private Contrat contrat;

	@OneToMany(mappedBy = "client")
	@JsonIgnore
	private List<Visite> visites;

	// Constructeurs
	public Client() {
		super();
	}

	public Client(String nom, Adresse adresse, String telephone, String email, ConseillerImmobilier ci,
			Contrat contrat) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.ci = ci;
		this.contrat = contrat;
	}

	public Client(int id, String nom, Adresse adresse, String telephone, String email, ConseillerImmobilier ci,
			Contrat contrat) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.ci = ci;
		this.contrat = contrat;
	}

	// Getter et setter
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public ConseillerImmobilier getCi() {
		return ci;
	}

	public void setCi(ConseillerImmobilier ci) {
		this.ci = ci;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Visite> getVisites() {
		return visites;
	}

	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + ", email="
				+ email + "]";
	}

}
