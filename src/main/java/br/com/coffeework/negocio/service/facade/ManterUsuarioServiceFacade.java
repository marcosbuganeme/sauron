package br.com.coffeework.negocio.service.facade;

import java.util.Collection;

import br.com.coffeework.modelo.entidade.Usuario;

/**
 * <p>
 * <b>Título:</b> UsuarioServiceFacade.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por conter a assinatura dos métodos que fazem parte da regra de negócio.
 * </p>
 *
 * Data de criação: 25/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public interface ManterUsuarioServiceFacade extends ServiceFacade<Usuario> {

	/**
	 * Método responsável por obter um usuário pelo seu email.
	 *
	 * @author marcosbuganeme
	 *
	 * @param email
	 *            - filtro da consulta.
	 * 
	 * @return <code>coleção de usuários pesquisado</code>.
	 */
	Collection<Usuario> autoCompleteUsuarioPorEmail(final String email);
}
