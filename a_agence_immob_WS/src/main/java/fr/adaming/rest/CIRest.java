package fr.adaming.rest;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.ConseillerImmobilier;
import fr.adaming.service.IConseillerImmobilierService;

@RestController
public class CIRest {
	
	private IConseillerImmobilierService ciService;
	
	@RequestMapping(value="/listeLogin",method=RequestMethod.GET,produces="application/json")	// si plusieurs : {"application/json","application/xml"}
	public ConseillerImmobilier isExist(ConseillerImmobilier ci) {
		return ciService.isExist(ci);
	}

}
