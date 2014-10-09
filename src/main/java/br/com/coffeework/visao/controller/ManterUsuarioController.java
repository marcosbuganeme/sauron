package br.com.coffeework.visao.controller;

import java.text.SimpleDateFormat;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.negocio.service.ManterUsuarioService;
import br.com.coffeework.util.pattern.UtilCPF;
import br.com.coffeework.visao.formulario.ManterUsuarioFormulario;

/**
 * <p>
 * <b>Título:</b> ManterUsuarioController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por gerenciar a tela da entidade <code>Usuario</code>.
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

	@Inject
	/** Atributo formulario. */
	private ManterUsuarioFormulario formulario;

	@Inject
	/** Atributo service. */
	private ManterUsuarioService service;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public ManterUsuarioController() {

	}

	/**
	 * Método responsável por formatar a data de cadastro do usuário.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>a data de cadastro do usuário formatada de acordo com o pattern dd/MM/yyyy</i>.
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

			this.getFormulario().getEntidade().setCpf(new String(cpf));
		}
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
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
	protected ManterUsuarioService getService() {

		return this.service;
	}

}
