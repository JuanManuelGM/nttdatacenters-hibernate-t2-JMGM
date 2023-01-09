package com.nttdata.persistence.dao.interfaces;

import java.util.List;

import com.nttdata.persistence.entities.Client;

/**
 * Interfaz DAO de cliente
 * 
 * @author jgilmedi
 *
 */
public interface ClientDaoI extends CommonDaoI<Client> {

	/**
	 * Metodo buscar por nombre y apellido
	 * 
	 * @param clientName
	 * @param clientFSurname
	 * @param clientSSurname
	 * 
	 * @return List<Client>
	 */
	public List<Client> searchByNameAndSurname(String clientName, String clientFSurname, String clientSSurname);
	
}
