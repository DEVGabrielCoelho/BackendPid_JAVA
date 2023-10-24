package br.com.api.atividade.pid.DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.Valid;

import br.com.api.atividade.pid.UtilProvider.EntityManagerProvider;

public abstract class GenericDAO<T, I extends Serializable> {

	protected EntityManager entityManager;

	private Class<T> persistedClass;

	protected GenericDAO() {

	}

	public GenericDAO(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	public T save(@Valid T entity) {
		entityManager = getEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			System.out.println("Save error: " + e.toString());
		} finally {
			entityManager.close();
		}
		;

		return entity;

	}

	public T update(@Valid T entity) {
		entityManager = getEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return entity;
		} finally {
			entityManager.close();
			// TODO: handle finally clause
		}
	}

	public void delete(I id) {

		T entity = findId(id);

		entityManager = getEntityManager();

		try {

			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();

		} finally {
			entityManager.close();
		}
	}

	public List<T> getList() {
		entityManager = getEntityManager();

		try {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<T> query = builder.createQuery(persistedClass);
			query.from(persistedClass);
			return entityManager.createQuery(query).getResultList();
		} finally {
			entityManager.close();
			// TODO: handle finally clause
		}

	}

	public T findId(I id) {
		entityManager = getEntityManager();
		try {
			return entityManager.find(persistedClass, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exceptdeleteByIdion
		} finally {
			entityManager.close();
			// TODO: handle finally clause
		}
	}

	public EntityManager getEntityManager() {
		try {
			return EntityManagerProvider.getInstance().createManager();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
	}

}
