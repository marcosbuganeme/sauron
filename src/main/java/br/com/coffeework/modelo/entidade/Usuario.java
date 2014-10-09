package br.com.coffeework.modelo.entidade;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>
 * <b>Título:</b> Usuario.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por representar o ator do sistema.
 * </p>
 *
 * Data de criação: 21/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "usuario")
public class Usuario extends EntidadeSauron {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -3702217709387552563L;

	/** Atributo colecaoPermissoes. */
	@OneToMany(mappedBy = "usuario")
	private Collection<Permissao> colecaoPermissoes;

	/** Atributo carteira. */
	@OneToOne(mappedBy = "usuario")
	private Carteira carteira;

	/** Atributo nome. */
	@NotEmpty
	@Column(name = "nome", length = 80)
	private String nome;

	/** Atributo cpf. */
	@NotEmpty
	@Column(name = "cpf", length = 14)
	private String cpf;

	/** Atributo email. */
	@NotEmpty
	@Email
	@Column(name = "email", length = 80, unique = true)
	private String email;

	/** Atributo senha. */
	@NotEmpty
	@Column(name = "senha", length = 60)
	private String senha;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public Usuario() {

	}

	/**
	 * Retorna o valor do atributo <code>colecaoPermissoes</code>
	 *
	 * @return <code>Collection<Permissao></code>
	 */
	public Collection<Permissao> getColecaoPermissoes() {

		return this.colecaoPermissoes;
	}

	/**
	 * Define o valor do atributo <code>colecaoPermissoes</code>.
	 *
	 * @param colecaoPermissoes
	 */
	public void setColecaoPermissoes(final Collection<Permissao> colecaoPermissoes) {

		this.colecaoPermissoes = colecaoPermissoes;
	}

	/**
	 * Retorna o valor do atributo <code>carteira</code>
	 *
	 * @return <code>Carteira</code>
	 */
	public Carteira getCarteira() {

		return this.carteira;
	}

	/**
	 * Define o valor do atributo <code>carteira</code>.
	 *
	 * @param carteira
	 */
	public void setCarteira(final Carteira carteira) {

		this.carteira = carteira;
	}

	/**
	 * Retorna o valor do atributo <code>nome</code>
	 *
	 * @return <code>String</code>
	 */
	public String getNome() {

		return this.nome;
	}

	/**
	 * Define o valor do atributo <code>nome</code>.
	 *
	 * @param nome
	 */
	public void setNome(final String nome) {

		this.nome = nome;
	}

	/**
	 * Retorna o valor do atributo <code>cpf</code>
	 *
	 * @return <code>String</code>
	 */
	public String getCpf() {

		return this.cpf;
	}

	/**
	 * Define o valor do atributo <code>cpf</code>.
	 *
	 * @param cpf
	 */
	public void setCpf(final String cpf) {

		this.cpf = cpf;
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
	 * Retorna o valor do atributo <code>senha</code>
	 *
	 * @return <code>String</code>
	 */
	public String getSenha() {

		return this.senha;
	}

	/**
	 * Define o valor do atributo <code>senha</code>.
	 *
	 * @param senha
	 */
	public void setSenha(final String senha) {

		this.senha = senha;
	}

}
