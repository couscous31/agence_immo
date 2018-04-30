package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="classesStandards")
@XmlRootElement
public class ClasseStandard implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String type;
	private String modeoffre;
	private double prixmax;
	private double sufacemin;
	
	@ManyToMany
	private List<Client> listeClient;
	
	
	//Constructeurs
	public ClasseStandard() {
		super();
	}

	public ClasseStandard(String type, String modeoffre, double prixmax, double sufacemin) {
		super();
		this.type = type;
		this.modeoffre = modeoffre;
		this.prixmax = prixmax;
		this.sufacemin = sufacemin;
	}

	public ClasseStandard(int id, String type, String modeoffre, double prixmax, double sufacemin) {
		super();
		this.id = id;
		this.type = type;
		this.modeoffre = modeoffre;
		this.prixmax = prixmax;
		this.sufacemin = sufacemin;
	}

	//G+S
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModeoffre() {
		return modeoffre;
	}

	public void setModeoffre(String modeoffre) {
		this.modeoffre = modeoffre;
	}

	public double getPrixmax() {
		return prixmax;
	}

	public void setPrixmax(double prixmax) {
		this.prixmax = prixmax;
	}

	
	public double getSufacemin() {
		return sufacemin;
	}

	public void setSufacemin(double sufacemin) {
		this.sufacemin = sufacemin;
	}

	public List<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}
	
	

}
