package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Visite;

public interface IVisiteService {
	

	public Visite addVisite(Visite vi);
	
	public Visite updateVisite(Visite vi);
	
	public int deleteVisite(int id);
	
	public Visite getVisitebyId(int id);
	
	public List<Visite> getAllVisite();

}
