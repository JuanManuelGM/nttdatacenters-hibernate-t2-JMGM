package com.nttdata.persistence.dao.impl;

import java.util.List;

import com.nttdata.persistence.dao.impl.CommonDaoImpl;
import com.nttdata.persistence.entities.Contract;
import com.nttdata.persistence.dao.interfaces.ContractDaoI;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Implementacion del DAO de contrato
 * 
 * @author jgilmedi
 *
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	/**
	 * LOGGER
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ContractDaoImpl.class);
	
	/**
	 * Session de conexion a BBDD
	 */
	private Session session;
	
	/**
	 * Constructor
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	@Override
	public List<Contract> searchContractByClientId(Long clientId){
		
		LOG.info("Metodo searchContractByClientId comenzado");
		
		// Verificacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		LOG.info("Metodo searchContractByClientId ejecutado");
		
		//Busqueda
		return session.createQuery("FROM T_Contract JOIN TO T_Client WHERE Client_Id LIKE '%" + clientId + "%'").list();

	}
}
