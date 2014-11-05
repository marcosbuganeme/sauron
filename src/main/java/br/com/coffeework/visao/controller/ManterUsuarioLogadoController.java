package br.com.coffeework.visao.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.coffeework.modelo.entidade.Permissao;
import br.com.coffeework.modelo.enuns.EnumPermissao;
import br.com.coffeework.springsecurity.UsuarioSistema;

/**
 * <p>
 * <b>Título:</b> ManterUsuarioLogadoController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por controlar/condicionar o usuário logado no sistema ao seu devido fluxo de dados.
 * </p>
 *
 * Data de criação: 07/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Named
@RequestScoped
public class ManterUsuarioLogadoController extends Controller {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -5558526973888319059L;

	/**
	 * Método responsável por obter o nome do usuário logado.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>nome do usuário logado</i>.
	 */
	public String getNomeUsuarioLogado() {

		String nomeUsuarioLogado = null;

		final UsuarioSistema usuarioSistema = this.obterUsuarioLogado();

		if (usuarioSistema != null) {

			nomeUsuarioLogado = usuarioSistema.getUsuario().getNome();
		}

		return nomeUsuarioLogado;
	}

	/**
	 * Método responsável por verificar se o usuário logado é do tipo ADMINISTRADOR.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>true, se o usuário for administrador</i>.
	 */
	public boolean isAdministrador() {

		final UsuarioSistema user = this.obterUsuarioLogado();

		for (final Permissao permissao : user.getUsuario().getColecaoPermissoes()) {

			if (permissao.getPermissao().equals(EnumPermissao.ADMINISTRADOR)) {

				return true;
			}
		}

		return false;
	}

	/**
	 * Método responsável por obter o usuário logado no sistema.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>usuário logado</i>.
	 */
	public UsuarioSistema obterUsuarioLogado() {

		UsuarioSistema usuarioSistema = null;

		final UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken) FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();

		if (user != null) {

			usuarioSistema = (UsuarioSistema) user.getPrincipal();
		}

		return usuarioSistema;
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

		return null;
	}

}
