package br.com.coffeework.persistencia.dao.impl;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.coffeework.modelo.entidade.Permissao;
import br.com.coffeework.modelo.enuns.EnumStatus;
import br.com.coffeework.persistencia.dao.PermissaoDAO;

/**
 * <p>
 * <b>Título:</b> PermissaoHibernateDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por conter a implementação das funções de conuslta para a entidade <code>Permissao</code>.
 * </p>
 *
 * Data de criação: 01/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@SuppressWarnings("unchecked")
public class PermissaoHibernateDAO extends HibernateDAO<Permissao> implements PermissaoDAO {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -7764968462298378735L;

	/** Atributo manager. */
	@Inject
	private EntityManager manager;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.persistencia.dao.PermissaoDAO#obterPermissoesPorUsuario(java.lang.Long)
	 */
	@Override
	public Collection<Permissao> obterPermissoesPorUsuario(final Long idUsuario) {

		final Criteria criteria = this.obterCriteria();

		criteria.add(Restrictions.eq("status", EnumStatus.ATIVO));

		criteria.add(Restrictions.eq("usuario", idUsuario));

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
