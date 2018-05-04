package fr.adaming.dao;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ConseillerImmobilier;
@Repository
public class ConseillerImmobilierDaoImpl implements IConseillerImmobilierDao {
	
	@Autowired
	private SessionFactory sf;
	
	public ConseillerImmobilier isExist(String idUsername, String mdp) {
		
		//ouvrir une session
		Session s = sf.getCurrentSession();
		
		//la requete HQL
		String req= "FROM ConseillerImmobilier as ci WHERE ci.idUsername=:pidUsername AND ci.mdp=:pMdp";
		
		//recuperation du query
		Query query = s.createQuery(req);
		
		//passage des paramètres
		query.setParameter("pidUsername", idUsername);
		query.setParameter("pMdp", mdp);
		
		return (ConseillerImmobilier) query.uniqueResult();
	}

	@Override
	public ConseillerImmobilier getConseillerById(int id) {
		
		String req="FROM ConseillerImmobilier as ci WHERE ci.id=:pId";
		
		//ouvrir une session
		Session s=sf.getCurrentSession();
		
		Query query=s.createQuery(req);
		
		query.setParameter("pId", id);
		
		return (ConseillerImmobilier) query.uniqueResult();
	}

}
