package br.com.coffeework.util.jsf;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * <p>
 * <b>Título:</b> JSFExceptionHandlerFactory.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por prover uma fábrica de manipulação de exceções e devolver uma instância de ExceptionHandler, para realizar o devido tratamento.
 * </p>
 *
 * Data de criação: 24/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class JSFExceptionHandlerFactory extends ExceptionHandlerFactory {

	/** Atributo wrapped. */
	private final ExceptionHandlerFactory wrapped;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param wrapped
	 */
	public JSFExceptionHandlerFactory( final ExceptionHandlerFactory wrapped ) {

		this.wrapped = wrapped;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see javax.faces.context.ExceptionHandlerFactory#getExceptionHandler()
	 */
	@Override
	public ExceptionHandler getExceptionHandler() {

		return new JSFExceptionHandler(this.wrapped.getExceptionHandler());
	}

}
