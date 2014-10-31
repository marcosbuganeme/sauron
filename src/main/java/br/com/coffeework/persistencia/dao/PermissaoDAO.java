package br.com.coffeework.persistencia.dao;

import java.util.Collection;

import br.com.coffeework.modelo.entidade.Permissao;

/**
 * <p>
 * <b>Título:</b> PermissaoDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por prover funções do repositório da entidade <code>Permissao</code>.
 * </p>
 *
 * Data de criação: 01/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public interface PermissaoDAO extends DAO<Permissao> {

	/**
	 * Método responsável por obter as permissões através do usuário.
	 *
	 * @author marcosbuganeme
	 *
	 * @param idUsuario
	 *            - identificador do usuário que será filtrado.
	 * 
	 * @return <i>coleção de usuários pelas permissões</i>
	 */
	Collection<Permissao> obterPermissaoUsuario(final Long idUsuario);
}
