package br.com.api.atividade.pid.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.api.atividade.pid.entity.TbCategoriaProduto;
import br.com.api.atividade.pid.utilProvider.EntityManagerProvider;

public class TbCategoriaProdutoDao extends GenericDAO<TbCategoriaProduto, Integer> {

	public TbCategoriaProdutoDao() {
		super(TbCategoriaProduto.class);
		// TODO Auto-generated constructor stub
	}

	public TbCategoriaProduto findByCategoria(String categoria) {

		TbCategoriaProduto tbCategoriaProduto = null;

		EntityManager em = EntityManagerProvider.getInstance().createManager();

		try {

			TypedQuery<TbCategoriaProduto> query = em
					.createQuery("from TbCategoriaProduto where categoria = :categoria", TbCategoriaProduto.class);

			query.setParameter("categoria", categoria);

			tbCategoriaProduto = query.getSingleResult();

			return tbCategoriaProduto;

		} catch (Exception e) {
			e.getMessage();
			return null;
		} finally {
			em.close();
		}
	}

	public Boolean deleteById(Integer codigo) {

		EntityManager em = EntityManagerProvider.getInstance().createManager();
		String HQL = "DELETE from TbCategoriaProduto where codigo = :codigo";
		Query query = em.createNativeQuery(HQL, TbCategoriaProduto.class);
		query.setParameter("codigo", codigo);

		try {

			em.getTransaction().begin();
			query.executeUpdate();
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

}
