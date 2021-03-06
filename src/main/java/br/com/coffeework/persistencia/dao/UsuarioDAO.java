package br.com.coffeework.persistencia.dao;

import java.io.Serializable;

import br.com.coffeework.modelo.entidade.Usuario;

/**
 * <p>
 * <b>Título:</b> UsuarioDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por prover funções do repositório da entidade <code>Usuario</code>.
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
	 * Método responsável por obter um usuário apartir de um e-mail.
	 *
	 * @author marcosbuganeme
	 *
	 * @param email
	 *            - filtro da consulta
	 * 
	 * @return <i>usuário pesquisado</i>.
	 */
	Usuario obterUsuarioPorEmail(final String email);

	/**
	 * Método responsável por obter um usuário apartir de seu CPF.
	 *
	 * @author marcosbuganeme
	 *
	 * @param cpf
	 *            - filtro da consulta.
	 * 
	 * @return <i>usuário pesquisado</i>.
	 */
	Usuario obterUsuarioPorCPF(final String cpf);

	/**
	 * Método responsável por obter a carteira do usuário através de seu identificador.
	 *
	 * @author marcosbuganeme
	 *
	 * @param idUsuario
	 *            - id do usuário.
	 * 
	 * @return <i>True, se o usuário possuir uma carteira</i>.
	 */
	boolean isUsuarioPossuiCarteira(final Serializable idUsuario);
}
