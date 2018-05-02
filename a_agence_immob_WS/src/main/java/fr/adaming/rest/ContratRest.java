package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Contrat;
import fr.adaming.service.IContratService;

@RestController
public class ContratRest {

	@Autowired
	private IContratService contratService;

	@RequestMapping(value = "/listeContrat", method = RequestMethod.GET, produces = "application/json")
	public List<Contrat> findAllContrat() {
		return contratService.getAllContrat();
	}

	@RequestMapping(value = "/contrat", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Contrat ajoutContrat(@RequestBody Contrat contrat) {
		return contratService.addContrat(contrat);
	}

	@RequestMapping(value = "/contrat", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Contrat modifContrat(@RequestBody Contrat contrat) {
		return contratService.updateContrat(contrat);
	}

	@RequestMapping(value = "/contrat/{pId}", method = RequestMethod.DELETE)
	public int supContrat(@PathVariable("pId") int id) {
		return contratService.deleteContrat(id);
	}

}
