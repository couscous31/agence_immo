package fr.adaming.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	@RequestMapping(value = "/classeStandardPrix", method = RequestMethod.GET, produces = "application/json")
	public Set<Double> getAllPrix() {
		List<ClasseStandard> liste = classeStandardService.getAllClassStandard();
		Set<Double> listePrix=new HashSet<Double>();
		for (ClasseStandard cs : liste){
			listePrix.add(cs.getPrixmax());
		}
		return listePrix;

	}
	
	@RequestMapping(value = "/classeStandardSurface", method = RequestMethod.GET, produces = "application/json")
	public Set<Double> getAllSurfaces() {
		List<ClasseStandard> liste = classeStandardService.getAllClassStandard();
		Set<Double> listeSurface=new HashSet<Double>();
		for (ClasseStandard cs : liste){
			listeSurface.add(cs.getSufacemin());
		}
		return listeSurface;

	}
}
