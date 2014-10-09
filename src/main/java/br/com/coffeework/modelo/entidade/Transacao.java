package br.com.coffeework.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.coffeework.modelo.enuns.EnumTipoOperacao;

/**
 * <p>
 * <b>Título:</b> Transacao.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por representar as transações da <code>Conta</code> do <code>Usuario</code>.
 * </p>
 *
 * Data de criação: 30/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "transacao")
public class Transacao extends EntidadeSauron {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1694386149640232110L;

	/** Atributo carteira. */
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_carteira", nullable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_CARTEIRA_TRANSACAO"))
	private Carteira carteira;

	/** Atributo bitCoin. */
	@OneToOne(optional = false)
	@JoinColumn(name = "id_bitcoin", nullable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_BITCOIN_TRANSACAO"))
	private BitCoin bitCoin;

	/** Atributo tipoOperacao. */
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_operacao", length = 20, nullable = false)
	private EnumTipoOperacao tipoOperacao;

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
	 * Retorna o valor do atributo <code>bitCoin</code>
	 *
	 * @return <code>BitCoin</code>
	 */
	public BitCoin getBitCoin() {

		return this.bitCoin;
	}

	/**
	 * Define o valor do atributo <code>bitCoin</code>.
	 *
	 * @param bitCoin
	 */
	public void setBitCoin(final BitCoin bitCoin) {

		this.bitCoin = bitCoin;
	}

	/**
	 * Retorna o valor do atributo <code>tipoOperacao</code>
	 *
	 * @return <code>EnumTipoOperacao</code>
	 */
	public EnumTipoOperacao getTipoOperacao() {

		return this.tipoOperacao;
	}

	/**
	 * Define o valor do atributo <code>tipoOperacao</code>.
	 *
	 * @param tipoOperacao
	 */
	public void setTipoOperacao(final EnumTipoOperacao tipoOperacao) {

		this.tipoOperacao = tipoOperacao;
	}

}
