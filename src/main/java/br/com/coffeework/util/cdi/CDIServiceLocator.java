package br.com.coffeework.util.cdi;

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * <p>
 * <b>Título:</b> CDIServiceLocator.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por recuperar um objeto não CDI e o transformar em um Bean gerenciado CDI.
 * </p>
 *
 * Data de criação: 28/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class CDIServiceLocator {

	private static BeanManager getBeanManager() {

		try {

			final InitialContext initialContext = new InitialContext();

			return (BeanManager) initialContext.lookup("java:comp/env/BeanManager");

		} catch (final NamingException e) {

			throw new RuntimeException("Não pôde encontrar BeanManager no JNDI.");
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(final Class<T> clazz) {

		final BeanManager bm = CDIServiceLocator.getBeanManager();

		final Set<Bean<?>> beans = bm.getBeans(clazz);

		if (beans == null || beans.isEmpty()) {

			return null;
		}

		final Bean<T> bean = (Bean<T>) beans.iterator().next();

		final CreationalContext<T> ctx = bm.createCreationalContext(bean);

		final T o = (T) bm.getReference(bean, clazz, ctx);

		return o;
	}

}
