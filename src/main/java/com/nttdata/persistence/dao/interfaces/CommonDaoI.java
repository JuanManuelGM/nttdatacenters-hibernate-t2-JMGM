package com.nttdata.persistence.dao.interfaces;

import java.util.List;

/**
 * Interfaz DAO generico
 * 
 * @author jgilmedi
 *
 * @param <T>
 */
public interface CommonDaoI<T> {

	/**
	 * Insertar a BBDD
	 * 
	 * @param paramT
	 */
	public void insert(final T paramT);
	
	/**
	 * Actualizar en BBDD
	 * 
	 * @param paramT
	 */
	public void update(final T paramT);
	
	/**
	 * Eliminar de BBDD 
	 * 
	 * @param paramT
	 */
	public void delete(final T paramT);
	
	/**
	 * Buscar por Id en BBDD
	 * 
	 * @param id
	 */
	public T searchById(final Long id);
	
	/**
	 * Buscar todos los registros de BBDD
	 * 
	 * @return List<T>
	 */
	public List<T> searchAll();
}
