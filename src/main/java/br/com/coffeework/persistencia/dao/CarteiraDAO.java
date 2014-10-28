package br.com.coffeework.persistencia.dao;

import br.com.coffeework.modelo.entidade.Carteira;

/**
 * <p>
 * <b>Título:</b> CarteiraDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por prover funções do repositório da entidade <code>Carteira</code>.
 * </p>
 *
 * Data de criação: 27/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public interface CarteiraDAO extends DAO<Carteira> {

	/**
	 * Método responsável por obter uma carteira por um determinado usuário.
	 *
	 * @author marcosbuganeme
	 *
	 * @param idUsuario
	 *            - identificador do registro que será filtrado.
	 * 
	 * @return <i>registro da carteira</i>
	 */
	public Carteira obterCarteiraPorUsuario(final Long idUsuario);
}
