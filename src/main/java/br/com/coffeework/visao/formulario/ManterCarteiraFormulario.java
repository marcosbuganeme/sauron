package br.com.coffeework.visao.formulario;

import java.util.Collection;

import br.com.coffeework.modelo.entidade.Carteira;
import br.com.coffeework.modelo.entidade.Usuario;

/**
 * <p>
 * <b>Título:</b> ManterCarteiraFormulario.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por prover os atributos de controle do ECDU 04 - Gerenciar Carteira
 * </p>
 *
 * Data de criação: 27/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class ManterCarteiraFormulario extends Formulario<Carteira> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -4667498006303585675L;

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
