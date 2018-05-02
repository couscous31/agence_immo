package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Proprietaire;

@Repository
public class ProprietaireDaoImpl implements IProprietaireDao {

	// paramètres
	@Autowired
	private SessionFactory sf;
	Session s;

	@Override
	public List<Proprietaire> getAllProprietaire() {
		// la requete HQL
		String req = "FROM Proprietaire as pr";

		// ouvrir une session
		Session s = sf.getCurrentSession();

		// recuperation du query
		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public Proprietaire addProprietaire(Proprietaire prop) {
		s = sf.getCurrentSession();
		s.save(prop);
		return prop;
	}

	@Override
	public Proprietaire updateProprietaire(Proprietaire prop) {
		s = sf.getCurrentSession();
		s.saveOrUpdate(prop);
		return prop;
	}

	@Override
	public int deleteProprietaire(int id) {
		// requete HQL
		String req = "DELETE FROM Proprietaire as p WHERE p.id=:pId";
		s = sf.getCurrentSession();
		Query query = s.createQuery(req);

		// passage des paramètres
		query.setParameter("pId", id);

		return query.executeUpdate();
	}

	@Override
	public Proprietaire getProprietaireById(int id) {

		// requete HQL
		String req = "FROM Proprietaire p WHERE p.id=:pId";

		// ouvrir une session
		s = sf.getCurrentSession();

		Query query = s.createQuery(req);

		// passage des paramètres
		query.setParameter("pId", id);

		return (Proprietaire) query.uniqueResult();
	}

}
