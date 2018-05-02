package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IProprietaireService {
	
	public List<Proprietaire> getAllProprietaire();
	
	public Proprietaire addProprietaire(Proprietaire prop);
	
	public Proprietaire updateProprietaire(Proprietaire prop);
	
	public int deleteProprietaire(int id);
	
	public Proprietaire getProprietaireById(int id);

}
