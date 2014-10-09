package br.com.coffeework.negocio.service.facade;

import java.util.Collection;

import br.com.coffeework.modelo.entidade.Permissao;
import br.com.coffeework.modelo.entidade.Usuario;

/**
 * <p>
 * <b>Título:</b> ManterPermissaoServiceFacade.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> interface responsável por conter as regras de negócio que serão vinculadas a entidade <code>Permissao</code>.
 * </p>
 *
 * Data de criação: 01/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public interface ManterPermissaoServiceFacade extends ServiceFacade<Permissao> {

	/**
	 * Método responsável por obter todos os usuários cadastros na base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de usuários</i>
	 */
	Collection<Usuario> consultarTodosUsuarios();

	/**
	 * Método responsável por obter um usuário pelo seu email.
	 *
	 * @author marcosbuganeme
	 *
	 * @param email
	 *            - filtro da consulta.
	 * 
	 * @return <code>coleção usuário pesquisado</code>.
	 */
	Collection<Usuario> obterUsuarioPorEmail(final String email);
}
