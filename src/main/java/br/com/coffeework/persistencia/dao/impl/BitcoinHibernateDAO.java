package br.com.coffeework.persistencia.dao.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.coffeework.modelo.entidade.BitCoin;
import br.com.coffeework.persistencia.dao.BitcoinDAO;

/**
 * <p>
 * <b>Título:</b> BitcoinHibernateDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar as funções do repositório da entidade <code>Bitcoin</code>.
 * </p>
 *
 * Data de criação: 27/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class BitcoinHibernateDAO extends HibernateDAO<BitCoin> implements BitcoinDAO {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1193870797085387214L;

	/** Atributo manager. */
	@Inject
	private EntityManager manager;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.persistencia.dao.impl.HibernateDAO#getManager()
	 */
	@Override
	protected EntityManager getManager() {

		return this.manager;
	}

}
