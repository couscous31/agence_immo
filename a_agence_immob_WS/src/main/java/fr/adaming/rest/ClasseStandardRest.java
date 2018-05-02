package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.ClasseStandard;
import fr.adaming.service.IBienImmoServiceSophie;
import fr.adaming.service.IClasseStandardService;

@RestController
public class ClasseStandardRest {

	@Autowired
	private IClasseStandardService classeStandardService;

	@Autowired
	private IBienImmoServiceSophie biService;

	@RequestMapping(value = "/classeStandard", method = RequestMethod.GET, produces = "application/json")
	public List<BienImmobilier> isExist() {
		List<ClasseStandard> liste = classeStandardService.getAllClassStandard();
		return biService.getAll();

	}
}
