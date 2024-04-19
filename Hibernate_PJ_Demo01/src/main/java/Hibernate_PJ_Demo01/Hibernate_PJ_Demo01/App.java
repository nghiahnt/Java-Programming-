package Hibernate_PJ_Demo01.Hibernate_PJ_Demo01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		// Create configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Song.class);

		// Create session factory
		try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
			// Init session object
			Session session = sessionFactory.openSession();

			Song song1 = new Song();

			song1.setId(2);
			song1.setSongName("Baby shark");
			song1.setArtist("Don't_remember");
			
			session.persist(song1);
			session.beginTransaction().commit();;
		}
	}
}
