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
 * <b>Descrição:</b> Interface responsável por conter as funções de negócio do ECDU03 - Manter Permissão.
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
}
