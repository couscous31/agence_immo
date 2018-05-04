package fr.adaming.rest;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.ConseillerImmobilier;
import fr.adaming.service.IConseillerImmobilierService;

@RestController
public class CIRest {
	@Autowired
	private IConseillerImmobilierService ciService;
	
	@RequestMapping(value="/listeLogin",method=RequestMethod.GET,produces="application/json")	
	public ConseillerImmobilier isExist(@RequestParam("pidUsername") String idUsername, @RequestParam("pMdp") String mdp) {
		return ciService.isExist(idUsername, mdp);
	}

}
