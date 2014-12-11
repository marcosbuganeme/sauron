package br.com.coffeework.negocio.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.coffeework.exception.NegocioException;
import br.com.coffeework.exception.ValidacaoException;
import br.com.coffeework.modelo.entidade.Permissao;
import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.modelo.enuns.EnumPermissao;
import br.com.coffeework.negocio.service.facade.ManterPermissaoServiceFacade;
import br.com.coffeework.persistencia.dao.PermissaoDAO;
import br.com.coffeework.persistencia.dao.UsuarioDAO;
import br.com.coffeework.util.jpa.Transacional;

/**
 * <p>
 * <b>Título:</b> ManterPermissaoService.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar as funções de negócio relativas ao ECDU 03 - Manter Permissão.
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

	/** Constante MSG_USUARIO_COM_PERMISSAO_ADMINISTRADOR. */
	private static final String MSG_USUARIO_COM_PERMISSAO_ADMINISTRADOR = "validacao.permissao.usuario.administrador";

	/** Atributo MSG_USUARIO_JA_POSSUI_ESSA_PERMISSAO. */
	private static final String MSG_USUARIO_JA_POSSUI_ESSA_PERMISSAO = "validacao.usuario.permissao.jaexiste";

	/** Atributo dao. */
	@Inject
	private PermissaoDAO dao;

	/** Atributo usuarioDAO. */
	@Inject
	private UsuarioDAO usuarioDAO;

	@Transacional
	@Override
	public void salvar(final Permissao permissao) throws NegocioException {

		final Collection<Permissao> colecaoPermissoes = this.getDao().obterPermissaoUsuario((Long) permissao.getUsuario().getIdentificador());

		if (this.isUsuarioPermissaoAdministradorExistente(colecaoPermissoes)) {

			throw new ValidacaoException(ManterPermissaoService.MSG_USUARIO_JA_POSSUI_ESSA_PERMISSAO);
		}

		if (this.isUsuarioPermissaoUsuarioExistente(colecaoPermissoes)) {

			throw new ValidacaoException(ManterPermissaoService.MSG_USUARIO_JA_POSSUI_ESSA_PERMISSAO);
		}

		super.salvar(permissao);
	}

	@Transacional
	@Override
	public void remover(final Permissao permissao) throws NegocioException {

		final Collection<Permissao> colecaoPermissoes = this.getDao().obterPermissaoUsuario((Long) permissao.getUsuario().getIdentificador());

		if (this.isUsuarioPermissaoAdministradorExistente(colecaoPermissoes)) {

			throw new ValidacaoException(ManterPermissaoService.MSG_USUARIO_COM_PERMISSAO_ADMINISTRADOR);
		}

		super.remover(permissao);
	}

	@Override
	public boolean isUsuarioPermissaoAdministradorExistente(final Collection<Permissao> colecaoPermissoes) {

		for (final Permissao permissao : colecaoPermissoes) {

			if (permissao.getPermissao().equals(EnumPermissao.ADMINISTRADOR)) {

				return true;
			}
		}

		return false;
	}

	public boolean isUsuarioPermissaoUsuarioExistente(final Collection<Permissao> colecaoPermissoes) {

		for (final Permissao permissao : colecaoPermissoes) {

			if (permissao.getPermissao().equals(EnumPermissao.USUARIO)) {

				return true;
			}
		}

		return false;
	}

	@Override
	public Collection<Usuario> consultarTodosUsuarios() {

		return this.getUsuarioDAO().listar();
	}

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
