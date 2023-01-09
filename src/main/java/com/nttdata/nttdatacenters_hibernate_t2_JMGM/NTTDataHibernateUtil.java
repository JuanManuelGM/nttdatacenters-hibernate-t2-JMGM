package com.nttdata.nttdatacenters_hibernate_t2_JMGM;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * TALLER 2 HIBERNATE UTIL
 *
 *@author jgilmedi
 *
 */
public class NTTDataHibernateUtil {
    
	/** 
	 * Factoria de sesiones 
	 */
	private static SessionFactory Session_Factory;
	
	/**
	 * Constructor privado
	 */
	private NTTDataHibernateUtil() {
		
	}
	
	/**
	 * Generacion de factoria de sesiones
	 */
	static {

		try {

			// Generacion de configuracion
			Session_Factory = new Configuration().configure().buildSessionFactory();

		} catch (final Exception ex) {

			// Error de inicializacion
			System.err.println("[ERROR] Configuración de Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}

	}
	
	/**
	 * Devuelve la factoria de sesiones
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return Session_Factory;
	}
	
}
