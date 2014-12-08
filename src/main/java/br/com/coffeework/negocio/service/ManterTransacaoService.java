package br.com.coffeework.negocio.service;

import java.util.Collection;
import java.util.HashSet;

import javax.inject.Inject;

import br.com.coffeework.modelo.entidade.BitCoin;
import br.com.coffeework.modelo.entidade.Carteira;
import br.com.coffeework.modelo.entidade.Transacao;
import br.com.coffeework.negocio.service.facade.ManterTransacaoServiceFacade;
import br.com.coffeework.persistencia.dao.BitcoinDAO;
import br.com.coffeework.persistencia.dao.CarteiraDAO;
import br.com.coffeework.persistencia.dao.TransacaoDAO;

/**
 * <p>
 * <b>Título:</b> ManterTransacaoService.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar as funções de negócio relativas ao ECDU 07 - Manter Transação.
 * </p>
 *
 * Data de criação: 29/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class ManterTransacaoService extends Service<Transacao> implements ManterTransacaoServiceFacade {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 3547619615135839159L;

	/** Atributo dao. */
	@Inject
	private TransacaoDAO dao;

	/** Atributo carteiraDAO. */
	@Inject
	private CarteiraDAO carteiraDAO;

	/** Atributo bitcoinDAO. */
	@Inject
	private BitcoinDAO bitcoinDAO;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ManterTransacaoServiceFacade#obterTodasCarteiras()
	 */
	@Override
	public Collection<Carteira> obterTodasCarteiras() {

		return this.getCarteiraDAO().listar();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ManterTransacaoServiceFacade#listarBitcoinNaoComercializado()
	 */
	@Override
	public Collection<BitCoin> listarBitcoinNaoComercializado() {

		final Collection<BitCoin> colecaoBitcoin = this.getBitcoinDAO().listar();

		final Collection<BitCoin> colecaoBitcoinNaoComercializados = new HashSet<BitCoin>(0);

		for (final BitCoin bitCoin : colecaoBitcoin) {

			if (bitCoin.getTransacao() == null) {

				colecaoBitcoinNaoComercializados.add(bitCoin);
			}
		}

		return colecaoBitcoinNaoComercializados;
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
	protected TransacaoDAO getDao() {

		return this.dao;
	}

	/**
	 * Retorna o valor do atributo <code>carteiraDAO</code>
	 *
	 * @return <code>CarteiraDAO</code>
	 */
	protected CarteiraDAO getCarteiraDAO() {

		return this.carteiraDAO;
	}

	/**
	 * Retorna o valor do atributo <code>bitcoinDAO</code>
	 *
	 * @return <code>BitcoinDAO</code>
	 */
	protected BitcoinDAO getBitcoinDAO() {

		return this.bitcoinDAO;
	}

}
