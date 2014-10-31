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
	 * Método responsável por obter todas as carteiras cadastradas do sistema.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de carteiras</i>.
	 */
	Collection<Carteira> obterTodasCarteiras();

	/**
	 * Método responsável por obter todos os bitcoins do sistema.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de bitcoins</i>.
	 */
	Collection<BitCoin> obterTodosBitcoins();
}
