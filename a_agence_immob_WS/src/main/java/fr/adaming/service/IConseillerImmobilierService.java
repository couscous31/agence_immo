package fr.adaming.service;

import fr.adaming.model.ConseillerImmobilier;

public interface IConseillerImmobilierService {
	
	public ConseillerImmobilier isExist(String idUsername, String mdp);

}
