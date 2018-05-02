package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClasseStandardDao;
import fr.adaming.model.ClasseStandard;

@Service
@Transactional
public class ClasseStandardServiceImpl implements IClasseStandardService {
	
	@Autowired
	private IClasseStandardDao classeStandardDao;

	@Override
	public List<ClasseStandard> getAllClassStandard() {
		return classeStandardDao.getAllClassStandard();
	}
	
	
	
	

}
