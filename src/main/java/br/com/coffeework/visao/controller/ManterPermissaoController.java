package br.com.coffeework.visao.controller;

import java.util.Arrays;
import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.coffeework.modelo.entidade.Permissao;
import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.modelo.enuns.EnumPermissao;
import br.com.coffeework.negocio.service.ManterPermissaoService;
import br.com.coffeework.visao.formulario.ManterPermissaoFormulario;

/**
 * <p>
 * <b>Título:</b> ManterPermissaoController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por gerenciar a tela da entidade <code>Permissao</code>.
 * </p>
 *
 * Data de criação: 01/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Named
@ViewScoped
public class ManterPermissaoController extends ManutencaoController<Permissao> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 76877174362364325L;

	/** Atributo formulario. */
	@Inject
	private ManterPermissaoFormulario formulario;

	/** Atributo service. */
	@Inject
	private ManterPermissaoService service;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public ManterPermissaoController() {

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

		this.getFormulario().setColecaoUsuarios(this.getService().consultarTodosUsuarios());
	}

	/**
	 * Método responsável por obter uma colecação de todos os usuários registrados.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de usuários</i>.
	 */
	public Collection<Usuario> obterUsuarios() {

		return this.getFormulario().getColecaoUsuarios();
	}

	/**
	 * Método responsável por obter um usuário pelo seu email.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <code>coleção de usuário pesquisado</code>.
	 */
	public Collection<Usuario> autoCompleteUsuario(final String email) {

		return this.getService().obterUsuarioPorEmail(email);
	}

	/**
	 * Método responsável por obter uma lista dos tipos de permissões.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de permissões</i>
	 */
	public Collection<EnumPermissao> obterPermissoes() {

		return Arrays.asList(EnumPermissao.values());
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

		this.getFormulario().setEntidade(new Permissao());
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

		return "/admin/permissao/inicial.xhtml";
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

		return "/admin/permissao/incluir.xhtml";
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

		return "/admin/permissao/detalhar.xhtml";
	}

	/**
	 * Retorna o valor do atributo <code>formulario</code>
	 *
	 * @return <code>ManterPermissaoFormulario</code>
	 */
	@Override
	public ManterPermissaoFormulario getFormulario() {

		return this.formulario;
	}

	/**
	 * Retorna o valor do atributo <code>service</code>
	 *
	 * @return <code>ManterPermissaoService</code>
	 */
	@Override
	public ManterPermissaoService getService() {

		return this.service;
	}

}
