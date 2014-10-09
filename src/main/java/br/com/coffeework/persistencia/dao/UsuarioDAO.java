package br.com.coffeework.persistencia.dao;

import java.util.Collection;

import br.com.coffeework.modelo.entidade.Usuario;

/**
 * <p>
 * <b>Título:</b> UsuarioDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por prover funções de CRUD para a entidade <code>Usuario</code>
 * </p>
 *
 * Data de criação: 21/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public interface UsuarioDAO extends DAO<Usuario> {

	/**
	 * Método responsável por obter um usuário pelo seu email.
	 *
	 * @author marcosbuganeme
	 *
	 * @param email
	 *            - filtro da consulta.
	 * 
	 * @return <code>coleção de usuários por email pesquisado</code>.
	 */
	Collection<Usuario> autoCompleteUsuarioPorEmail(final String email);

	/**
	 * Método responsável por obter um usuário apartir de um e-mail.
	 *
	 * @author marcosbuganeme
	 *
	 * @param email
	 *            - filtro da consulta
	 * 
	 * @return <i>o email do usuário pesquisado</i>.
	 */
	Usuario obterUsuarioPorEmail(final String email);

}
