package com.nttdata.persistence.dao.impl;

import java.util.List;	

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Session;

import com.nttdata.persistence.entities.Client;
import com.nttdata.persistence.dao.interfaces.ClientDaoI;
import com.nttdata.persistence.dao.impl.CommonDaoImpl;


/**
 * Implementacion del DAO de Cliente
 * 
 * @author jgilmedi
 *
 */
public class ClientDaoImpl extends CommonDaoImpl<Client> implements ClientDaoI{

	/**
	 * LOGGER
	 */
	private static Logger LOG = LoggerFactory.getLogger(ClientDaoImpl.class);
	
	/**
	 * Session de conexion a BBDD
	 */
	private Session session;
	
	/**
	 * Constructor
	 */
	public ClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	/**
	 * Metodo buscar por nombre y apellidos
	 * 
	 * @param clientName
	 * @param clientFSurname
	 * @param clientSSurname
	 * 
	 * @return List<Client>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByNameAndSurname(String clientName, String clientFSurname, String clientSSurname){
		
		LOG.info("Metodo searchByNameAndSurname comenzado");
		
		// Verificacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		//Busqueda
		return session.createQuery("FROM T_Client WHERE Client_Name LIKE '%" + clientName 
				+ "%' AND Client_First_Surname LIKE '%" + clientFSurname 
				+ "%' AND Client_Second_Surname LIKE '%" + clientSSurname + "%'").list();
	}
}