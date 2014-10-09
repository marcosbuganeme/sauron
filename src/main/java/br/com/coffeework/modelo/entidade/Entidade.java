package br.com.coffeework.modelo.entidade;

import java.io.Serializable;

/**
 * <p>
 * <b>Título:</b> Entidade.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface pai de todas as entidades do projeto.
 * </p>
 *
 * Data de criação: 21/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public interface Entidade extends Serializable {

	/**
	 * Método responsável por obter o identificador da entidade manipulada.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>identificador da <code>Entidade</code></i>.
	 */
	Serializable getIdentificador();

	/**
	 * Método responsável por verificar se um objeto foi ou não persistido na base de dados. <br>
	 * Utilizado para renderizar componentes.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i> True, não possui ID, logo não foi persistido</i>.
	 */
	boolean isNovoRegistro();
}
