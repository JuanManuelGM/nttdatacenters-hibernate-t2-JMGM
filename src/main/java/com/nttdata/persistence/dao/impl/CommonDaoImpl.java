package com.nttdata.persistence.dao.impl;

import com.nttdata.persistence.dao.interfaces.CommonDaoI;
import com.nttdata.persistence.entities.AbstractEntity;

import java.util.List;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Implementacion DAO generico
 * 
 * @author jgilmedi
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {
	
	/**
	 * LOGGER
	 */
	private static Logger LOG = LoggerFactory.getLogger(CommonDaoImpl.class);

	/**
	 * Tipo de clase
	 */
	private Class<T> entityClass;
	
	/**
	 * Getter de EntityClass
	 * 
	 * @return entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}
	
	/**
	 * Setter de EntityClass
	 * 
	 * @param entityClass
	 *            
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	/**
	 * Sesion de conexion a BD
	 * 
	 * @param session
	 */
	private Session session;
	
	/**
	 * Constructor
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass( (Class<T>) ( (ParameterizedType) this.getClass().getGenericSuperclass() ).getActualTypeArguments() [0] );
		this.session = session;
	}
	
	/**
	 * Metodo insertar
	 * 
	 * @param paramT
	 */
	@Override
	public void insert(final T paramT) {

		LOG.info("Metodo insert comenzado");
		
		// Verificacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insertar
		//Warning el metodo save es de versiones anteriores a la 6.0
		session.save(paramT);
		session.flush();

		// Commit
		session.getTransaction().commit();
		
		LOG.info("Metodo insert ejecutado");
	}
	
	/**
	 * Metodo actualizar
	 * 
	 * @param paramT
	 */
	@Override
	public void update(final T paramT) {

		LOG.info("Metodo update comenzado");
		
		// Verificacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserccion
		//Warning el metodo saveOrUpdate es de versiones anteriores a la 6.0
		session.saveOrUpdate(paramT);

		// Commit
		session.getTransaction().commit();
		
		LOG.info("Metodo update ejecutado");
	}
	
	/**
	 * Metodo eliminar
	 * 
	 * @param paramT
	 */
	@Override
	public void delete(final T paramT) {

		LOG.info("Metodo delete comenzado");

		// Verificacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserccion
		//Warning el metodo delete es de versiones anteriores a la 6.0

		session.delete(paramT);

		// Commit
		session.getTransaction().commit();

		LOG.info("Metodo delete ejecutado");
	}
	
	/**
	 * Metodo buscar por Id
	 * 
	 * @param id
	 * @return result
	 */
	@Override
	public T searchById(final Long id) {

		LOG.info("Metodo serachById comenzado");
		
		// Verificacion de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Busqueda
		T result = session.get(this.entityClass, id);

		LOG.info("Metodo searchById ejecutado");
		
		return result;
	}
	
	/**
	 * Metodo buscar todos
	 * 
	 * 
	 */
	@Override
	public List<T> searchAll(){
		
		LOG.info("Metodo searchAll comenzado");
		
		// Verificacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Busqueda de todos los registros
		List<T> list = session.createQuery("FROM " + this.entityClass.getName()).list();

		LOG.info("Metodo searchAll ejecutado");
		
		return list;
	}
	
}
