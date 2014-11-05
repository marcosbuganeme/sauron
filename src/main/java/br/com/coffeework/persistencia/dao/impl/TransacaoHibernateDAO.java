package br.com.coffeework.persistencia.dao.impl;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.coffeework.modelo.entidade.Transacao;
import br.com.coffeework.modelo.enuns.EnumStatus;
import br.com.coffeework.persistencia.dao.TransacaoDAO;

/**
 * <p>
 * <b>Título:</b> TransacaoHibernateDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por conter a implementação do repositório da entidade <code>Transacao</code>.
 * </p>
 *
 * Data de criação: 29/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@SuppressWarnings("unchecked")
public class TransacaoHibernateDAO extends HibernateDAO<Transacao> implements TransacaoDAO {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -1416628212846550428L;

	/** Atributo manager. */
	@Inject
	private EntityManager manager;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.persistencia.dao.impl.HibernateDAO#listar()
	 */
	@Override
	public Collection<Transacao> listar() {

		final Criteria criteria = this.obterCriteria();

		criteria.createAlias("carteira", "carteira");

		criteria.createAlias("carteira.usuario", "usuario");

		criteria.createAlias("bitCoin", "bitcoin");

		criteria.add(Restrictions.eq("status", EnumStatus.ATIVO));

		return criteria.list();
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