package com.nttdata.services.interfaces;

import java.util.List;

import com.nttdata.persistence.entities.Contract;

/**
 * Interfaz del Service Manager de contrato
 * 
 * @author jgilmedi
 *
 */
public interface ContractManagerServiceI {

	/**
	 * Metodo insertar contrato 
	 * 
	 * @param newContract
	 */
	public void insertNewContract(Contract newContract);
	
	/**
	 * Metodo actualizar contrato
	 * 
	 * @param contractUpdate
	 */
	public void updatecontract(Contract contractUpdate);
	
	/**
	 * Metodo eliminar contrato
	 * 
	 * @param contractDelete
	 */
	public void deleteContract(Contract contractDelete);
	
	/**
	 * Metodo buscar contrato por Id
	 * 
	 * @param contractID
	 * 
	 * @return contract
	 */
	public Contract searchContractById(Long contractId);
	
	/**
	 * Metodo para buscar todos los contratos
	 * 
	 * @return contractList
	 */
	public List<Contract> searchAllContracts();
	
	/**
	 * Metodo para buscar contratos por id de cliente asociado
	 * 
	 * @return contractDao.searchContractByClientId
	 */
	public List<Contract> searchContractByClientId(Long clientId);
	
}
