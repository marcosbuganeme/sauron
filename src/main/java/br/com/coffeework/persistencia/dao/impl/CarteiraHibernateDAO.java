package br.com.coffeework.persistencia.dao.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.coffeework.modelo.entidade.Carteira;
import br.com.coffeework.modelo.enuns.EnumStatus;
import br.com.coffeework.persistencia.dao.CarteiraDAO;

/**
 * <p>
 * <b>Título:</b> CarteiraHibernateDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar as funções do repositório da entidade <code>Carteira</code>.
 * </p>
 *
 * Data de criação: 27/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class CarteiraHibernateDAO extends HibernateDAO<Carteira> implements CarteiraDAO {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -7117555776757083761L;

	/** Atributo manager. */
	@Inject
	private EntityManager manager;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.persistencia.dao.CarteiraDAO#obterCarteiraPorUsuario(java.lang.Long)
	 */
	@Override
	public Carteira obterCarteiraPorUsuario(final Long idUsuario) {

		final Criteria criteria = this.obterCriteria();

		criteria.createAlias("usuario", "user");
		
		criteria.add(Restrictions.eq("status", EnumStatus.ATIVO));

		if (idUsuario != null) {

			criteria.add(Restrictions.eq("user.id", idUsuario));
		}

		return (Carteira) criteria.uniqueResult();
	}

	/**
	 * Retorna o valor do atributo <code>manager</code>
	 *
	 * @return <code>EntityManager</code>
	 */
	@Override
	protected EntityManager getManager() {

		return this.manager;
	}

}
