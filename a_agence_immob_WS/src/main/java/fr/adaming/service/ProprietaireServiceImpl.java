package fr.adaming.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class ProprietaireServiceImpl implements IProprietaireService{
	
	@Autowired 
	private IProprietaireDao propDao;

	@Override
	public List<Proprietaire> getAllProprietaire() {
		
		return propDao.getAllProprietaire();
	}

	@Override
	public Proprietaire addProprietaire(Proprietaire prop) {
		
		return propDao.addProprietaire(prop);
	}

	@Override
	public Proprietaire updateProprietaire(Proprietaire prop) {
		
		return propDao.updateProprietaire(prop);
	}

	@Override
	public int deleteProprietaire(int id) {
		
		return propDao.deleteProprietaire(id);
	}

	@Override
	public Proprietaire getProprietaireById(int id) {
		
		return propDao.getProprietaireById(id);
	}

}
