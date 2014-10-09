package br.com.coffeework.visao.formulario;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

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
public class ManterUsuarioLogadoController {

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

		for (final GrantedAuthority authority : this.obterUsuarioLogado().getAuthorities()) {

			final String nomePermissao = authority.getAuthority();

			if (nomePermissao.toUpperCase().equals(EnumPermissao.ADMINISTRADOR.name())) {

				return true;
			}
		}

		return false;
	}

}
