package br.com.coffeework.negocio.service;

import java.io.Serializable;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.coffeework.exception.NegocioException;
import br.com.coffeework.exception.RegistroNaoExisteException;
import br.com.coffeework.modelo.entidade.Entidade;
import br.com.coffeework.negocio.service.facade.ServiceFacade;
import br.com.coffeework.persistencia.dao.DAO;
import br.com.coffeework.util.jpa.Transacional;

/**
 * <p>
 * <b>Título:</b> Service.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstrata responsável por implementar a interface <code>ServiceFacade</code>. <br>
 * Provendo funções CRUD básicas.
 * </p>
 *
 * Data de criação: 21/09/2014
 *
 * @author marcosbuganeme
 * 
 * @param <E>
 *            - Entidade que será manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
public abstract class Service<E extends Entidade> implements ServiceFacade<E> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 133306835756114188L;

	/** Atributo LOG. */
	private static final Log LOG = LogFactory.getLog(Service.class);

	/** Constante MENSAGEM_REGISTRO_NAO_EXISTE. */
	private static final String MENSAGEM_REGISTRO_NAO_EXISTE = "registro.nao.existe";

	/**
	 * Método responsável por obter o dao da entidade.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <code>dao</code>.
	 */
	protected abstract DAO<E> getDao();

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ServiceFacade#obterPorId(java.io.Serializable)
	 */
	@Override
	public E obterPorId(final Serializable identificador) throws NegocioException {

		final E entidadeObtida = this.getDao().obterPorId(identificador);

		if (entidadeObtida == null) {

			Service.LOG.error("Registro não encontrado");

			throw new RegistroNaoExisteException(Service.MENSAGEM_REGISTRO_NAO_EXISTE);
		}

		return entidadeObtida;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ServiceFacade#salvar(br.com.coffeework.modelo.entidade.Entidade)
	 */
	@Transacional
	@Override
	public void salvar(final E entidade) throws NegocioException {

		if (entidade != null) {

			this.getDao().salvar(entidade);
		}
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ServiceFacade#mesclar(br.com.coffeework.modelo.entidade.Entidade)
	 */
	@Transacional
	@Override
	public void mesclar(final E entidade) throws NegocioException {

		if (entidade != null) {

			this.getDao().mesclar(entidade);
		}
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ServiceFacade#remover(br.com.coffeework.modelo.entidade.Entidade)
	 */
	@Transacional
	@Override
	public void remover(final E entidade) throws NegocioException {

		final E entidadeobtida = this.obterPorId(entidade.getIdentificador());

		this.getDao().remover(entidadeobtida);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ServiceFacade#consultar(br.com.coffeework.modelo.entidade.Entidade)
	 */
	@Override
	public Collection<E> consultar(final E entidade) {

		return this.getDao().consultar(entidade);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ServiceFacade#listar()
	 */
	@Override
	public Collection<E> listar() {

		return this.getDao().listar();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.service.facade.ServiceFacade#atualizar(br.com.coffeework.modelo.entidade.Entidade)
	 */
	@Override
	public void atualizar(final E entidade) {

		this.getDao().atualizar(entidade);
	}

}
