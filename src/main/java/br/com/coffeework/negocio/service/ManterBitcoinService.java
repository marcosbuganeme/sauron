package br.com.coffeework.negocio.service;

import javax.inject.Inject;

import br.com.coffeework.exception.NegocioException;
import br.com.coffeework.exception.ValidacaoException;
import br.com.coffeework.modelo.entidade.BitCoin;
import br.com.coffeework.negocio.service.facade.ManterBitcoinServiceFacade;
import br.com.coffeework.persistencia.dao.BitcoinDAO;
import br.com.coffeework.persistencia.dao.TransacaoDAO;
import br.com.coffeework.util.jpa.Transacional;

/**
 * <p>
 * <b>Título:</b> ManterBitcoinService.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar as funções de negócio relativas ao ECDU 03 - Manter Bitcoin.
 * </p>
 *
 * Data de criação: 27/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class ManterBitcoinService extends Service<BitCoin> implements ManterBitcoinServiceFacade {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -2879541538734689834L;

	/** Constante VALIDACA_BITCOIN_TRANSACAO_ATIVA. */
	private static final String VALIDACA_BITCOIN_TRANSACAO_ATIVA = "validacao.remover.bitcoin.com.transacao.ativa";

	/** Atributo dao. */
	@Inject
	private BitcoinDAO dao;

	/** Atributo transacaoDAO. */
	@Inject
	private TransacaoDAO transacaoDAO;

	@Override
	public boolean isBitcoinPossuiTransacao(final Long idBitcoin) {

		return this.getDao().isBitcoinPossuiTransacao(idBitcoin);
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
	public void salvar(final BitCoin entidade) throws NegocioException {

		entidade.setComercializado(false);

		super.salvar(entidade);
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
	public void remover(final BitCoin entidade) throws NegocioException {

		if (this.getTransacaoDAO().isBitcoinComercializado(entidade.getIdentificador())) {

			throw new ValidacaoException(ManterBitcoinService.VALIDACA_BITCOIN_TRANSACAO_ATIVA);
		}

		super.remover(entidade);

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
	protected BitcoinDAO getDao() {

		return this.dao;
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
