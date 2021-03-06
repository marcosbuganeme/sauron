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
 * <b>Descrição:</b> Classe responsável por prover os atributos de controle do ECDU05 - Manter Carteira.
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

	/** Atributo email. */
	private String email;

	/** Atributo saldo. */
	private Double saldo;

	/** Atributo colecaoUsuariosComboBox. */
	private Collection<Usuario> colecaoUsuariosComboBox;

	/** Atributo colecaousuariosComboBoxEditar. */
	private Collection<Usuario> colecaousuariosComboBoxEditar;

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

	/**
	 * Retorna o valor do atributo <code>colecaousuariosComboBoxEditar</code>
	 *
	 * @return <code>Collection<Usuario></code>
	 */
	public Collection<Usuario> getColecaousuariosComboBoxEditar() {

		return this.colecaousuariosComboBoxEditar;
	}

	/**
	 * Define o valor do atributo <code>colecaousuariosComboBoxEditar</code>.
	 *
	 * @param colecaousuariosComboBoxEditar
	 */
	public void setColecaousuariosComboBoxEditar(final Collection<Usuario> colecaousuariosComboBoxEditar) {

		this.colecaousuariosComboBoxEditar = colecaousuariosComboBoxEditar;
	}

	/**
	 * Retorna o valor do atributo <code>email</code>
	 *
	 * @return <code>String</code>
	 */
	public String getEmail() {

		return this.email;
	}

	/**
	 * Define o valor do atributo <code>email</code>.
	 *
	 * @param email
	 */
	public void setEmail(final String email) {

		this.email = email;
	}

	/**
	 * Retorna o valor do atributo <code>saldo</code>
	 *
	 * @return <code>Double</code>
	 */
	public Double getSaldo() {

		return this.saldo;
	}

	/**
	 * Define o valor do atributo <code>saldo</code>.
	 *
	 * @param saldo
	 */
	public void setSaldo(final Double saldo) {

		this.saldo = saldo;
	}

}
