package br.com.coffeework.util.jsf;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.coffeework.exception.NegocioException;

/**
 * <p>
 * <b>Título:</b> JSFExceptionHandler.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por realizar o tratamento de exceções com o redirecionamento para o devido local de acordo com a exceção propagada.
 * </p>
 *
 * Data de criação: 24/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class JSFExceptionHandler extends ExceptionHandlerWrapper {

	/** Atributo log. */
	private final Log log = LogFactory.getLog(JSFExceptionHandler.class);

	/** Atributo wrapped. */
	private final ExceptionHandler wrapped;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param wrapped
	 */
	public JSFExceptionHandler( final ExceptionHandler wrapped ) {

		this.wrapped = wrapped;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see javax.faces.context.ExceptionHandlerWrapper#handle()
	 */
	@Override
	public void handle() throws FacesException {

		final Iterator<ExceptionQueuedEvent> pilhaEventos = this.getUnhandledExceptionQueuedEvents().iterator();

		while (pilhaEventos.hasNext()) {

			final ExceptionQueuedEvent filaEvento = pilhaEventos.next();

			final ExceptionQueuedEventContext contextoFilaEvento = (ExceptionQueuedEventContext) filaEvento.getSource();

			final Throwable excecao = contextoFilaEvento.getException();

			final NegocioException negocioException = this.obtemTipoDaExcecao(excecao);

			boolean handled = false;

			try {

				if (excecao instanceof ViewExpiredException) {

					handled = true;

					this.redirecionarUrl("/");

				} else if (negocioException != null) {

					handled = true;

					UtilitarioJSF.addMensagemError(negocioException.getMessage());

				} else {

					handled = true;

					System.out.println("pqp deu erro caralho ... redirect 404 na face");
					
					this.redirecionarUrl("/paginas/error/404.xhtml");
				}

			} finally {

				if (handled) {

					pilhaEventos.remove();
				}

			}

		}

		this.getWrapped().handle();
	}

	/**
	 * Método responsável por redirecionar para uma página qualquer.
	 *
	 * @author marcosbuganeme
	 *
	 * @param pagina
	 *            - nome da página para redirecionamento
	 */
	private void redirecionarUrl(final String pagina) {

		try {

			final FacesContext contexto = FacesContext.getCurrentInstance();

			final ExternalContext contextoExterno = contexto.getExternalContext();

			final String caminhoContexto = contextoExterno.getRequestContextPath();

			contextoExterno.redirect(caminhoContexto + pagina);

			contexto.responseComplete();

		} catch (final IOException exception) {

			this.log.error("ERROR no redirecionamento de página :: " + exception.getMessage(), exception);

			throw new FacesException(exception);
		}
	}

	/**
	 * Método responsável por verificar se o tipo da exceção é <code>NegocioException</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param excecao
	 *            - tipo da exceção.
	 * 
	 * @return <i>negocio exception, ou nulo</i>.
	 */
	private NegocioException obtemTipoDaExcecao(final Throwable excecao) {

		if (excecao instanceof NegocioException) {

			return (NegocioException) excecao;

		} else if (excecao.getCause() != null) {

			return this.obtemTipoDaExcecao(excecao.getCause());
		}

		return null;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see javax.faces.context.ExceptionHandlerWrapper#getWrapped()
	 */
	@Override
	public ExceptionHandler getWrapped() {

		return this.wrapped;
	}

	/**
	 * Retorna o valor do atributo <code>log</code>
	 *
	 * @return <code>Log</code>
	 */
	public Log getLog() {

		return this.log;
	}

}
