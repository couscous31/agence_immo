package fr.adaming.dao;

import fr.adaming.model.ConseillerImmobilier;

public interface IConseillerImmobilierDao {
	
	public ConseillerImmobilier isExist(String idUsername, String mdp);
	
	public ConseillerImmobilier getConseillerById(int id);

}
