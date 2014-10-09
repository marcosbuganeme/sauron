package br.com.coffeework.persistencia.dao;

import java.io.Serializable;
import java.util.Collection;

import br.com.coffeework.exception.ValidacaoException;
import br.com.coffeework.modelo.entidade.Entidade;

/**
 * <p>
 * <b>Título:</b> DAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface pai de todos os DAO's.
 * </p>
 *
 * Data de criação: 21/09/2014
 *
 * @author marcosbuganeme
 * 
 * @param <E>
 *            - Entidade que será manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
public interface DAO<E extends Entidade> extends Serializable {

	/**
	 * Método responsável por obter uma <code>Entidade</code> pelo seu identificador.
	 *
	 * @author marcosbuganeme
	 *
	 * @param identificador
	 *            - código da entidade.
	 * 
	 * @return <code>entidade obtida</code>.
	 * 
	 * @throws ValidacaoException
	 */
	E obterPorId(final Serializable identificador) throws ValidacaoException;

	/**
	 * Método responsável por persistir o objeto parametrizado na base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será persistido.
	 * 
	 * @throws ValidacaoException
	 */
	void salvar(final E entidade) throws ValidacaoException;

	/**
	 * Método responsável por mesclar um objeto (Salvar e/ou alterar). <br>
	 * Merge: Verifica se o objeto existe na base de dados, caso exista, ele altera, caso não exista, ele salva.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será persistido/alterado.
	 * 
	 * @throws ValidacaoException
	 */
	void mesclar(final E entidade) throws ValidacaoException;

	/**
	 * Método responsável por remover um objeto da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será persistido/alterado.
	 * 
	 * @throws ValidacaoException
	 */
	void remover(final E entidade);

	/**
	 * Método responsável por obter registros da base de dados de acordo com o filtro parametrizado.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - filtro da consulta.
	 * 
	 * @return <i>o resultado da consulta</i>.
	 */
	Collection<E> consultar(final E entidade);

	/**
	 * Método responsável por obter todos os registros do tipo do retorno da coleção.
	 *
	 * @author marcosbuganeme
	 *
	 * @return </code>todos os registros da entidade</code>.
	 */
	Collection<E> listar();

	/**
	 * Método responsável por sincronizar a entidade com a base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será sincronizado.
	 */
	void atualizar(final E entidade);

}
