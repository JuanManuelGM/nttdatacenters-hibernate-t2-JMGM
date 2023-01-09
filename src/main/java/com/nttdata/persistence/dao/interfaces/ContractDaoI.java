package com.nttdata.persistence.dao.interfaces;

import java.util.List;

import com.nttdata.persistence.entities.Contract;

/**
 * Interfaz del DAO de contrato
 * 
 * @author jgilmedi
 *
 */
public interface ContractDaoI extends CommonDaoI<Contract> {

	/**
	 * Metodo para obtener los contratos por el id del cliente asociado
	 * 
	 * @param clientId
	 * @return List<Contract>
	 */
	public List<Contract> searchContractByClientId(Long clientId);
	
}
