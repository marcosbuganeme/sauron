package br.com.coffeework.visao.controller;

import java.util.Arrays;
import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.coffeework.modelo.entidade.BitCoin;
import br.com.coffeework.modelo.entidade.Carteira;
import br.com.coffeework.modelo.entidade.Transacao;
import br.com.coffeework.modelo.enuns.EnumTipoOperacao;
import br.com.coffeework.negocio.service.facade.ManterTransacaoServiceFacade;
import br.com.coffeework.visao.formulario.ManterTransacaoFormulario;

/**
 * <p>
 * <b>Título:</b> ManterTransacaoController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pelo controle de regras de negócio da tela do ECDU07 - Manter Transação.
 * </p>
 *
 * Data de criação: 29/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Named
@ViewScoped
public class ManterTransacaoController extends ManutencaoController<Transacao> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -3977657424306110950L;

	/** Atributo formulario. */
	@Inject
	private ManterTransacaoFormulario formulario;

	/** Atributo service. */
	@Inject
	private ManterTransacaoServiceFacade service;

	/**
	 * Método responsável por preencher o combo box das carteiras cadastradas no sistema que estão ativas.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de carteiras</i>.
	 */
	public Collection<Carteira> preencheComboBoxCarteira() {

		return this.getFormulario().getColecaoComboBoxCarteiras();
	}

	/**
	 * Método responsável por preencher o combo box dos bitcoins cadastrados no sistema que estão ativos.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de bitcoin</i>.
	 */
	public Collection<BitCoin> preencheComboBoxBitcoin() {

		return this.getFormulario().getColecaoComboBoxBitcoins();
	}

	/**
	 * Método responsável por preencher o combo box dos tipos de operações possíveis de uma transação.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de tipos de operações</i>.
	 */
	public Collection<EnumTipoOperacao> preencheComboBoxTipoOperacao() {

		return Arrays.asList(EnumTipoOperacao.values());
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

		this.getFormulario().setColecaoComboBoxBitcoins(this.getService().obterTodosBitcoins());

		this.getFormulario().setColecaoComboBoxCarteiras(this.getService().obterTodasCarteiras());
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

		this.getFormulario().setEntidade(new Transacao());
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

		return "/admin/transacao/inicial";
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

		return "/restrito/transacao/incluir";
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

		return "/admin/transacao/detalhar";
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
	public ManterTransacaoFormulario getFormulario() {

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
	public ManterTransacaoServiceFacade getService() {

		return this.service;
	}

}
