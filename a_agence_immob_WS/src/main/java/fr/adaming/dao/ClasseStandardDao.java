package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ClasseStandard;

@Repository
public class ClasseStandardDao implements IClasseStandardDao {

	@Autowired
	private SessionFactory sf;
	
	private Session s;
	
	@Override
	public List<ClasseStandard> getAllClassStandard() {
		//Ouvrir la session
		s=sf.getCurrentSession();
		//Requête HQL
		String req="FROM ClasseStandard";
		//Récupération du query
		Query q=s.createQuery(req);
		
		return q.list();
	}

}
