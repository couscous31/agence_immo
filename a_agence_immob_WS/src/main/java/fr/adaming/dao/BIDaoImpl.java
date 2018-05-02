package fr.adaming.dao;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmobilier;

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
			// Requete HQL
			String req = "FROM BienImmobilier as b";

			// Ouvrir la session
			Session s = sf.getCurrentSession();

			Query query = s.createQuery(req);

			// Cela te permet de transformer ton tableau byte en image url
			// "data:image/png;base64,"=format
			List<BienImmobilier> listebi = query.list();
			for (BienImmobilier b : listebi) {
				b.setImageBI("data:image/png;base64," + Base64.encodeBase64String(b.getPhotoBI()));
			}

			return listebi;
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
