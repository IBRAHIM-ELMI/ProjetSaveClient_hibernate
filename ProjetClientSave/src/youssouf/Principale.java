package youssouf;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Principale {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Etat session: " + session.isOpen());
		Transaction tx = null;
		try {

			Adresse adr = new Adresse("38 rue victoire", 78000, "Versailles");
			Client monclient = new Client("IBRAHIM", "youssouf", adr);
			Facture f = new Facture(monclient,123.85);
		
		Adresse adr2 = new Adresse("15 bd charle de gaulle", 92000, "Cergy");
		Adresse adr3 = new Adresse("8 rue alexadre", 76620, "Le Havre");
		Adresse adr4 = new Adresse("10 rue aviateur guerin", 76000, "Le Havre");
		Client monclient2 = new Client("HOUSSEIN","Mohamed",adr2);
		Client monclient3 = new Client("ARTHUR","Lucas",adr3);
		Client monclient4 = new Client("TEERY","Youssouf",adr4);

			tx = session.beginTransaction();

			// afficher dans le console le client avec son adresse
			Client c =(Client)session.load(Client.class, 1);
			System.out.println("Client:=> " + monclient);
			System.out.println("Adresse " + monclient.getAdresse());
			for(Object o:monclient.getFactures());

			// requete HQL pour afficher dans le console les clients
//			List result =session.createQuery("from Client").list();
//		for(Object o : result) {
//			System.out.println(o);
//		}

//			session.save(monclient2);
//			session.save(monclient3);
//			session.save(monclient4);
//			session.save(adr2);
//			session.save(f);
//			session.save(adr3);
//			session.save(adr4);
//		session.save(monclient2);
//		session.save(monclient3);
//		session.save(monclient4);
			
			tx.commit();
		}

		catch (Exception ex) {
			tx.rollback();
			throw ex;
		}

		finally {
			session.close();
		}

	}

}
