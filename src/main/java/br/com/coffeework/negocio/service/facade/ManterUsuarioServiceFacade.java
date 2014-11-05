package br.com.coffeework.negocio.service.facade;

import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.springsecurity.UsuarioSistema;

/**
 * <p>
 * <b>Título:</b> UsuarioServiceFacade.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por conter as funções de negócio do ECDU02 - Manter Usuário.
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
	 * Método responsável por verificar se um usuário já existe, apartir de seu e-mail.
	 *
	 * @author marcosbuganeme
	 *
	 * @param usuario
	 *            - objeto que será filtrado.
	 * 
	 * @return <i>True, existe um usuário com esse email pesquisado</i>.
	 */
	boolean isUsuarioJaExiste(final Usuario usuario);

	/**
	 * Método responsável por verificar se um usuário já existe, apartir de seu e-mail.
	 *
	 * @author marcosbuganeme
	 *
	 * @param cpf
	 *            - objeto que será filtrado.
	 * 
	 * @return <i>True, existe um usuário com esse CPF pesquisado</i>.
	 */
	boolean isCPFJaExiste(final Usuario usuario);

	/**
	 * Método responsável por verificar se o usuário corrente (usuário logado) possui alguma permissão vinculada.
	 *
	 * @author marcosbuganeme
	 *
	 * @param usuario
	 *            - objeto que será filtrado.
	 * 
	 * @return <i>True, usuário possui permissão</i>.
	 */
	boolean isUsuarioComPermissao(final Usuario usuario);

	/**
	 * Método responsável por verificar se o usuário que será removido é o usuário logado.
	 *
	 * @author marcosbuganeme
	 *
	 * @param usuarioLogado
	 *            - usuário logado atual.
	 * 
	 * @param usuarioRemover
	 *            - usuário que será removido.
	 * 
	 * @return <i>True, se o usuário selecionado for o usuário logado</i>.
	 */
	boolean isUsuarioLogadoIgualUsuarioRemovido(final UsuarioSistema usuarioLogado, final Usuario usuarioRemover);
}
