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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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

	// Transfo assos avec conseiller immobilier
	@ManyToOne
	@JoinColumn(name = "a_id", referencedColumnName = "id_a")
	private ConseillerImmobilier ci;

	// Transfo assos avec classe standard
	@ManyToMany(mappedBy = "listeClient")
	private List<ClasseStandard> listeClasseStandard;

	// Transfo assos avec contrat
	@OneToOne(mappedBy = "client")
	private Contrat contrat;

	// Constructeurs
	public Client() {
		super();
	}

	public Client(String nom, Adresse adresse, String telephone) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	public Client(int id, String nom, Adresse adresse, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
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

	public List<ClasseStandard> getListeClasseStandard() {
		return listeClasseStandard;
	}

	public void setListeClasseStandard(List<ClasseStandard> listeClasseStandard) {
		this.listeClasseStandard = listeClasseStandard;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + "]";
	}

}
