package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IConseillerImmobilierDao;
import fr.adaming.model.ConseillerImmobilier;
@Service
@Transactional
public class ConseillerImmobilierServiceImpl implements IConseillerImmobilierService{
	
	//transformation UML en Java
		@Autowired
		private IConseillerImmobilierDao ciDao;

	@Override
	public ConseillerImmobilier isExist(ConseillerImmobilier ci) {
		return ciDao.isExist(ci);
	}

}
