package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Etudiant;

@Repository
public class BIDaoImpl implements IBIDao {
	
	// Injection de dépendance
		@Autowired
		private SessionFactory sf;
		
		// Objets utiles
		Session s;
		Query q;
		
		@Override
		public BienImmobilier addBienImmobilier(BienImmobilier b) {
			// Ouvrir une session
			s=sf.getCurrentSession();
			// Save
			s.save(b);
			return b;
		}
		@Override
		public BienImmobilier updateBienImmobilier(BienImmobilier b) {
			s=sf.getCurrentSession();
			s.update(b);
			return b;
		}
		@Override
		public void deleteBienImmobilier(int id) {
			s=sf.getCurrentSession();
			String req="DELETE FROM BienImmobilier b WHERE b.id=:pID";
			q=s.createQuery(req);
			q.setParameter("pID", id);
			q.executeUpdate();
		}
		@Override
		public List<BienImmobilier> getAllBienImmobilier() {
			s=sf.getCurrentSession();
			String req="FROM BienImmobilier";
			q=s.createQuery(req);
			return q.list();
		}
		@Override
		public BienImmobilier getBienImmobilierById(int id) {
			s=sf.getCurrentSession();
			String req="FROM BienImmobilier b WHERE b.id=:pID";
			q=s.createQuery(req);
			q.setParameter("pID", id);
			return (BienImmobilier) q.uniqueResult();
		}

}
