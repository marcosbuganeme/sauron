package br.com.coffeework.util.jpa;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * <p>
 * <b>Título:</b> TransactionInterceptor.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pela interceptação de transações.
 * </p>
 *
 * Data de criação: 21/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION + 1)
public class TransactionInterceptor implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -1495886130448620233L;

	@Inject
	/** Atributo manager. */
	private EntityManager manager;

	@AroundInvoke
	public Object invoke(final InvocationContext context) throws Exception {

		final EntityTransaction entidadeTransacional = this.manager.getTransaction();

		boolean criador = false;

		try {

			if (!entidadeTransacional.isActive()) {

				entidadeTransacional.begin();
				entidadeTransacional.rollback();

				entidadeTransacional.begin();

				criador = true;
			}

			return context.proceed();

		} catch (final Exception excecao) {

			if (entidadeTransacional != null && criador) {

				entidadeTransacional.rollback();
			}

			throw excecao;

		} finally {

			if (entidadeTransacional != null && entidadeTransacional.isActive() && criador) {

				entidadeTransacional.commit();
			}
		}
	}

}
