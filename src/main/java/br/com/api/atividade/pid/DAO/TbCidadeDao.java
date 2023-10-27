package br.com.api.atividade.pid.dao;

import br.com.api.atividade.pid.entity.TbCidade;
import br.com.api.atividade.pid.utilProvider.EntityManagerProvider;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class TbCidadeDao extends GenericDAO<TbCidade, Integer> {

	public TbCidadeDao() {
		super(TbCidade.class);
		// TODO Auto-generated constructor stub
	}

	public TbCidade findByCidade(String cidade) {

		TbCidade tbCategoriaProduto = null;

		EntityManager em = EntityManagerProvider.getInstance().createManager();

		try {

			TypedQuery<TbCidade> query = em.createQuery("from TbCidade where cidade = :cidade", TbCidade.class);

			query.setParameter("cidade", cidade);

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
		String HQL = "DELETE from TbCidade where codigo = :codigo";
		Query query = em.createNativeQuery(HQL, TbCidade.class);
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
