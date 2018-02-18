package com.son.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        try {        	
            // Hibernate 4.3.x 
            // Crear  SessionFactory desde hibernate.cfg.xml 
        	// Configuration configuration = new Configuration().configure("hibernate.cfg.xml");     
        	// return configuration.buildSessionFactory( new StandardServiceRegistryBuilder().applySettings( configuration.getProperties() ).build() );

            // Hibernate 5.x 
            // Crear SessionFactory desde hibernate.cfg.xml
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
            
        }
        catch (Throwable ex) {
            System.err.println("Creacion de SessionFactory fallo " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
