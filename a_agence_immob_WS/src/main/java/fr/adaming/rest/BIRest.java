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
	private IBIService biService;

	// Méthodes du web service
	
	@RequestMapping(value="/listeBi",method=RequestMethod.GET,produces="application/json")	// si plusieurs : {"application/json","application/xml"}
	public List<BienImmobilier> findAllBienImmobilier(){
		return biService.getAllBienImmobilier();
	}
	
	@RequestMapping(value="/BienImmobilier",method=RequestMethod.GET,produces="application/json")
	public BienImmobilier findEtudiant(@RequestParam("pId") int id){
		return biService.getBienImmobilierById(id);
	}
	
	@RequestMapping(value="/BienImmobilier",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public BienImmobilier ajouterBienImmobilier(@RequestBody BienImmobilier bi){
		return biService.addBienImmobilier(bi);
	}
	
	@RequestMapping(value="/BienImmobilier",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public BienImmobilier modifierEtudiant(@RequestBody BienImmobilier bi){
		return biService.updateBienImmobilier(bi);
	}
	
	@RequestMapping(value="/BienImmobilier/{pId}",method=RequestMethod.DELETE)
	public int supprimerBienImmobilier(@PathVariable("pId") int id){
		return biService.deleteBienImmobilier(id);
	}
}
