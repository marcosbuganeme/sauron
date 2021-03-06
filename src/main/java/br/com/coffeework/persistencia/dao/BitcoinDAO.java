package br.com.coffeework.persistencia.dao;

import br.com.coffeework.modelo.entidade.BitCoin;

/**
 * <p>
 * <b>Título:</b> BitcoinDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por prover funções do repositório da entidade <code>Bitcoin</code>.
 * </p>
 *
 * Data de criação: 27/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public interface BitcoinDAO extends DAO<BitCoin> {

	/**
	 * Método responsável por verificar se um bitcoin possui transacao.
	 *
	 * @author marcosbuganeme
	 *
	 * @param idBitcoin - filtro da consulta.
	 * 
	 * @return <i>True, se o bitcoin participa de uma transação</i>.
	 */
	boolean isBitcoinPossuiTransacao(final Long idBitcoin);
}
