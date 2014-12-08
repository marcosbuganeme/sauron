package br.com.coffeework.visao.controller;

import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.coffeework.modelo.entidade.Carteira;
import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.negocio.service.facade.ManterCarteiraServiceFacade;
import br.com.coffeework.visao.formulario.ManterCarteiraFormulario;

/**
 * <p>
 * <b>Título:</b> ManterCarteiraController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pelo controle de regras de negócio da tela do ECDU05 - Manter Carteira.
 * </p>
 *
 * Data de criação: 27/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Named
@ViewScoped
public class ManterCarteiraController extends ManutencaoController<Carteira> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -1309210038925155558L;

	/** Atributo formulario. */
	@Inject
	private ManterCarteiraFormulario formulario;

	/** Atributo service. */
	@Inject
	private ManterCarteiraServiceFacade service;

	/**
	 * Método responsável por obter uma colecação de todos os usuários registrados.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de usuários</i>.
	 */
	public Collection<Usuario> preencheComboBoxUsuario() {

		return this.getFormulario().getColecaoUsuariosComboBox();
	}

	/**
	 * Método responsável por listar todos os usuários.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção com todos os usuários</i>.
	 */
	public Collection<Usuario> preencheComboBoxUsuarioEditar() {

		return this.getFormulario().getColecaousuariosComboBoxEditar();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.controller.Controller#iniciarDados()
	 */
	@Override
	public void iniciarDados() {

		this.getFormulario().setColecaoUsuariosComboBox(this.getService().listarUsuariosSemCarteira());

		this.getFormulario().setColecaousuariosComboBoxEditar(this.getService().listarTodosUsuarios());
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.controller.Controller#limparDados()
	 */
	@Override
	public void limparDados() {

		this.getFormulario().setEntidade(new Carteira());
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.controller.Controller#abreIniciar()
	 */
	@Override
	public String abreIniciar() {

		return "/restrito/carteira/inicial";
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.controller.ManutencaoController#abreIncluir()
	 */
	@Override
	public String abreIncluir() {

		return "/restrito/carteira/incluir";
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.controller.ConsultaController#abreDetalhar()
	 */
	@Override
	public String abreDetalhar() {

		return "/restrito/carteira/detalhar";
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.controller.ConsultaController#getFormulario()
	 */
	@Override
	public ManterCarteiraFormulario getFormulario() {

		return this.formulario;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.controller.ConsultaController#getService()
	 */
	@Override
	public ManterCarteiraServiceFacade getService() {

		return this.service;
	}

}
