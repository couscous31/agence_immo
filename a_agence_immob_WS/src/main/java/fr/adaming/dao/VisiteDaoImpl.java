package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Visite;

@Repository
public class VisiteDaoImpl implements IVisiteDao {

	@Autowired
	private SessionFactory sf;

	Session s;

	@Override
	public Visite addVisite(Visite vi) {
		s = sf.getCurrentSession();
		s.save(vi);
		return vi;
	}

	@Override
	public Visite updateVisite(Visite vi) {
		String req = "UPDATE Visite as vi SET vi.datevisite=:pDvi, vi.heure=:pHeure WHERE vi.id=:pId";
		s = sf.getCurrentSession();

		Query query = s.createQuery(req);

		query.setParameter("pDvi", vi.getDatevisite());
		query.setParameter("pHeure", vi.getHeure());
		query.setParameter("pId", vi.getId());

		query.executeUpdate();
		return vi;
	}

	@Override
	public int deleteVisite(int id) {
		String req = "DELETE Visite as vi WHERE vi.id=:pId";
		s = sf.getCurrentSession();

		Query query = s.createQuery(req);

		query.setParameter("pId", id);

		query.executeUpdate();
		return id;
	}

	@Override
	public Visite getVisitebyId(int id) {
		String req = "FROM Visite as vi WHERE vi.id=:pId";
		s = sf.getCurrentSession();

		Query query = s.createQuery(req);
		query.setParameter("pId", id);
		
		return (Visite) query.uniqueResult();
	}

	@Override
	public List<Visite> getAllVisite() {
		String req = "FROM Visite";
		s = sf.getCurrentSession();
		Query query = s.createQuery(req);
		return query.list();
	}

}
