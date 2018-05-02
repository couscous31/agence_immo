package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IContratDao;
import fr.adaming.model.Contrat;

@Service
@Transactional
public class ContratServiceImpl implements IContratService {

	@Autowired
	private IContratDao contratDao;

	@Override
	public List<Contrat> getAllContrat() {
		return contratDao.getAllContrat();
	}

	@Override
	public Contrat addContrat(Contrat c) {
		return contratDao.addContrat(c);
	}

	@Override
	public Contrat updateContrat(Contrat c) {
		return contratDao.updateContrat(c);
	}

	@Override
	public int deleteContrat(int id) {
		return contratDao.deleteContrat(id);
	}

}
