package br.com.coffeework.visao.controller;

import java.text.SimpleDateFormat;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.negocio.service.facade.ManterUsuarioServiceFacade;
import br.com.coffeework.springsecurity.UsuarioSistema;
import br.com.coffeework.util.jsf.UtilitarioJSF;
import br.com.coffeework.util.pattern.UtilCPF;
import br.com.coffeework.visao.formulario.ManterUsuarioFormulario;

/**
 * <p>
 * <b>Título:</b> ManterUsuarioController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pelo controle de regras de negócio da tela do ECDU02 - Manter Usuário.
 * </p>
 *
 * Data de criação: 21/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Named
@ViewScoped
public class ManterUsuarioController extends ManutencaoController<Usuario> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -4636009997949369987L;

	/** Constante MSG_NAO_PODE_REMOVER_USUARIO_LOGADO. */
	private static final String MSG_NAO_PODE_REMOVER_USUARIO_LOGADO = "validacao.remover.usuario.logado";

	/** Constante MSG_NAO_PODE_REMOVER_COM_CARTEIRA. */
	private static final String MSG_NAO_PODE_REMOVER_COM_CARTEIRA = "validacao.remover.usuario.carteira.vinculada";

	/** Atributo formulario. */
	@Inject
	private ManterUsuarioFormulario formulario;

	/** Atributo service. */
	@Inject
	private ManterUsuarioServiceFacade service;

	/** Atributo usuarioLogadoController. */
	@Inject
	private ManterUsuarioLogadoController usuarioLogadoController;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public ManterUsuarioController() {

	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.controller.ManutencaoController#remover()
	 */
	@Override
	public void remover() {

		final UsuarioSistema usuarioLogado = this.usuarioLogadoController.obterUsuarioLogado();

		final boolean isPossuiCarteira = this.getService().isUsuarioPossuiCarteira(this.getFormulario().getEntidade().getIdentificador());

		if (this.getService().isUsuarioLogadoIgualUsuarioRemovido(usuarioLogado, this.getFormulario().getEntidade())) {

			UtilitarioJSF.addMensagemError(this.getMessage(ManterUsuarioController.MSG_NAO_PODE_REMOVER_USUARIO_LOGADO));

		} else if (isPossuiCarteira) {

			UtilitarioJSF.addMensagemError(this.getMessage(ManterUsuarioController.MSG_NAO_PODE_REMOVER_COM_CARTEIRA));

		} else {

			super.remover();
		}

	}

	/**
	 * Método responsável por formatar a data de cadastro do usuário.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>a data de cadastro do usuário formatada de acordo com o pattern { "dd 'do mês' MMMM 'de' yyyy" }</i>.
	 */
	public String getDataCadastroFormatada() {

		final SimpleDateFormat sdf = new SimpleDateFormat("dd 'do mês' MMMM 'de' yyyy");

		return sdf.format(this.getFormulario().getEntidade().getDataCadastro());
	}

	/**
	 * Método responsável por gerar um cpf com 09 números iniciais aleatórios.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>uma string preenchida com 9 números alfanuméricos</i>.
	 */
	public void gerarCPF() {

		final String cpf = UtilCPF.geraCPF();

		if (UtilCPF.validaCPF(cpf)) {

			this.getFormulario().getEntidade().setCpf(cpf);
		}
	}

	/**
	 * Descrição Padrão: <br>
	 * 
	 * Implementação do método abstrato. <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.negocio.controller.Controller#limparDados()
	 */
	@Override
	public void limparDados() {

		this.getFormulario().setEntidade(new Usuario());
	}

	/**
	 * Descrição Padrão: <br>
	 * 
	 * Implementação do método abstrato. <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.controller.Controller#abreIniciar()
	 */
	@Override
	public String abreIniciar() {

		return "/admin/usuario/inicial";
	}

	/**
	 * Descrição Padrão: <br>
	 * 
	 * Implementação do método abstrato. <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.controller.ManutencaoController#abreIncluir()
	 */
	@Override
	public String abreIncluir() {

		return "/restrito/usuario/incluir.xhtml";
	}

	/**
	 * Descrição Padrão: <br>
	 * 
	 * Implementação do método abstrato. <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.controller.ConsultaController#abreDetalhar()
	 */
	@Override
	public String abreDetalhar() {

		return "/admin/usuario/detalhar.xhtml";
	}

	/**
	 * Retorna o valor do atributo <code>formulario</code>
	 *
	 * @return <code>ManterUsuarioFormulario</code>
	 */
	@Override
	public ManterUsuarioFormulario getFormulario() {

		return this.formulario;
	}

	/**
	 * Retorna o valor do atributo <code>service</code>
	 *
	 * @return <code>UsuarioService</code>
	 */
	@Override
	protected ManterUsuarioServiceFacade getService() {

		return this.service;
	}
}
