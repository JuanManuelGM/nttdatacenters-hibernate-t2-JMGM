package com.nttdata.services.impl;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.dao.interfaces.ClientDaoI;
import com.nttdata.persistence.dao.impl.ClientDaoImpl;
import com.nttdata.services.interfaces.ClientManagerServiceI;
import com.nttdata.persistence.entities.Client;


/**
 * Implementacion del Manager Service de Cliente
 * 
 * @author jgilmedi
 *
 */
public class ClientManagerServiceImpl implements ClientManagerServiceI {

	/**
	 * LOGGER
	 */
	private static Logger LOG = LoggerFactory.getLogger(ClientManagerServiceImpl.class);

	/**
	 * DAO de cliente
	 */
	private ClientDaoI clientDao;
	
	/**
	 * Constructor
	 * 
	 * @param sesion
	 */
	public ClientManagerServiceImpl(final Session sesion) {
		this.clientDao = new ClientDaoImpl(sesion);
	}
	
	/**
	 * Metodo insertar cliente 
	 * 
	 * @param newCliente
	 */
	@Override
	public void insertNewClient(Client newClient) {

		LOG.info("Metodo insertar nuevo cliente comenzado ");
		
		// Verifica que newClient y su Id no son nulos
		if (newClient != null && newClient.getClientId() == null) {

			// Inserta cliente
			clientDao.insert(newClient);
		}
		
		LOG.info("Metodo insertar nuevo cliente ejecutado ");

	}
	
	/**
	 * Metodo actualizar cliente
	 * 
	 * @param clientUpdate
	 */
	@Override
	public void updateClient(Client clientUpdate) {

		LOG.info("Metodo actualizar cliente comenzado ");
		
		// Verifica que clientUpdate y su Id no son nulos
		if (clientUpdate != null && clientUpdate.getClientId() != null) {

			// Actualiza cliente
			clientDao.update(clientUpdate);
		}

		LOG.info("Metodo actualizar cliente ejecutado ");
		
	}
	
	/**
	 * Metodo eliminar cliente
	 * 
	 * @param clientDelete
	 */
	@Override
	public void deleteClient(Client clientDelete) {

		LOG.info("Metodo eliminar cliente comenzado ");
		
		// Verifica que clientDelete y su Id no son nulos
		if (clientDelete != null && clientDelete.getClientId() != null) {

			// Elimina cliente
			clientDao.delete(clientDelete);
		}

		LOG.info("Metodo eliminar cliente ejecutado ");
		
	}
	
	/**
	 * Metodo buscar cliente por Id
	 * 
	 * @param clientID
	 * 
	 * @return client
	 */
	@Override
	public Client searchClientById(Long clientId) {

		LOG.info("Metodo buscar cliente por id comenzado ");
		
		//Inicia el resultado a nulo para devolverlo en caso de que el Id no exista o no coincida
		Client client = null;
		
		//Comprueba que el id introducido no es nulo e iguala el resultado a client para devolverlo
		if (clientId != null) {
			client = clientDao.searchById(clientId);
		}
		
		LOG.info("Metodo buscar cliente por id ejecutado ");

		//Devuelve el resultado
		return client;
	}
	
	/**
	 * Metodo para buscar todos los clientes
	 * 
	 * @return clientList
	 */
	@Override
	public List<Client> searchAllClients(){
		
		LOG.info("Metodo buscar todos los clientes comenzado");
		
		//Inicia resultado
		List<Client> clientList;
		
		//Llama al metodo correspondiente
		clientList = clientDao.searchAll();
		
		LOG.info("Metodo buscar todos los clientes ejecutado");
		
		//Devuelve la lista de clientes
		return clientList;
	}
	
	@Override
	public List<Client> searchClientByNameAndSurname(String name, String firstSurname, String secondSurname){
		
		LOG.info("Metodo searchCLientByNameAndSurname ejecutado");
		
		//Devuelve directamente el resultado llamando al metodo correspondiente del DAO de cliente
		return clientDao.searchByNameAndSurname(name, firstSurname, secondSurname);
	}
	
}
