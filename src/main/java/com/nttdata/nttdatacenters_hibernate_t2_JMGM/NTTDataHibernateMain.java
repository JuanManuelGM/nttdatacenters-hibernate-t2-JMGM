package com.nttdata.nttdatacenters_hibernate_t2_JMGM;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.entities.Client;
import com.nttdata.persistence.entities.Contract;
import com.nttdata.services.impl.ClientManagerServiceImpl;
import com.nttdata.services.impl.ContractManagerServiceImpl;
import com.nttdata.services.interfaces.ClientManagerServiceI;
import com.nttdata.services.interfaces.ContractManagerServiceI;

/**
 * Taller 2 de Hibernate
 * 
 * Main Class
 * 
 * @author jgilmedi
 *
 */
public class NTTDataHibernateMain {

	/**
	 * Metodo principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws ParseException {
		
		//Apertura de sesion
		Session session = NTTDataHibernateUtil.getSessionFactory().openSession();
		
		//Inyeccion de servicios
		ClientManagerServiceI clientService = new ClientManagerServiceImpl(session);
		ContractManagerServiceI contractService = new ContractManagerServiceImpl(session);
		
		//Auditoria
		String updatedUser = "Juanma";
		Date updateDate = new Date();
		
		//Creacion de clientes
		Client client1 = new Client();
		
		Client client2 = new Client();
		
		//Creacion de contratos
		Contract contract1 = new Contract();

		Contract contract2 = new Contract();
		
		Contract contract3 = new Contract();

		Contract contract4 = new Contract();

		
		//Creacion de listas de contratos para introducirlos a cliente
		List<Contract> contractListA = new ArrayList<>();
		contractListA.add(contract1);
		contractListA.add(contract2);
		
		List<Contract> contractListB = new ArrayList<>();
		contractListB.add(contract3);
		contractListB.add(contract4);
		
		//Asignacion de valores a cliente 1 y 2
		client1.setClientDNI("123456789A");
		client1.setClientName("Paco");
		client1.setClientFSurname("Medina");
		client1.setClientSSurname("Morales");
		client1.setContractList(contractListA);
		
		client2.setClientDNI("123456789B");
		client2.setClientName("Pepe");
		client2.setClientFSurname("Francisco");
		client2.setClientSSurname("Peral");
		client1.setContractList(contractListB);
		
		//Asignacion de formato de fechas para introducirlas a contrato
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		String fechaStringA = "15/09/2023";
		String fechaStringB = "17/10/2022";
		Date fechaA = format.parse(fechaStringA);
		Date fechaB = format.parse(fechaStringB);
		
		//Asignacion de valores a contrato 1 y 2
		contract1.setValidityDate(fechaA);
		contract1.setExpirationDate(fechaA);
		contract1.setMonthlyPrice(79.99);
		contract1.setClient(client1);
		
		contract2.setValidityDate(fechaB);
		contract2.setExpirationDate(fechaB);
		contract2.setMonthlyPrice(99.99);
		contract2.setClient(client1);
		
		contract3.setValidityDate(fechaB);
		contract3.setExpirationDate(fechaB);
		contract3.setMonthlyPrice(199.99);
		contract3.setClient(client2);
		
		contract4.setValidityDate(fechaA);
		contract4.setExpirationDate(fechaA);
		contract4.setMonthlyPrice(499.99);
		contract4.setClient(client2);
		
		//Uso de servicio de cliente
		clientService.insertNewClient(client1);
		clientService.insertNewClient(client2);
		List<Client> allClients = clientService.searchAllClients();
		List<Client> nameCLients = clientService.searchClientByNameAndSurname("Paco", "Medina", "Morales");
		
		//Update de cliente
		client1.setClientName("Luis");
		clientService.updateClient(client1);
		
		//Delete de cliente
		clientService.deleteClient(client2);
		
		//Uso del servicio de contrato
		contractService.insertNewContract(contract1);
		contractService.insertNewContract(contract2);
		contractService.insertNewContract(contract3);
		contractService.insertNewContract(contract4);
		
		//Update de contrato
		contract1.setMonthlyPrice(25.99);
		contractService.updatecontract(contract1);
		
		//Delete de contrato
		contractService.deleteContract(contract1);

	}
}
