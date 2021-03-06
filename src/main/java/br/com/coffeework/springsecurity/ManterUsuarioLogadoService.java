package br.com.coffeework.springsecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.coffeework.modelo.entidade.Permissao;
import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.persistencia.dao.UsuarioDAO;
import br.com.coffeework.util.cdi.CDIServiceLocator;

/**
 * <p>
 * <b>Título:</b> AppUserDetailsService.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por realizar a autenticação do usuário no sistema.
 * </p>
 *
 * Data de criação: 06/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class ManterUsuarioLogadoService implements UserDetailsService {

	/** Atributo usuarioDAO. */
	private final UsuarioDAO usuarioDAO;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public ManterUsuarioLogadoService() {

		this.usuarioDAO = CDIServiceLocator.getBean(UsuarioDAO.class);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {

		final Usuario usuario = this.usuarioDAO.obterUsuarioPorEmail(email);

		UsuarioSistema usuarioLogado = null;

		if (usuario != null) {

			usuarioLogado = new UsuarioSistema(usuario, this.getPermissoes(usuario));
		}

		return usuarioLogado;
	}

	/**
	 * Método responsável por obter as permissões vinculadas a um usuário.
	 *
	 * @author marcosbuganeme
	 *
	 * @param usuario
	 *            - usuário que será verificado.
	 * 
	 * @return <i>coleção de permissões vinculadas ao usuário</i>.
	 */
	private Collection<? extends GrantedAuthority> getPermissoes(final Usuario usuario) {

		final List<SimpleGrantedAuthority> colecaoPermissoes = new ArrayList<SimpleGrantedAuthority>();

		for (final Permissao permissao : usuario.getColecaoPermissoes()) {

			colecaoPermissoes.add(new SimpleGrantedAuthority(permissao.getPermissao().toString()));
		}

		return colecaoPermissoes;
	}
}
