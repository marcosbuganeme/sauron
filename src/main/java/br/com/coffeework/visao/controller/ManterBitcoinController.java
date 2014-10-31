package br.com.coffeework.visao.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.coffeework.modelo.entidade.BitCoin;
import br.com.coffeework.negocio.service.facade.ManterBitcoinServiceFacade;
import br.com.coffeework.visao.formulario.ManterBitcoinFormulario;

/**
 * <p>
 * <b>Título:</b> ManterBitcoinController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pelo controle de regras de negócio da tela do ECDU06 - Manter Bitcoin.
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
public class ManterBitcoinController extends ManutencaoController<BitCoin> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -4640622532737081021L;

	/** Atributo formulario. */
	@Inject
	private ManterBitcoinFormulario formulario;

	/** Atributo service. */
	@Inject
	private ManterBitcoinServiceFacade service;

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

		this.getFormulario().setEntidade(new BitCoin());
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

		return "/admin/bitcoin/inicial";
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

		return "/restrito/bitcoin/incluir";
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

		this.carregarDados();

		return "/admin/bitcoin/detalhar";
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
	public ManterBitcoinFormulario getFormulario() {

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
	public ManterBitcoinServiceFacade getService() {

		return this.service;
	}

}
