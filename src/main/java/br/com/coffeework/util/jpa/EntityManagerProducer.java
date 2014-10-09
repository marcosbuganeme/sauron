package br.com.coffeework.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * <p>
 * <b>Título:</b> EntityManagerProducer.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por produzir uma fábrica de <code>EntityManager</code>'s.
 * </p>
 *
 * Data de criação: 21/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@ApplicationScoped
public class EntityManagerProducer {

	/** Constante NOME_UNIDADE_PERSISTENCIA. */
	private static final String NOME_UNIDADE_PERSISTENCIA = "sauronPU";

	/** Atributo factory. */
	private EntityManagerFactory factory;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public EntityManagerProducer() {

		this.factory = Persistence.createEntityManagerFactory(EntityManagerProducer.NOME_UNIDADE_PERSISTENCIA);
	}

	/**
	 * Método responsável por criar uma nova instância de <code>EntityManager</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>instância de <code>EntityManager</code></i>
	 */
	@Produces
	@RequestScoped
	public EntityManager create() {

		return this.factory.createEntityManager();
	}

	/**
	 * Método responsável por destruir uma instância de <code>EntityManager</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param manager
	 */
	public void close(@Disposes final EntityManager manager) {

		manager.close();
	}
}
