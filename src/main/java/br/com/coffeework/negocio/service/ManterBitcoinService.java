package br.com.coffeework.negocio.service;

import javax.inject.Inject;

import br.com.coffeework.modelo.entidade.BitCoin;
import br.com.coffeework.negocio.service.facade.ManterBitcoinServiceFacade;
import br.com.coffeework.persistencia.dao.BitcoinDAO;

/**
 * <p>
 * <b>Título:</b> ManterBitcoinService.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar as funções de negócio relativas ao ECDU 03 - Gerenciar Bitcoin.
 * </p>
 *
 * Data de criação: 27/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class ManterBitcoinService extends Service<BitCoin> implements ManterBitcoinServiceFacade {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -2879541538734689834L;

	/** Atributo dao. */
	@Inject
	private BitcoinDAO dao;

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

}
