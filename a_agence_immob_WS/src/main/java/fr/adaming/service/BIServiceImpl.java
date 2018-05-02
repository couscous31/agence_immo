package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBIDao;
import fr.adaming.model.BienImmobilier;



@Service
@Transactional
public class BIServiceImpl implements IBIService {
	
	// Injection de dépendance
	@Autowired
	IBIDao biDao;

	@Override
	public BienImmobilier addBienImmobilier(BienImmobilier b) {
		return biDao.addBienImmobilier(b);
	}

	@Override
	public BienImmobilier updateBienImmobilier(BienImmobilier b) {
		return biDao.updateBienImmobilier(b);
	}

	@Override
	public void deleteBienImmobilier(int id) {
		biDao.deleteBienImmobilier(id);
	}

	@Override
	public List<BienImmobilier> getAllBienImmobilier() {
		return biDao.getAllBienImmobilier();
	}

	@Override
	public BienImmobilier getBienImmobilierById(int id) {
		return biDao.getBienImmobilierById(id);
	}



}
