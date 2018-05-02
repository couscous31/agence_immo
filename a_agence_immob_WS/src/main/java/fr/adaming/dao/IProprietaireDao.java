package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IProprietaireDao {
	
	public List<Proprietaire> getAllProprietaire();
	
	public Proprietaire addProprietaire(Proprietaire prop);
	
	public Proprietaire updateProprietaire(Proprietaire prop);
	
	public int deleteProprietaire(int id);
	
	public Proprietaire getProprietaireById(int id);

}
