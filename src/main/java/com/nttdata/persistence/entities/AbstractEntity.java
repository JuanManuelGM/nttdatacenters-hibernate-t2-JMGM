package com.nttdata.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Entidad Abstracta
 * 
 * @author jgilmedi
 *
 */
public abstract class AbstractEntity implements Serializable{

	/**
	 * LOGGER
	 */
	private static Logger LOG = LoggerFactory.getLogger(AbstractEntity.class);
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Usuario que actualiza
	 */
	private String updatedUser;
	
	/**
	 * Fecha de actualizacion
	 */
	private Date updatedDate;
	
	/**
	 * Getter ID
	 * 
	 * @return Long
	 */
	public abstract Long getId();
	
	/**
	 * Setter ID
	 * 
	 * @param Id 
	 */
	public abstract void setId(Long id);
	
	/**
	 * Getter de updatedUser
	 * 
	 * @return updatedUser
	 */
	@Column(name = "AUDIT_UPDATED_USER", nullable = false)
	public String getUpdatedUser() {
		LOG.info("Getter de updatedUser ejecutado");
		return updatedUser;
	}
	
	/**
	 * Setter de updatedUser
	 * 
	 * @param updatedUser
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
		LOG.info("Setter de updatedUser ejecutado");
	}
	
	/**
	 * Getter de updatedDate
	 * 
	 * @return updatedDate
	 */
	@Column(name = "AUDIT_UPDATED_DATE", nullable = false)
	public Date getUpdatedDate() {
		LOG.info("Getter de updatedDate ejecutado");
		return updatedDate;
	}

	/**
	 * Setter de updatedDate
	 * 
	 * @param updatedDate
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
		LOG.info("Setter de updatedDate ejecutado");
	}
}
