package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Contrat;

@Repository
public class ContratDaoImpl implements IContratDao {

	@Autowired
	private SessionFactory sf;
	Session s;

	@Override
	public List<Contrat> getAllContrat() {
		// req HQL
		String req = "FROM Contrat AS contrat";

		// ouvrir la session
		s = sf.getCurrentSession();

		// récup le Query
		Query q = s.createQuery(req);

		return q.list();
	}

	@Override
	public Contrat addContrat(Contrat c) {
		// ouvrir la session
		s = sf.getCurrentSession();

		// req
		s.save(c);
		return c;
	}

	@Override
	public Contrat updateContrat(Contrat c) {
		// ouvrir la session
		s = sf.getCurrentSession();

		// req
		s.update(c);
		return c;
	}

	@Override
	public int deleteContrat(int id) {
		// req HQL
		String req = "DELETE FROM Contrat AS contrat WHERE contrat.id=:pId";

		// ouvrir la session
		s = sf.getCurrentSession();

		// récup du query
		Query q = s.createQuery(req);

		// passage des params
		q.setParameter("pId", id);

		return q.executeUpdate();
	}

}
