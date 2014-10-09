package br.com.coffeework.visao.controller;

import java.io.Serializable;
import java.util.Collection;

import br.com.coffeework.modelo.entidade.Entidade;
import br.com.coffeework.negocio.service.facade.ServiceFacade;
import br.com.coffeework.visao.formulario.Formulario;

/**
 * <p>
 * <b>Eítulo:</b> ConsultaController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pelo fluxo de navegação do sistema e por prover funções para consulta de dados.
 * </p>
 *
 * Data de criação: 09/10/2014
 *
 * @author marcosbuganeme
 * 
 * @param <E>
 *            - entidade que será manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
public abstract class ConsultaController<E extends Entidade> extends Controller {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 6196651668127017568L;

	/** Atributo formulario. */
	private Formulario<E> formulario;

	/** Atributo service. */
	private ServiceFacade<E> service;

	/**
	 * Método responsável por navegar para a página de detalhamento de um ECDU.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>página de detalhamento</i>.
	 */
	protected String abreDetalhar() {

		this.carregarDados();

		return this.getClass().getSimpleName() + "/detalhar";
	}

	/**
	 * Método responsável por realizar a consulta de acordo com a entidade passada como filtro.
	 * 
	 * @param entidade
	 *            - objeto utilizada como filtro.
	 */
	public void consultar(final E entidade) {

		this.getFormulario().setConsulta(entidade);

		this.consultar();
	}

	/**
	 * Método responsável por realizar a consulta de acordo com a entidade passada como filtro.
	 * 
	 * @author marcosbuganeme
	 */
	public void consultar() {

		final Collection<E> entidades = this.getService().consultar(this.getFormulario().getConsulta());

		this.getFormulario().setColecaoEntidades(entidades);
	}

	/**
	 * Método responsável por obter todas os registros de uma determinada Entidade.
	 *
	 * @author marcosbuganeme
	 */
	public void listar() {

		final Collection<E> entidades = this.getService().listar();

		this.getFormulario().setColecaoEntidades(entidades);
	}

	/**
	 * Método responsável por carregar os dados de uma entidade.
	 *
	 * @author marcosbuganeme
	 *
	 */
	protected void carregarDados() {

		final E entidade = this.getFormulario().getEntidade();

		final Collection<E> entidades = this.getFormulario().getColecaoEntidades();

		Serializable identificador = null;

		if (( entidade == null || entidade.isNovoRegistro() ) && ( entidades != null && !entidades.isEmpty() )) {

			identificador = this.getIdentificador(entidades.iterator().next());

		} else {

			identificador = this.getIdentificador(this.getFormulario().getEntidade());
		}

		this.getFormulario().setEntidade(this.getService().obterPorId(identificador));
	}

	/**
	 * Método responsável por obter o identificador da entidade parametrizada.
	 * 
	 * @author marcosbuganeme
	 * 
	 * @param entidade
	 *            - objeto que terá seu identificador obtido.
	 * 
	 * @return <i>identificador da entidade</i>.
	 */
	protected Serializable getIdentificador(final E entidade) {

		return entidade.getIdentificador();
	}

	/**
	 * Retorna o valor do atributo <code>formulario</code>
	 *
	 * @return <code>Formulario<E></code>
	 */
	protected Formulario<E> getFormulario() {

		return this.formulario;
	}

	/**
	 * Retorna o valor do atributo <code>service</code>
	 *
	 * @return <code>ServiceFacade</code>
	 */
	protected ServiceFacade<E> getService() {

		return this.service;
	}
}
