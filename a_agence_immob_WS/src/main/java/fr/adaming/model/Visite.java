package fr.adaming.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Timer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="visites")
@XmlRootElement
public class Visite implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.TIME)
	private Date heure;
	@Temporal(TemporalType.DATE)
	private Date datevisite;
	
	@ManyToOne
	@JoinColumn(name="c_id", referencedColumnName="id_c")
	private ConseillerImmobilier conseillerimmobilier;
	
	public ConseillerImmobilier getConseillerimmobilier() {
		return conseillerimmobilier;
	}


	public void setConseillerimmobilier(ConseillerImmobilier conseillerimmobilier) {
		this.conseillerimmobilier = conseillerimmobilier;
	}


	//Constructeurs
	public Visite() {
		super();
	}


	public Visite(Date heure, Date datevisite) {
		super();
		this.heure = heure;
		this.datevisite = datevisite;
	}


	public Visite(int id, Date heure, Date datevisite) {
		super();
		this.id = id;
		this.heure = heure;
		this.datevisite = datevisite;
	}

	
	//G+S
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getHeure() {
		return heure;
	}


	public void setHeure(Date heure) {
		this.heure = heure;
	}


	public Date getDatevisite() {
		return datevisite;
	}


	public void setDatevisite(Date datevisite) {
		this.datevisite = datevisite;
	}


	//ToString
	@Override
	public String toString() {
		return "Visite [id=" + id + ", heure=" + heure + ", datevisite=" + datevisite + "]";
	}
	
	
	
	
}
