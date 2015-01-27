package br.com.coffeework.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>
 * <b>Título:</b> BitCoin.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por representar a moeda virtual bitcoin.
 * </p>
 *
 * Data de criação: 29/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "bitcoin")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BitCoin extends EntidadeSauron {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -2460908223911176459L;

	/** Atributo transacao. */
	@OneToOne(mappedBy = "bitCoin")
	private Transacao transacao;

	/** Atributo volume. */
	@NotEmpty
	@Column(name = "volume", length = 10, nullable = false)
	private String volume;

	/** Atributo preco. */
	@NotNull
	@Column(name = "preco", nullable = false)
	private Double preco;

	/** Atributo isComercializado. */
	@Column(name = "comercializado", nullable = false)
	private boolean isComercializado;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public BitCoin() {

	}

	/**
	 * Retorna o valor do atributo <code>transacao</code>
	 *
	 * @return <code>Transacao</code>
	 */
	public Transacao getTransacao() {

		return this.transacao;
	}

	/**
	 * Define o valor do atributo <code>transacao</code>.
	 *
	 * @param transacao
	 */
	public void setTransacao(final Transacao transacao) {

		this.transacao = transacao;
	}

	/**
	 * Retorna o valor do atributo <code>volume</code>
	 *
	 * @return <code>String</code>
	 */
	public String getVolume() {

		return this.volume;
	}

	/**
	 * Define o valor do atributo <code>volume</code>.
	 *
	 * @param volume
	 */
	public void setVolume(final String volume) {

		this.volume = volume;
	}

	/**
	 * Retorna o valor do atributo <code>preco</code>
	 *
	 * @return <code>Double</code>
	 */
	public Double getPreco() {

		return this.preco;
	}

	/**
	 * Define o valor do atributo <code>preco</code>.
	 *
	 * @param preco
	 */
	public void setPreco(final Double preco) {

		this.preco = preco;
	}

	/**
	 * Retorna o valor do atributo <code>isComercializado</code>
	 *
	 * @return <code>boolean</code>
	 */
	public boolean isComercializado() {

		return this.isComercializado;
	}

	/**
	 * Define o valor do atributo <code>isComercializado</code>.
	 *
	 * @param isComercializado
	 */
	public void setComercializado(final boolean isComercializado) {

		this.isComercializado = isComercializado;
	}

}
