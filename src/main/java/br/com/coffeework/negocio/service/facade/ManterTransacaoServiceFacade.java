package br.com.coffeework.negocio.service.facade;

import java.util.Collection;

import br.com.coffeework.modelo.entidade.BitCoin;
import br.com.coffeework.modelo.entidade.Carteira;
import br.com.coffeework.modelo.entidade.Transacao;

/**
 * <p>
 * <b>Título:</b> ManterTransacaoServiceFacade.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por conter as funções de negócio do ECDU07 - Manter Transacao.
 * </p>
 *
 * Data de criação: 29/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public interface ManterTransacaoServiceFacade extends ServiceFacade<Transacao> {

	/**
	 * Método responsável por obter uma carteira para um determinado usuário.
	 *
	 * @author marcosbuganeme
	 *
	 * @param idUsuario
	 *            - identificador do registro que será filtrado.
	 * 
	 * @return <i>registro da carteira</i>.
	 */
	Carteira obterCarteiraPorUsuario(final Long idUsuario);

	/**
	 * Método responsável por obter todas as carteiras cadastradas do sistema.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de carteiras</i>.
	 */
	Collection<Carteira> obterTodasCarteiras();

	/**
	 * Método responsável por listar todos os bitcoins não comercializados.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de bitcoins não comercializados</i>.
	 */
	Collection<BitCoin> listarBitcoinNaoComercializado();
}
