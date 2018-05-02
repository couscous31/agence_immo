package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmobilier;

@Repository
public class BienImmoDaoImplSophie implements IBienImmoDaoSophie {

	@Autowired
	private SessionFactory sf;
	
	private Session s;

	@Override
	public List<BienImmobilier> getAll() {
		//Ouvrir la session
		s=sf.getCurrentSession();
		//Requête HQL
		String req="FROM BienImmobilier";
		//Récupération du query
		Query q=s.createQuery(req);
		
		return q.list();
	}
	
	
}
