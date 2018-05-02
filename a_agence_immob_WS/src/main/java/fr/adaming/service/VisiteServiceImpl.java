package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IVisiteDao;
import fr.adaming.model.Visite;

@Service
@Transactional
public class VisiteServiceImpl implements IVisiteService {

	@Autowired
	private IVisiteDao viDao;
	
	@Override
	public Visite addVisite(Visite vi) {
		
		return viDao.addVisite(vi);
	}

	@Override
	public Visite updateVisite(Visite vi) {
		// TODO Auto-generated method stub
		return viDao.updateVisite(vi);
	}

	@Override
	public int deleteVisite(int id) {
		// TODO Auto-generated method stub
		return viDao.deleteVisite(id);
	}

	@Override
	public Visite getVisitebyId(int id) {
		// TODO Auto-generated method stub
		return viDao.getVisitebyId(id);
	}

	@Override
	public List<Visite> getAllVisite() {
		// TODO Auto-generated method stub
		return viDao.getAllVisite();
	}

}
