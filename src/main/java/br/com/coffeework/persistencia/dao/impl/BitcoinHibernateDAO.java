package br.com.coffeework.persistencia.dao.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;

import br.com.coffeework.modelo.entidade.BitCoin;
import br.com.coffeework.modelo.enuns.EnumStatus;
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

	@Override
	public boolean isBitcoinPossuiTransacao(final Long idBitcoin) {

		final Criteria criteria = this.obterCriteria();

		criteria.add(Restrictions.eq("status", EnumStatus.ATIVO));

		if (idBitcoin != null) {

			criteria.add(Restrictions.eq("id", idBitcoin));
		}

		criteria.createAlias("transacao", "t");

		criteria.add(Restrictions.eq("t.bitcoin.id", idBitcoin));

		final int quantidadeRegistros = (int) criteria.uniqueResult();

		return quantidadeRegistros > 0 ? true : false;
	}

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
