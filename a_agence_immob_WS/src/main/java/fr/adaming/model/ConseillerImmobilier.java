package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="conseillers")
@XmlRootElement
public class ConseillerImmobilier implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_a")
	private int id;
	private String idUsername;
	private String mdp;
	@Column(columnDefinition="TINYINT(1)")
	private boolean active;
	
	@OneToMany(mappedBy="listeConseillers")
	private Role role;
	
	public ConseillerImmobilier() {
		super();
	}
	public ConseillerImmobilier(String idUsername, String mdp, boolean active) {
		super();
		this.idUsername = idUsername;
		this.mdp = mdp;
		this.active = active;
	}
	public ConseillerImmobilier(int id, String idUsername, String mdp, boolean active) {
		super();
		this.id = id;
		this.idUsername = idUsername;
		this.mdp = mdp;
		this.active = active;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdUsername() {
		return idUsername;
	}
	public void setIdUsername(String idUsername) {
		this.idUsername = idUsername;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	

}
