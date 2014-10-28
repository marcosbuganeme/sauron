package br.com.coffeework.negocio.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.coffeework.modelo.entidade.Permissao;
import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.negocio.service.facade.ManterPermissaoServiceFacade;
import br.com.coffeework.persistencia.dao.PermissaoDAO;
import br.com.coffeework.persistencia.dao.UsuarioDAO;

/**
 * <p>
 * <b>Título:</b> ManterPermissaoService.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por conter a implementação das regras de negócio que serão vinculadas a entidade <code>Permissao</code>.
 * </p>
 *
 * Data de criação: 01/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class ManterPermissaoService extends Service<Permissao> implements ManterPermissaoServiceFacade {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 3800350440690700167L;

	/** Atributo dao. */
	@Inject
	private PermissaoDAO dao;

	/** Atributo usuarioDAO. */
	@Inject
	private UsuarioDAO usuarioDAO;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ManterPermissaoServiceFacade#consultarTodosUsuarios()
	 */
	@Override
	public Collection<Usuario> consultarTodosUsuarios() {

		return this.getUsuarioDAO().listar();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.Service#getDao()
	 */
	@Override
	protected PermissaoDAO getDao() {

		return this.dao;
	}

	/**
	 * Retorna o valor do atributo <code>usuarioDAO</code>
	 *
	 * @return <code>UsuarioDAO</code>
	 */
	public UsuarioDAO getUsuarioDAO() {

		return this.usuarioDAO;
	}

}
