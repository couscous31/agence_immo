package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="conseillers")
@XmlRootElement
public class ConseillerImmobilier implements Serializable {
	
	//Attribut
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_c")
	private int id;
	private String idUsername;
	private String mdp;
	@Column(columnDefinition="TINYINT(1)")
	private boolean active;
	
	//Associations
	@OneToMany(mappedBy="conseiller")
	@JsonIgnore
	private List<Role> roles;
	
	@OneToMany(mappedBy="ci")
	@JsonIgnore
	private List<Client> listeClients;
	
	@OneToMany(mappedBy="conseillerimmobilier")
	@JsonIgnore
	private List<Visite> listeVisites;
	
	//Constructeurs
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
	
	
	//Accesseurs
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Client> getListeClients() {
		return listeClients;
	}
	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}
	public List<Visite> getListeVisites() {
		return listeVisites;
	}
	public void setListeVisites(List<Visite> listeVisites) {
		this.listeVisites = listeVisites;
	}
	
	
	

}
