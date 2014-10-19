package br.com.coffeework.visao.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.coffeework.modelo.entidade.Permissao;
import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.modelo.enuns.EnumPermissao;
import br.com.coffeework.springsecurity.UsuarioSistema;

/**
 * <p>
 * <b>Título:</b> UsuarioLogadoController.java
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
public class ManterUsuarioLogadoController implements Serializable {

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
	 * Método responsável por obter o usuário logado no sistema.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>usuário logado</i>.
	 */
	private UsuarioSistema obterUsuarioLogado() {

		UsuarioSistema usuarioSistema = null;

		final UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken) FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();

		if (this.validaObjetoSpringSecurity(user)) {

			usuarioSistema = (UsuarioSistema) user.getPrincipal();
		}

		return usuarioSistema;
	}

	/**
	 * Método responsável por obter a instância da entidade do tipo <code>Usuario</code> em tempo de execução e preencher os dados do usuário para edição do cadastro.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>objeto preenchido da entidade <code>Usuario</code></i>.
	 */
	public Usuario obterUsuarioLogadoMenuPerfil() {

		return this.obterUsuarioLogado().getUsuario();
	}

	/**
	 * Método responsável por validar o objeto de autenticação do spring security.
	 *
	 * @author marcosbuganeme
	 *
	 * @param user
	 *            - autenticador que será validado.
	 * 
	 * @return <i>true se o autenticador for válido</i>.
	 */
	private boolean validaObjetoSpringSecurity(final UsernamePasswordAuthenticationToken user) {

		if (user != null && user.getPrincipal() != null) {

			return true;
		}

		return false;
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

}
