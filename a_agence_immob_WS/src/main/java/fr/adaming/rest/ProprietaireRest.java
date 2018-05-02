package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import fr.adaming.model.Proprietaire;
import fr.adaming.service.IProprietaireService;

@RestController
public class ProprietaireRest {
	
	//transformation de l'association uml en java
	@Autowired
	private IProprietaireService propService;
	
	//METHODE RECUPERER LA LISTE
	@RequestMapping(value="/listeProp", method=RequestMethod.GET, produces="application/json")
	public List<Proprietaire> findAllProprietaires(){
	return propService.getAllProprietaire();	
	}
	

	//METHODE RECHERCHER PROP PAR ID
	@RequestMapping(value = "/proprietaire", method = RequestMethod.GET, produces = "application/json")
	public Proprietaire findProprietaire(@RequestParam("pId") int id) {
		return propService.getProprietaireById(id);
	}
	
	//METHODE AJOUTER UN PROPRIETAIRE
	@RequestMapping(value = "/proprietaire", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Proprietaire ajouterProprietaire(@RequestBody Proprietaire prop) {
		return propService.addProprietaire(prop);
	}
	
	//METHODE MODIFIER UN PROPRIETAIRE
	@RequestMapping(value = "/proprietaire", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Proprietaire modifierProprietaire(@RequestBody Proprietaire prop) {
		return propService.updateProprietaire(prop);
	}
	
	//METHODE SUPPRIMER UN PROPRIETAIRE
	@RequestMapping(value = "/proprietaire/{pId}", method = RequestMethod.DELETE)
	public int supprimerProprietaire(@PathVariable("pId") int id) {
		return propService.deleteProprietaire(id);

	}

	

	
	
}
