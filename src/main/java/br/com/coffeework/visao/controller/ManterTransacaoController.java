package br.com.coffeework.visao.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.coffeework.exception.NegocioException;
import br.com.coffeework.modelo.entidade.BitCoin;
import br.com.coffeework.modelo.entidade.Carteira;
import br.com.coffeework.modelo.entidade.Transacao;
import br.com.coffeework.modelo.enuns.EnumTipoOperacao;
import br.com.coffeework.negocio.service.facade.ManterBitcoinServiceFacade;
import br.com.coffeework.negocio.service.facade.ManterCarteiraServiceFacade;
import br.com.coffeework.negocio.service.facade.ManterTransacaoServiceFacade;
import br.com.coffeework.springsecurity.UsuarioSistema;
import br.com.coffeework.util.jsf.UtilitarioJSF;
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

	/** Constante MENSAGEM_SALVAR_SUCESSO. */
	private static final String MENSAGEM_SALVAR_SUCESSO = "registro.salvo.sucesso";

	/** Constante MENSAGEM_SALDO_INSUFICIENTE. */
	private static final String MENSAGEM_SALDO_INSUFICIENTE = "validacao.transacao.saldo.insuficiente";

	/** Atributo formulario. */
	@Inject
	private ManterTransacaoFormulario formulario;

	/** Atributo service. */
	@Inject
	private ManterTransacaoServiceFacade service;

	/** Atributo carteiraService. */
	@Inject
	private ManterCarteiraServiceFacade carteiraService;

	/** Atributo bitcoinService. */
	@Inject
	private ManterBitcoinServiceFacade bitcoinService;

	/**
	 * Método responsável por obter a carteira do usuário corrente através do usuário logado.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void obterCarteiraPorUsuario() {

		UsuarioSistema usuarioSistema = null;

		final UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken) FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();

		if (user != null) {

			usuarioSistema = (UsuarioSistema) user.getPrincipal();
		}

		final Carteira carteiraPesquisada = this.getService().obterCarteiraPorUsuario((Long) usuarioSistema.getUsuario().getIdentificador());

		final Collection<Carteira> colecaoCarteiraUsuarioLogado = new ArrayList<Carteira>(0);

		colecaoCarteiraUsuarioLogado.add(carteiraPesquisada);

		this.getFormulario().setComboBoxCarteiraUsuarioLogado(colecaoCarteiraUsuarioLogado);
	}

	/**
	 * Método responsável por preencher o combo box das carteiras cadastradas no sistema que estão ativas.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>carteira do usuário logado</i>.
	 */
	public Collection<Carteira> preencheComboBoxCarteiraComUsuarioLogado() {

		return this.getFormulario().getComboBoxCarteiraUsuarioLogado();
	}

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
	 * Método responsável por obter o saldo do bitcoin selecionado.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void obterSaldoBitCoinSelecionado() {

		final Double valorUnitarioBitcoin = this.getFormulario().getEntidade().getBitCoin().getPreco();

		this.getFormulario().setValorUnitarioBitcoinDaTransacao(valorUnitarioBitcoin);

		this.getFormulario().setMostrarValorUnitarioBitcoinDaTransacao(false);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.controller.ManutencaoController#salvar()
	 */
	@Override
	public void salvar() {

		try {

			BitCoin bitcoinManipulado = this.getFormulario().getEntidade().getBitCoin();

			bitcoinManipulado.setComercializado(true);

			this.getBitcoinService().mesclar(bitcoinManipulado);

			final Carteira carteira = this.calcularTransacaoCarteira(this.getFormulario().getEntidade().getTipoOperacao(), this.getFormulario().getEntidade().getCarteira(), bitcoinManipulado);

			this.getCarteiraService().mesclar(carteira);

			this.getFormulario().getEntidade().setBitCoin(bitcoinManipulado);

			this.getFormulario().getEntidade().setCarteira(carteira);

			this.getService().salvar(this.getFormulario().getEntidade());

			final String mensagemSalvar = this.getMessage(ManterTransacaoController.MENSAGEM_SALVAR_SUCESSO);

			UtilitarioJSF.addMensagemInfo(mensagemSalvar);

			this.limparDados();

		} catch (final NegocioException negocioException) {

			UtilitarioJSF.addMensagemError(this.getMessage(negocioException.getMessage()));
		}
	}

	/**
	 * Método responsável por calcular o valor do bitcoin e realizar a verificação se uma carteira possui ou não saldo para realizar a compra.
	 *
	 * @author marcosbuganeme
	 *
	 * @param operacao
	 *            - tipo da operação.
	 * 
	 * @param carteira
	 *            - carteira que será debitado/retirado o saldo.
	 * 
	 * @param bitcoin
	 *            - bitcoin que será transacionado(vendido/comprado).
	 * 
	 * @return <i>carteira do cliente após a transação</i>.
	 */
	private Carteira calcularTransacaoCarteira(final EnumTipoOperacao operacao, final Carteira carteira, final BitCoin bitcoin) {

		Double saldoCarteira = null;

		if (operacao.equals(EnumTipoOperacao.COMPRA)) {

			if (carteira.getSaldo() < bitcoin.getPreco()) {

				throw new NegocioException(ManterTransacaoController.MENSAGEM_SALDO_INSUFICIENTE);
			}

			saldoCarteira = carteira.getSaldo() - bitcoin.getPreco();

		} else if (operacao.equals(EnumTipoOperacao.VENDA)) {

			saldoCarteira = carteira.getSaldo() + bitcoin.getPreco();
		}

		carteira.setSaldo(saldoCarteira);

		return carteira;
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

		this.getFormulario().setColecaoComboBoxBitcoins(this.getService().listarBitcoinNaoComercializado());

		this.getFormulario().setColecaoComboBoxCarteiras(this.getService().obterTodasCarteiras());

		this.getFormulario().setMostrarValorUnitarioBitcoinDaTransacao(true);

		this.obterCarteiraPorUsuario();
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

	/**
	 * Retorna o valor do atributo <code>carteiraService</code>
	 *
	 * @return <code>ManterCarteiraServiceFacade</code>
	 */
	public ManterCarteiraServiceFacade getCarteiraService() {

		return this.carteiraService;
	}

	/**
	 * Retorna o valor do atributo <code>bitcoinService</code>
	 *
	 * @return <code>ManterBitcoinServiceFacade</code>
	 */
	public ManterBitcoinServiceFacade getBitcoinService() {

		return this.bitcoinService;
	}

}
