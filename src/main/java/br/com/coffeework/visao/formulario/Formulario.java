package br.com.coffeework.visao.formulario;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.coffeework.modelo.entidade.Entidade;

/**
 * <p>
 * <b>Título:</b> Formulario.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por prover atributos em comuns para a manipulação dos demais controladores do sistema.
 * </p>
 *
 * Data de criação: 23/09/2014
 *
 * @author marcosbuganeme
 * 
 * @param <E>
 *            - Entidade que será manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
@SuppressWarnings("unchecked")
public abstract class Formulario<E extends Entidade> implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -442434906524232138L;

	/** Atributo log. */
	private final Log log = LogFactory.getLog(Formulario.class);

	/** Atributo entidade. */
	private E entidade;

	/** Atributo consulta. */
	private E consulta;

	/** Atributo colecaoEntidades. */
	private Collection<E> colecaoEntidades;

	public Formulario( final Class<E> classe ) {

		try {

			this.entidade = classe.newInstance();

			this.consulta = classe.newInstance();

		} catch (InstantiationException | IllegalAccessException exception) {

			this.log.error("ERROR na inicialização das variáveis do formulário. CAUSA :::" + exception.getCause() + " ::::: CLASSE RESPONSÁVEL" + this.getClass().getSimpleName());
		}
	}

	public <F> Formulario() {

		try {

			this.entidade = this.getTipoEntidade().newInstance();

			this.consulta = this.getTipoEntidade().newInstance();

		} catch (InstantiationException | IllegalAccessException exception) {

			this.log.error("ERROR na inicialização das variáveis do formulário. CAUSA :::" + exception.getCause() + " ::::: CLASSE RESPONSÁVEL" + this.getClass().getSimpleName());
		}

	}

	/**
	 * Método responsável por obter o tipo da classe que representa a entidade.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>tipo da classe que representa a entidade</i>
	 */
	private Class<E> getTipoEntidade() {

		final Type[] tipoEntidade = ( (ParameterizedType) this.getClass().getGenericSuperclass() ).getActualTypeArguments();

		return (Class<E>) tipoEntidade[0];
	}

	/**
	 * Retorna o valor do atributo <code>entidade</code>
	 *
	 * @return <code>E</code>
	 */
	public E getEntidade() {

		return this.entidade;
	}

	/**
	 * Define o valor do atributo <code>entidade</code>.
	 *
	 * @param entidade
	 */
	public void setEntidade(final E entidade) {

		this.entidade = entidade;
	}

	/**
	 * Retorna o valor do atributo <code>consulta</code>
	 *
	 * @return <code>E</code>
	 */
	public E getConsulta() {

		return this.consulta;
	}

	/**
	 * Define o valor do atributo <code>consulta</code>.
	 *
	 * @param consulta
	 */
	public void setConsulta(final E consulta) {

		this.consulta = consulta;
	}

	/**
	 * Retorna o valor do atributo <code>colecaoEntidade</code>
	 *
	 * @return <code>Collection<E></code>
	 */
	public Collection<E> getColecaoEntidades() {

		return this.colecaoEntidades;
	}

	/**
	 * Define o valor do atributo <code>colecaoEntidade</code>.
	 *
	 * @param colecaoEntidades
	 */
	public void setColecaoEntidades(final Collection<E> colecaoEntidades) {

		this.colecaoEntidades = colecaoEntidades;
	}

}
