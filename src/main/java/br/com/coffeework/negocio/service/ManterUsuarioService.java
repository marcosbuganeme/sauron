package br.com.coffeework.negocio.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.coffeework.exception.NegocioException;
import br.com.coffeework.exception.RegistroJaExisteException;
import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.negocio.service.facade.ManterUsuarioServiceFacade;
import br.com.coffeework.persistencia.dao.UsuarioDAO;
import br.com.coffeework.util.criptografia.UtilCriptografia;
import br.com.coffeework.util.jpa.Transacional;

/**
 * <p>
 * <b>Título:</b> UsuarioService.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por prover funções relacionadas as regras de negócio da aplicação.
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

	/** Constante REGISTRO_JA_EXISTE. */
	private static final String REGISTRO_JA_EXISTE = "validacao.usuario.existe";

	/** Atributo dao. */
	@Inject
	private UsuarioDAO dao;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ManterUsuarioServiceFacade#autoCompleteUsuarioPorEmail(java.lang.String)
	 */
	@Override
	public Collection<Usuario> autoCompleteUsuarioPorEmail(final String email) {

		return this.getDao().autoCompleteUsuarioPorEmail(email);
	}

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

		if (usuario != null && !usuario.getSenha().trim().equals("")) {

			if (this.isUsuarioJaExiste(usuario)) {

				throw new RegistroJaExisteException(ManterUsuarioService.REGISTRO_JA_EXISTE);
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
	 * @see br.com.coffeework.negocio.service.Service#getDao()
	 */
	@Override
	protected UsuarioDAO getDao() {

		return this.dao;
	}

}
