package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilier;

public interface IBIService {

	public BienImmobilier addBienImmobilier(BienImmobilier b);

	public BienImmobilier updateBienImmobilier(BienImmobilier b);

	public void deleteBienImmobilier(int id);

	public List<BienImmobilier> getAllBienImmobilier();

	public BienImmobilier getBienImmobilierById(int id);

}