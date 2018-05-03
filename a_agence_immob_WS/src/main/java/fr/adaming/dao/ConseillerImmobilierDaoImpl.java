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
	
	public ConseillerImmobilier isExist(ConseillerImmobilier ci) {
		
		//ouvrir une session
		Session s = sf.getCurrentSession();
		
		//la requete HQL
		String req= "FROM ConseillerImmobilier as ci WHERE ci.idUsername=:pidUsername AND ci.mdp=:pMdp";
		
		//recuperation du query
		Query query = s.createQuery(req);
		
		//passage des paramètres
		query.setParameter("pidUsername", ci.getIdUsername());
		query.setParameter("pMdp", ci.getMdp());
		
		return (ConseillerImmobilier) query.uniqueResult();
	}

}
