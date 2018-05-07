package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.model.ConseillerImmobilier;
import fr.adaming.model.Visite;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerImmobilierService;
import fr.adaming.service.IEnvoyerMail;
import fr.adaming.service.IVisiteService;

@RestController
public class VisiteRest {

	@Autowired
	private IVisiteService viService;
	
	@Autowired
	private IEnvoyerMail envoiMail;
	
	@Autowired
	private IConseillerImmobilierService consService;
	
	@Autowired
	private IClientService clService;
	
	

	//ok
	@RequestMapping(value = "/listevi", method = RequestMethod.GET, produces = { "application/json" })
	public List<Visite> getAllvisitecl() {
		return viService.getAllVisite();
	}

	//Ok
	@RequestMapping(value = "/getvibyid", method = RequestMethod.GET, produces = { "application/json" })
	public Visite findVisitecl(@RequestParam("pId") int id) {
		return viService.getVisitebyId(id);
	}

	//OK
	@RequestMapping(value = "/addvi", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Visite ajouterVisite(@RequestBody Visite vi) {
		System.out.println(vi.getBienImmo().getId());
		Visite viOut=viService.addVisite(vi);
		ConseillerImmobilier consImmo=consService.getConseillerById(vi.getConseillerimmobilier().getId());
		Client clientImmo=clService.getClientById(vi.getClient().getId());
		envoiMail.envoyerMessageAjout(consImmo.getIdUsername(), viOut);
		envoiMail.envoyerMessageAjout(clientImmo.getEmail(), viOut);
		
		return viOut;
	}

	//Ok
	@RequestMapping(value = "/modvi", method = RequestMethod.PUT, produces = { "application/json" }, consumes = {"application/json" })
	public Visite ModifierVisite(@RequestBody Visite vi) {
		return viService.updateVisite(vi);
	}

	//OK
	@RequestMapping(value = "/supvi/{pId}", method = RequestMethod.DELETE)
	public int supprimerVisite(@PathVariable("pId") int id) {
		return viService.deleteVisite(id);
	}
}
