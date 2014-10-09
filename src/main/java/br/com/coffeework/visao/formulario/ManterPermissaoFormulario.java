package br.com.coffeework.visao.formulario;

import java.util.Collection;

import br.com.coffeework.modelo.entidade.Permissao;
import br.com.coffeework.modelo.entidade.Usuario;

/**
 * <p>
 * <b>Título:</b> ManterPermissaoFormulario.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por conter os atributos que serão usados nos formulários da entidade <code>Permissao</code>.
 * </p>
 *
 * Data de criação: 01/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class ManterPermissaoFormulario extends Formulario<Permissao> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 4331853604598332970L;

	/** Atributo palavraConsultada. */
	private String palavraConsultada;

	/** Atributo colecaoUsuarios. */
	private Collection<Usuario> colecaoUsuarios;

	/**
	 * Retorna o valor do atributo <code>colecaoUsuarios</code>
	 *
	 * @return <code>Collection<Usuario></code>
	 */
	public Collection<Usuario> getColecaoUsuarios() {

		return this.colecaoUsuarios;
	}

	/**
	 * Define o valor do atributo <code>colecaoUsuarios</code>.
	 *
	 * @param colecaoUsuarios
	 */
	public void setColecaoUsuarios(final Collection<Usuario> colecaoUsuarios) {

		this.colecaoUsuarios = colecaoUsuarios;
	}

	/**
	 * Retorna o valor do atributo <code>palavraConsultada</code>
	 *
	 * @return <code>String</code>
	 */
	public String getPalavraConsultada() {

		return this.palavraConsultada;
	}

	/**
	 * Define o valor do atributo <code>palavraConsultada</code>.
	 *
	 * @param palavraConsultada
	 */
	public void setPalavraConsultada(final String palavraConsultada) {

		this.palavraConsultada = palavraConsultada;
	}

}
