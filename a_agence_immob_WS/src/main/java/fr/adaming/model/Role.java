package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

	// D�claration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_r")
	private int idR;
	private String rolename;

	// Transformation de l'association UML en Java

	@ManyToOne
	@JoinColumn(name = "c_id", referencedColumnName = "id_c")
	private ConseillerImmobilier conseiller;

	// D�claration des constructeurs
	public Role() {
		super();
	}

	public Role(String rolename) {
		super();
		this.rolename = rolename;
	}

	public Role(int idR, String rolename) {
		super();
		this.idR = idR;
		this.rolename = rolename;
	}

	// D�claration des getters et setters
	public int getIdR() {
		return idR;
	}

	public void setIdR(int idR) {
		this.idR = idR;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public ConseillerImmobilier getConseiller() {
		return conseiller;
	}

	public void setConseiller(ConseillerImmobilier conseiller) {
		this.conseiller = conseiller;
	}

	
}
