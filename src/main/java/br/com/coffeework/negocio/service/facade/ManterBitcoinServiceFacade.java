package br.com.coffeework.negocio.service.facade;

import br.com.coffeework.modelo.entidade.BitCoin;

/**
 * <p>
 * <b>Título:</b> ManterBitcoinServiceFacade.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por conter as funções de negócio do ECDU04 - Manter Bitcoin.
 * </p>
 *
 * Data de criação: 27/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public interface ManterBitcoinServiceFacade extends ServiceFacade<BitCoin> {

	/**
	 * Método responsável por verificar se um bitcoin possui transacao.
	 *
	 * @author marcosbuganeme
	 *
	 * @param idBitcoin
	 *            - filtro da consulta.
	 * 
	 * @return <i>True, se o bitcoin participa de uma transação</i>.
	 */
	boolean isBitcoinPossuiTransacao(final Long idBitcoin);
}
