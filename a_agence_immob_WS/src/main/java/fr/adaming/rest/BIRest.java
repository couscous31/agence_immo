package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.BienImmobilier;
import fr.adaming.service.IBIService;



@RestController
public class BIRest {
	
	// Injection de dépendance
	@Autowired
	private IBIService eService;

	// Méthodes du web service
	
	@RequestMapping(value="/liste",method=RequestMethod.GET,produces="application/json")	// si plusieurs : {"application/json","application/xml"}
	public List<BienImmobilier> findAllBienImmobilier(){
		return eService.getAllBienImmobilier();
	}
	
	@RequestMapping(value="/BienImmobilier",method=RequestMethod.GET,produces="application/json")
	public BienImmobilier findEtudiant(@RequestParam("pID") int id){
		return eService.getBienImmobilierById(id);
	}
	
	@RequestMapping(value="/BienImmobilier",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public BienImmobilier ajouterBienImmobilier(@RequestBody BienImmobilier b){
		return eService.addBienImmobilier(b);
	}
	
	@RequestMapping(value="/BienImmobilier",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public BienImmobilier modifierEtudiant(@RequestBody BienImmobilier b){
		return eService.updateBienImmobilier(b);
	}
	
	@RequestMapping(value="/BienImmobilier/{pID}",method=RequestMethod.DELETE)
	public void supprimerBienImmobilier(@PathVariable("pID") int id){
		eService.deleteBienImmobilier(id);
	}
}
