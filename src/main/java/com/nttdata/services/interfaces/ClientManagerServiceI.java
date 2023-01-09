package com.nttdata.services.interfaces;

import java.util.List;

import com.nttdata.persistence.entities.Client;

/**
 * Interfaz del Service Manager de cliente
 * 
 * @author jgilmedi
 *
 */
public interface ClientManagerServiceI {

	/**
	 * Metodo insertar cliente
	 * 
	 * @param newClient
	 */
	public void insertNewClient(Client newClient);
	
	/**
	 * Metodo actualizar cliente
	 * 
	 * @param clientUpdate
	 */
	public void updateClient(Client clientUpdate);
	
	/**
	 * Metodo eliminar cliente
	 * 
	 * @param clientDelete
	 */
	public void deleteClient(Client clientDelete);
	
	/**
	 * Metodo buscar cliente por Id
	 * 
	 * @param clientId
	 * 
	 * @returnclient
	 */
	public Client searchClientById(Long clientId);
	
	/**
	 * Metodo buscar todos los clientes
	 * 
	 * @return clientList
	 */
	public List<Client> searchAllClients();
	
	/**
	 * Metodo buscar cliente por nombre y apellidos
	 * 
	 * @param name
	 * @param firstSurname
	 * @param secondSurname
	 * 
	 * @return clienteDao.searchByNameAndSurname
	 */
	public List<Client> searchClientByNameAndSurname(String name, String firstSurname, String secondSurname);
	
}
