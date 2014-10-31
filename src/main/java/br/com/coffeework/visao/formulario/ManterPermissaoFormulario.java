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
 * <b>Descrição:</b> Classe responsável por prover os atributos de controle do ECDU03 - Manter Permissão.
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

	/** Atributo colecaoUsuariosComboBox. */
	private Collection<Usuario> colecaoUsuariosComboBox;

	/**
	 * Retorna o valor do atributo <code>colecaoUsuariosComboBox</code>
	 *
	 * @return <code>Collection<Usuario></code>
	 */
	public Collection<Usuario> getColecaoUsuariosComboBox() {

		return this.colecaoUsuariosComboBox;
	}

	/**
	 * Define o valor do atributo <code>colecaoUsuariosComboBox</code>.
	 *
	 * @param colecaoUsuariosComboBox
	 */
	public void setColecaoUsuariosComboBox(final Collection<Usuario> colecaoUsuariosComboBox) {

		this.colecaoUsuariosComboBox = colecaoUsuariosComboBox;
	}

}
