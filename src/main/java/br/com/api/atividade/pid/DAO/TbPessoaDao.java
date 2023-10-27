package br.com.api.atividade.pid.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.api.atividade.pid.entity.TbPessoa;
import br.com.api.atividade.pid.utilProvider.EntityManagerProvider;

public class TbPessoaDao extends GenericDAO<TbPessoa, Long>{

  
	public TbPessoaDao() {
		super(TbPessoa.class);
		// TODO Auto-generated constructor stub
	}

  public TbPessoa findByPessoa(Long cpf) {

		TbPessoa tbPessoa = null;

		EntityManager em = EntityManagerProvider.getInstance().createManager();

		try {

			TypedQuery<TbPessoa> query = em
					.createQuery("from TbPessoa where cpf = :cpf", TbPessoa.class);

			query.setParameter("cpf", cpf);

			tbPessoa = query.getSingleResult();

			return tbPessoa;

		} catch (Exception e) {
			e.getMessage();
			return null;
		} finally {
			em.close();
		}
	}

	public Boolean deleteById(Long cpf) {

		EntityManager em = EntityManagerProvider.getInstance().createManager();
		String HQL = "DELETE from TbPessoa where cpf = :cpf";
		Query query = em.createNativeQuery(HQL, TbPessoa.class);
		query.setParameter("cpf", cpf);

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
