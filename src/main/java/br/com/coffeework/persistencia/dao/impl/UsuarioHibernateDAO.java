package br.com.coffeework.persistencia.dao.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.modelo.enuns.EnumStatus;
import br.com.coffeework.persistencia.dao.UsuarioDAO;

/**
 * <p>
 * <b>Título:</b> UsuarioHibernateDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por disponibilizar as implementações da interface <code>UsuarioDAO</code>.
 * </p>
 *
 * Data de criação: 21/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class UsuarioHibernateDAO extends HibernateDAO<Usuario> implements UsuarioDAO {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -2853667669101185513L;

	/** Atributo manager. */
	@Inject
	private EntityManager manager;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.persistencia.dao.UsuarioDAO#obterUsuarioPorEmail(java.lang.String)
	 */
	@Override
	public Usuario obterUsuarioPorEmail(final String email) {

		final Criteria criteria = this.obterCriteria();

		criteria.add(Restrictions.eq("status", EnumStatus.ATIVO));

		if (email != null && !StringUtils.isEmpty(email)) {

			criteria.add(Restrictions.eq("email", email));
		}

		return (Usuario) criteria.uniqueResult();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.persistencia.dao.UsuarioDAO#obterUsuarioPorCPF(java.lang.String)
	 */
	@Override
	public Usuario obterUsuarioPorCPF(final String cpf) {

		final Criteria criteria = this.obterCriteria();

		criteria.add(Restrictions.eq("status", EnumStatus.ATIVO));

		if (cpf != null && !StringUtils.isEmpty(cpf)) {

			criteria.add(Restrictions.eq("cpf", cpf));
		}

		return (Usuario) criteria.uniqueResult();
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
