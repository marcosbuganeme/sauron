package br.com.coffeework.modelo.entidade;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * <b>Título:</b> Conta.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por representar a carteira do usuário do sistema.
 * </p>
 *
 * Data de criação: 29/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "carteira")
public class Carteira extends EntidadeSauron {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -1266465153919598041L;

	/** Atributo usuario. */
	@OneToOne(optional = false)
	@JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "FK_USUARIO_CARTEIRA"))
	private Usuario usuario;

	/** Atributo colecaoTransacoes. */
	@OneToMany(mappedBy = "carteira")
	private Collection<Transacao> colecaoTransacoes;

	/** Atributo saldo. */
	@NotNull
	@Column(name = "saldo", nullable = false)
	private Double saldo;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public Carteira() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param usuario
	 * 
	 * @param saldo
	 */
	public Carteira( final Usuario usuario, final Double saldo ) {

		this.usuario = usuario;

		this.saldo = saldo;
	}

	/**
	 * Retorna o valor do atributo <code>usuario</code>
	 *
	 * @return <code>Usuario</code>
	 */
	public Usuario getUsuario() {

		return this.usuario;
	}

	/**
	 * Define o valor do atributo <code>usuario</code>.
	 *
	 * @param usuario
	 */
	public void setUsuario(final Usuario usuario) {

		this.usuario = usuario;
	}

	/**
	 * Retorna o valor do atributo <code>colecaoTransacoes</code>
	 *
	 * @return <code>Collection<Transacao></code>
	 */
	public Collection<Transacao> getColecaoTransacoes() {

		return this.colecaoTransacoes;
	}

	/**
	 * Define o valor do atributo <code>colecaoTransacoes</code>.
	 *
	 * @param colecaoTransacoes
	 */
	public void setColecaoTransacoes(final Collection<Transacao> colecaoTransacoes) {

		this.colecaoTransacoes = colecaoTransacoes;
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
