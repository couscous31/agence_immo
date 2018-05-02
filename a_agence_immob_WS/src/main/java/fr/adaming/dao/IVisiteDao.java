package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Visite;

public interface IVisiteDao {
	
	public Visite addVisite(Visite vi);
	
	public Visite updateVisite(Visite vi);
	
	public int deleteVisite(int id);
	
	public Visite getVisitebyId(int id);
	
	public List<Visite> getAllVisite();

}
