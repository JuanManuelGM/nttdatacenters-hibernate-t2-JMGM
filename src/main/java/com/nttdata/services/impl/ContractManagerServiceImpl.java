package com.nttdata.services.impl;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.persistence.dao.impl.ContractDaoImpl;
import com.nttdata.services.interfaces.ContractManagerServiceI;
import com.nttdata.persistence.dao.interfaces.ContractDaoI;
import com.nttdata.persistence.entities.Client;
import com.nttdata.persistence.entities.Contract;


/**
 * Implementacion del Service Manager de contrato
 * 
 * @author jgilmedi
 *
 */
public class ContractManagerServiceImpl implements ContractManagerServiceI {

	/**
	 * LOGGER
	 */
	private static Logger LOG = LoggerFactory.getLogger(ContractManagerServiceImpl.class);

	/**
	 * DAO de contrato
	 */
	private ContractDaoI contractDao;
	
	/**
	 * Constructor
	 * 
	 * @param sesion
	 */
	public ContractManagerServiceImpl(final Session sesion) {
		this.contractDao = new ContractDaoImpl(sesion);
	}
	
	/**
	 * Metodo insertar contrato 
	 * 
	 * @param newContract
	 */
	@Override
	public void insertNewContract(Contract newContract) {

		LOG.info("Metodo insertar nuevo contrato comenzado ");
		
		// Verifica que newContract y su Id no son nulos
		if (newContract != null && newContract.getContractId() == null) {

			// Inserta contrato
			contractDao.insert(newContract);
		}
		
		LOG.info("Metodo insertar nuevo cliente ejecutado ");

	}
	
	/**
	 * Metodo actualizar contrato
	 * 
	 * @param contractUpdate
	 */
	@Override
	public void updatecontract(Contract contractUpdate) {

		LOG.info("Metodo actualizar contrato comenzado ");
		
		// Verifica que contractUpdate y su Id no son nulos
		if (contractUpdate != null && contractUpdate.getContractId() != null) {

			// Actualiza contrato
			contractDao.update(contractUpdate);
		}

		LOG.info("Metodo actualizar cliente ejecutado ");
		
	}
	
	/**
	 * Metodo eliminar contrato
	 * 
	 * @param contractDelete
	 */
	@Override
	public void deleteContract(Contract contractDelete) {

		LOG.info("Metodo eliminar contrato comenzado ");
		
		// Verifica que contractDelete y su Id no son nulos
		if (contractDelete != null && contractDelete.getContractId() != null) {

			// Elimina contrato
			contractDao.delete(contractDelete);
		}

		LOG.info("Metodo eliminar contrato ejecutado ");
		
	}
	
	/**
	 * Metodo buscar contrato por Id
	 * 
	 * @param contractID
	 * 
	 * @return contract
	 */
	@Override
	public Contract searchContractById(Long contractId) {

		LOG.info("Metodo buscar contrato por id comenzado ");
		
		//Inicia el resultado a nulo para devolverlo en caso de que el Id no exista o no coincida
		Contract contract = null;
		
		//Comprueba que el id introducido no es nulo e iguala el resultado a contract para devolverlo
		if (contractId != null) {
			contract = contractDao.searchById(contractId);
		}
		
		LOG.info("Metodo buscar contrato por id ejecutado ");

		//Devuelve el resultado
		return contract;
	}
	
	/**
	 * Metodo para buscar todos los contratos
	 * 
	 * @return contractList
	 */
	@Override
	public List<Contract> searchAllContracts(){
		
		LOG.info("Metodo buscar todos los contratos comenzado");
		
		//Inicia resultado
		List<Contract> contractList;
		
		//Llama al metodo correspondiente
		contractList = contractDao.searchAll();
		
		LOG.info("Metodo buscar todos los contratos ejecutado");
		
		//Devuelve la lista de contratos
		return contractList;
	}
	
	/**
	 * Metodo para buscar contratos por id de cliente asociado
	 * 
	 * @return contractDao.searchContractByClientId
	 */
	@Override
	public List<Contract> searchContractByClientId(Long clientId){
		LOG.info("Metodo searchContractByClientId");
		
		//Devuelve directamente el resultado llamando al metodo correspondiente del DAO de contrato
		return contractDao.searchContractByClientId(clientId);
	}
}
