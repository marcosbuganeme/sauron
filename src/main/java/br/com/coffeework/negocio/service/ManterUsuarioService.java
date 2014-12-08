package br.com.coffeework.negocio.service;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.coffeework.exception.NegocioException;
import br.com.coffeework.exception.RegistroJaExisteException;
import br.com.coffeework.exception.ValidacaoException;
import br.com.coffeework.modelo.entidade.Permissao;
import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.negocio.service.facade.ManterUsuarioServiceFacade;
import br.com.coffeework.persistencia.dao.PermissaoDAO;
import br.com.coffeework.persistencia.dao.UsuarioDAO;
import br.com.coffeework.springsecurity.UsuarioSistema;
import br.com.coffeework.util.criptografia.UtilCriptografia;
import br.com.coffeework.util.jpa.Transacional;
import br.com.coffeework.util.pattern.UtilCPF;

/**
 * <p>
 * <b>Título:</b> UsuarioService.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar as funções de negócio relativas ao ECDU 02 - Manter Usuário.
 * </p>
 *
 * Data de criação: 23/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class ManterUsuarioService extends Service<Usuario> implements ManterUsuarioServiceFacade {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 3746924077180788965L;

	/** Constante REGISTRO_DE_EMAIL_JA_EXISTE. */
	private static final String REGISTRO_DE_EMAIL_JA_EXISTE = "validacao.usuario.email.existe";

	/** Constante REGISTRO_DE_CPF_JA_EXISTE. */
	private static final String REGISTRO_DE_CPF_JA_EXISTE = "validacao.usuario.cpf.existe";

	/** Constante CPF_INVALIDO. */
	private static final String CPF_INVALIDO = "validacao.cpf.invalido";

	/** Constante MSG_USUARIO_VINCULO_PERMISSAO. */
	private static final String MSG_USUARIO_VINCULO_PERMISSAO = "validacao.usuario.vinculo.permissao";

	/** Atributo dao. */
	@Inject
	private UsuarioDAO dao;

	/** Atributo permissaoDAO. */
	@Inject
	private PermissaoDAO permissaoDAO;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.Service#salvar(br.com.coffeework.modelo.entidade.Entidade)
	 */
	@Transacional
	@Override
	public void salvar(final Usuario usuario) throws NegocioException {

		if (usuario != null && !StringUtils.isEmpty(usuario.getSenha())) {

			if (this.isUsuarioJaExiste(usuario)) {

				throw new RegistroJaExisteException(ManterUsuarioService.REGISTRO_DE_EMAIL_JA_EXISTE);
			}

			if (this.isCPFJaExiste(usuario)) {

				throw new RegistroJaExisteException(ManterUsuarioService.REGISTRO_DE_CPF_JA_EXISTE);
			}

			if (!UtilCPF.validaCPF(usuario.getCpf())) {

				throw new ValidacaoException(ManterUsuarioService.CPF_INVALIDO);
			}

			final String senhaCriptografada = UtilCriptografia.obterStringMD5(usuario.getSenha());

			usuario.setSenha(senhaCriptografada);

			this.getDao().salvar(usuario);
		}
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.Service#mesclar(br.com.coffeework.modelo.entidade.Entidade)
	 */
	@Transacional
	@Override
	public void mesclar(final Usuario usuario) throws NegocioException {

		if (usuario != null && !usuario.getSenha().trim().equals("")) {

			final String senhaCriptografada = UtilCriptografia.obterStringMD5(usuario.getSenha());

			usuario.setSenha(senhaCriptografada);

			this.getDao().mesclar(usuario);
		}
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.Service#remover(br.com.coffeework.modelo.entidade.Entidade)
	 */
	@Transacional
	@Override
	public void remover(final Usuario usuario) throws NegocioException {

		if (this.isUsuarioComPermissao(usuario)) {

			throw new NegocioException(ManterUsuarioService.MSG_USUARIO_VINCULO_PERMISSAO);
		}

		super.remover(usuario);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ManterUsuarioServiceFacade#isUsuarioJaExiste(br.com.coffeework.modelo.entidade.Usuario)
	 */
	@Override
	public boolean isUsuarioJaExiste(final Usuario usuario) {

		final Usuario usuarioObtido = this.getDao().obterUsuarioPorEmail(usuario.getEmail());

		if (usuarioObtido != null) {

			return true;
		}

		return false;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ManterUsuarioServiceFacade#isCPFJaExiste(br.com.coffeework.modelo.entidade.Usuario)
	 */
	@Override
	public boolean isCPFJaExiste(final Usuario usuario) {

		final Usuario usuarioObtido = this.getDao().obterUsuarioPorCPF(usuario.getCpf());

		if (usuarioObtido != null) {

			return true;
		}

		return false;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ManterUsuarioServiceFacade#isUsuarioComPermissao(br.com.coffeework.modelo.entidade.Usuario)
	 */
	@Override
	public boolean isUsuarioComPermissao(final Usuario usuario) {

		final Collection<Permissao> colecaoPermissao = this.getPermissaoDAO().obterPermissaoUsuario((Long) usuario.getIdentificador());

		if (colecaoPermissao.size() == 0) {

			return false;
		}

		return true;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ManterUsuarioServiceFacade#isUsuarioLogadoIgualUsuarioRemovido(br.com.coffeework.springsecurity.UsuarioSistema, br.com.coffeework.modelo.entidade.Usuario)
	 */
	@Override
	public boolean isUsuarioLogadoIgualUsuarioRemovido(final UsuarioSistema usuarioLogado, final Usuario usuarioRemover) {

		if (usuarioLogado.getUsuario().equals(usuarioRemover)) {

			return true;
		}

		return false;
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
	protected UsuarioDAO getDao() {

		return this.dao;
	}

	/**
	 * Retorna o valor do atributo <code>permissaoDAO</code>
	 *
	 * @return <code>PermissaoDAO</code>
	 */
	private final PermissaoDAO getPermissaoDAO() {

		return this.permissaoDAO;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ManterUsuarioServiceFacade#isUsuarioPossuiCarteira(java.lang.Long)
	 */
	@Override
	public boolean isUsuarioPossuiCarteira(final Serializable idUsuario) {

		return this.getDao().isUsuarioPossuiCarteira(idUsuario);
	}

}
