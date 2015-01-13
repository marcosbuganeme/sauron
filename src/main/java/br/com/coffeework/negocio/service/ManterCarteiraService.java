package br.com.coffeework.negocio.service;

import java.util.Collection;
import java.util.HashSet;

import javax.inject.Inject;

import br.com.coffeework.exception.NegocioException;
import br.com.coffeework.exception.RegistroJaExisteException;
import br.com.coffeework.exception.ValidacaoException;
import br.com.coffeework.modelo.entidade.Carteira;
import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.negocio.service.facade.ManterCarteiraServiceFacade;
import br.com.coffeework.persistencia.dao.CarteiraDAO;
import br.com.coffeework.persistencia.dao.TransacaoDAO;
import br.com.coffeework.persistencia.dao.UsuarioDAO;
import br.com.coffeework.util.jpa.Transacional;

/**
 * <p>
 * <b>Título:</b> ManterCarteiraService.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar as funções de negócio relativas ao ECDU 05 - Manter Carteira.
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
	private static final String REGISTRO_JA_EXISTE = "validacao.carteira.ja.existe";

	/** Constante CARTEIRA_POSSUI_TRANSACAO. */
	private static final String CARTEIRA_POSSUI_TRANSACAO = "validacao.carteira.possui.transacao";

	/** Atributo dao. */
	@Inject
	private CarteiraDAO dao;

	/** Atributo usuarioDAO. */
	@Inject
	private UsuarioDAO usuarioDAO;

	/** Atributo transacaoDAO. */
	@Inject
	private TransacaoDAO transacaoDAO;
	
	@Override
	public Long obterQuantidadeBitcoinPorCarteira(final Long idCarteira) {

		return this.getTransacaoDAO().obterQuantidadeBitcoinPorCarteira(idCarteira);
	}

	@Transacional
	@Override
	public void salvar(final Carteira carteira) throws NegocioException {

		if (carteira != null) {

			if (this.isRegistroExiste(carteira)) {

				throw new RegistroJaExisteException(ManterCarteiraService.REGISTRO_JA_EXISTE);
			}

			this.getDao().salvar(carteira);
		}
	}

	@Transacional
	@Override
	public void remover(final Carteira carteira) throws NegocioException {

		final boolean isCarteiraPossuiTransacao = this.getTransacaoDAO().isCarteiraPossuiTransacao(carteira.getIdentificador());

		if (isCarteiraPossuiTransacao) {

			throw new ValidacaoException(ManterCarteiraService.CARTEIRA_POSSUI_TRANSACAO);
		}

		final Carteira carteiraObtida = this.obterPorId(carteira.getIdentificador());

		if (carteiraObtida != null) {

			this.getDao().remover(carteiraObtida);
		}
	}

	@Override
	public boolean isRegistroExiste(final Carteira carteira) {

		final Carteira carteiraObtida = this.getDao().obterCarteiraPorUsuario((Long) carteira.getUsuario().getIdentificador());

		if (carteiraObtida != null) {

			return true;
		}

		return false;
	}

	@Override
	public Collection<Usuario> listarUsuariosSemCarteira() {

		final Collection<Usuario> colecaoUsuario = this.getUsuarioDAO().listar();

		final Collection<Usuario> colecaoUsuarioSemCarteira = new HashSet<Usuario>(0);

		for (final Usuario usuario : colecaoUsuario) {

			if (usuario.getCarteira() == null) {

				colecaoUsuarioSemCarteira.add(usuario);
			}
		}

		return colecaoUsuarioSemCarteira;
	}

	@Override
	public Collection<Usuario> listarTodosUsuarios() {

		return this.getUsuarioDAO().listar();
	}

	@Override
	protected CarteiraDAO getDao() {

		return this.dao;
	}

	/**
	 * Retorna o valor do atributo <code>usuarioDAO</code>
	 *
	 * @return <code>UsuarioDAO</code>
	 */
	protected UsuarioDAO getUsuarioDAO() {

		return this.usuarioDAO;
	}

	/**
	 * Retorna o valor do atributo <code>transacaoDAO</code>
	 *
	 * @return <code>TransacaoDAO</code>
	 */
	protected TransacaoDAO getTransacaoDAO() {

		return this.transacaoDAO;
	}

}
