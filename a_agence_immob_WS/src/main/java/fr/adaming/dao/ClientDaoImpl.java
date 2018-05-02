package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Proprietaire;

@Repository
public class ClientDaoImpl implements IClientDao {

	@Autowired
	private SessionFactory sf;
	Session s;

	@Override
	public List<Client> getAllClient() {
		// la requete HQL
		String req = "FROM Client as cl";

		// ouvrir une session
		s = sf.getCurrentSession();

		// recuperation du query
		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public Client addClient(Client cl) {
		s = sf.getCurrentSession();
		s.save(cl);
		return cl;
	}

	@Override
	public Client updateClient(Client cl) {
		s = sf.getCurrentSession();
		s.update(cl);
		return cl;
	}

	@Override
	public int deleteClient(int id) {
		// requete HQL
		String req = "DELETE FROM Client as cl WHERE cl.id=:pId";

		s = sf.getCurrentSession();

		Query query = s.createQuery(req);

		// passage des paramètres
		query.setParameter("pId", id);

		return query.executeUpdate();
	}

	@Override
	public Client getClientById(int id) {
		// requete HQL
		String req = "FROM Client AS cl WHERE cl.id=:pId";

		// ouvrir une session
		s = sf.getCurrentSession();

		Query query = s.createQuery(req);

		// passage des paramètres
		query.setParameter("pId", id);

		return (Client) query.uniqueResult();
	}

}
