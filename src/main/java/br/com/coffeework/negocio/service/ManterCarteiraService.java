package br.com.coffeework.negocio.service;

import java.util.Collection;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.coffeework.exception.NegocioException;
import br.com.coffeework.exception.RegistroJaExisteException;
import br.com.coffeework.modelo.entidade.Carteira;
import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.negocio.service.facade.ManterCarteiraServiceFacade;
import br.com.coffeework.persistencia.dao.CarteiraDAO;
import br.com.coffeework.persistencia.dao.UsuarioDAO;

/**
 * <p>
 * <b>Título:</b> ManterCarteiraService.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por conter as funções de implementação de negócio da entidade <code>Carteira</code>
 * </p>
 *
 * Data de criação: 27/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class ManterCarteiraService extends Service<Carteira> implements ManterCarteiraServiceFacade {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 2470493317373399714L;

	/** Constante REGISTRO_JA_EXISTE. */
	private static final String REGISTRO_JA_EXISTE = "validacao.carteira.existente";

	/** Atributo dao. */
	@Inject
	private CarteiraDAO dao;

	/** Atributo usuarioDAO. */
	@Inject
	private UsuarioDAO usuarioDAO;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.Service#salvar(br.com.coffeework.modelo.entidade.Entidade)
	 */
	@Transactional
	@Override
	public void salvar(final Carteira carteira) throws NegocioException {

		if (carteira != null) {

			if (this.isRegistroExiste(carteira)) {

				throw new RegistroJaExisteException(ManterCarteiraService.REGISTRO_JA_EXISTE);
			}

			this.getDao().salvar(carteira);
		}
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ManterCarteiraServiceFacade#isRegistroExiste(br.com.coffeework.modelo.entidade.Carteira)
	 */
	@Override
	public boolean isRegistroExiste(final Carteira carteira) {

		final Carteira carteiraObtida = this.getDao().obterCarteiraPorUsuario((Long) carteira.getUsuario().getIdentificador());

		if (carteiraObtida != null) {

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
	 * @see br.com.coffeework.negocio.service.facade.ManterCarteiraServiceFacade#consultarTodosUsuarios()
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
	protected CarteiraDAO getDao() {

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
