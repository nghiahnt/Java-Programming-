package Final_Project.Final_Project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		// Configuration project
		Configuration configuration = new Configuration();
		configuration.configure("hibernate_connection.cfg.xml");
		
		// Check connection
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.close();
	}
}
