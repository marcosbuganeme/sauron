package br.com.coffeework.persistencia.dao;

import java.io.Serializable;

import br.com.coffeework.modelo.entidade.Transacao;

/**
 * <p>
 * <b>Título:</b> TransacaoDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por prover funções do repositório da entidade <code>Transacao</code>.
 * </p>
 *
 * Data de criação: 29/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public interface TransacaoDAO extends DAO<Transacao> {

	/**
	 * Método responsável por obter carteira e bitcoin por transação.
	 *
	 * @author marcosbuganeme
	 *
	 * @param idBitcoin
	 *            - filtro de bitcoin.
	 * 
	 * @return <i>transação</i>
	 */
	Transacao listarBitcoinNaoComercializados(final Serializable idBitcoin);
}
