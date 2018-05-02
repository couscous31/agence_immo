package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Contrat;

public interface IContratDao {
	
	public List<Contrat> getAllContrat();
	
	public Contrat addContrat(Contrat c);
	
	public Contrat updateContrat(Contrat c);
	
	public int deleteContrat(int id);

}
