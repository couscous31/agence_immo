package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Contrat;

public interface IContratService {

	public List<Contrat> getAllContrat();

	public Contrat addContrat(Contrat c);

	public Contrat updateContrat(Contrat c);

	public int deleteContrat(int id);

}
