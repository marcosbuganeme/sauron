package br.com.coffeework.visao.controller;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.coffeework.modelo.entidade.Carteira;
import br.com.coffeework.modelo.entidade.Transacao;
import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.negocio.service.facade.ManterCarteiraServiceFacade;
import br.com.coffeework.negocio.service.facade.ManterTransacaoServiceFacade;
import br.com.coffeework.springsecurity.UsuarioSistema;
import br.com.coffeework.visao.formulario.ManterCarteiraFormulario;

/**
 * <p>
 * <b>Título:</b> VisualizarCarteira.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Controlador responsável por apresentar as informações da carteira do usuário.
 * </p>
 *
 * Data de criação: 08/01/2015
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Named
@ViewScoped
public class VisualizarCarteira extends ManutencaoController<Carteira> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 802659899231943566L;

	/** Atributo service. */
	@Inject
	private ManterCarteiraServiceFacade service;

	/** Atributo transacaoService. */
	@Inject
	private ManterTransacaoServiceFacade transacaoService;

	/** Atributo formulario. */
	@Inject
	private ManterCarteiraFormulario formulario;

	@PostConstruct
	public void iniciarDados() {

		this.obterSaldo();

		this.obterEmailUsuarioLogado();
	}

	/**
	 * Método responsável por obter a carteira do usuário corrente através do usuário logado.
	 *
	 * @author marcosbuganeme
	 *
	 */
	private void obterSaldo() {

		final Carteira carteiraObtida = this.obterCarteiraUsuarioLogado();

		final Double saldo = carteiraObtida.getSaldo();

		this.getFormulario().setSaldo(saldo);
	}

	private void obterEmailUsuarioLogado() {

		final Usuario usuarioLogado = this.obterUsuarioLogado().getUsuario();

		final String email = usuarioLogado.getEmail();

		this.getFormulario().setEmail(email);
	}

	public Collection<Transacao> obterTransacoesUsuarioLogado() {

		final Carteira carteiraObtida = this.obterCarteiraUsuarioLogado();

		return carteiraObtida.getColecaoTransacoes();
	}

	private Carteira obterCarteiraUsuarioLogado() {

		final Usuario usuarioLogado = this.obterUsuarioLogado().getUsuario();

		return this.getTransacaoService().obterCarteiraPorUsuario((Long) usuarioLogado.getIdentificador());
	}

	private UsuarioSistema obterUsuarioLogado() {

		final UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken) FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();

		return (UsuarioSistema) user.getPrincipal();
	}

	@Override
	public void limparDados() {

	}

	@Override
	public String abreIniciar() {

		return null;
	}

	@Override
	public String abreIncluir() {

		return null;
	}

	@Override
	public String abreDetalhar() {

		return "/restrito/carteira/visualizar";
	}

	@Override
	public ManterCarteiraFormulario getFormulario() {

		return this.formulario;
	}

	@Override
	protected ManterCarteiraServiceFacade getService() {

		return this.service;
	}

	protected ManterTransacaoServiceFacade getTransacaoService() {

		return this.transacaoService;
	}
}
