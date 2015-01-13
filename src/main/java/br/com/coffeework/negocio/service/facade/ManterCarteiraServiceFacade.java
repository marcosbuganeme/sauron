package br.com.coffeework.negocio.service.facade;

import java.util.Collection;

import br.com.coffeework.modelo.entidade.Carteira;
import br.com.coffeework.modelo.entidade.Usuario;

/**
 * <p>
 * <b>Título:</b> ManterCarteiraServiceFacade.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por conter as funções de negócio do ECDU05 - Manter Carteira.
 * </p>
 *
 * Data de criação: 27/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public interface ManterCarteiraServiceFacade extends ServiceFacade<Carteira> {

	/**
	 * Método responsável por obter a quantidade de bitcoins por carteira.
	 *
	 * @author marcosbuganeme
	 *
	 * @param idCarteira
	 *            - identificador do bitcoin filtrado.
	 * 
	 * @return <i>quantidade de bitcoins por carteira</i>.
	 */
	Long obterQuantidadeBitcoinPorCarteira(final Long idCarteira);

	/**
	 * Método responsável por obter uma coleção de usuários que não tenham carteira.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de usuários sem carteira</i>.
	 */
	Collection<Usuario> listarUsuariosSemCarteira();

	/**
	 * Método responsável por obter uma coleção com todos os usuários.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção com todos os usuários</i>.
	 */
	public Collection<Usuario> listarTodosUsuarios();

	/**
	 * Método responsável por verificar se o registro já existe.
	 *
	 * @author marcosbuganeme
	 *
	 * @param carteira
	 *            - que será filtrado.
	 * 
	 * @return <i>True, registro existe</i>
	 */
	public boolean isRegistroExiste(final Carteira carteira);
}
