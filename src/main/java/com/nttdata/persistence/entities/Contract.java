package com.nttdata.persistence.entities;

import java.io.Serializable;	
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;


/**
 * ENTIDAD CONTRACT
 * 
 * @author jgilmedi
 *
 */
@Entity
@Table(name = "T_Contract")
public class Contract extends AbstractEntity implements Serializable {
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Id de contrato
	 */
	private Long contractId;
	
	/**
	 * Fecha de vigencia
	 */
	private Date validityDate;
	
	/**
	 * Fecha de caducidad
	 */
	private Date expirationDate;
	
	/**
	 * Precio mensual
	 */
	private Double monthlyPrice;
	
	/**
	 * Cliente asociado
	 */
	private Client client;
	
	/**
	 * Getter del Id
	 * 
	 * @return contractId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Contract_Id")
	public Long getContractId() {
		return contractId;
	}
	
	/**
	 * Getter de la fecha de validez 
	 * 
	 * @return validityDate
	 */
	@Column(name = "Contract_Validity_Date")
	public Date getValidityDate() {
		return validityDate;
	}
	
	/**
	 * Setter de la fecha de validez
	 * 
	 * @param newVDate
	 */
	public void setValidityDate(Date newVDate) {
		this.validityDate = newVDate;
	}

	/**
	 * Getter de fecha de expiracion
	 * 
	 * @return expirationDate
	 */
	@Column(name = "Contract_Expiration_Date")
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Setter de fecha de expiracion
	 * 
	 * @param newEDate
	 */
	public void setExpirationDate(Date newEDate) {
		this.expirationDate = newEDate;
	}

	/**
	 * Getter del precio mensual
	 * 
	 * @return monthlyPrice
	 */
	@Column(name = "Contract_Monthly_Price")
	public Double getMonthlyPrice() {
		return monthlyPrice;
	}

	/**
	 * Setter del precio mensual
	 * 
	 * @param newMPrice
	 */
	public void setMonthlyPrice(Double newMPrice) {
		this.monthlyPrice = newMPrice;
	}

	/**
	 * Getter del cliente asociado
	 * 
	 * @return client
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Contract_Client_Id", referencedColumnName = "Client_Id")
	public Client getClient() {
		return client;
	}

	/**
	 * Setter del cliente asociado
	 * 
	 * @param newclient
	 */
	public void setClient(Client newclient) {
		this.client = newclient;
	}

	/**
	 * Override de getId para AbstractEntity
	 */
	@Override
	public Long getId() {
		return contractId;
	}

	/**
	 * Override de setID para abstractEntity
	 */
	@Override
	public void setId(Long id) {
		this.contractId = id;
	}
	
	

}
