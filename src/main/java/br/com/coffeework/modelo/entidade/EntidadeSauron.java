package br.com.coffeework.modelo.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.coffeework.modelo.enuns.EnumStatus;

/**
 * <p>
 * <b>Título:</b> EntidadeSauron.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface <code>Entidade</code> e propagar os atributos em comuns as demais entidades.
 * </p>
 *
 * Data de criação: 23/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@MappedSuperclass
public abstract class EntidadeSauron implements Entidade {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1659289553323203738L;

	/** Atributo id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	/** Atributo status. */
	@Enumerated(value = EnumType.STRING)
	@Column(name = "status", length = 7, nullable = false)
	private EnumStatus status;

	/** Atributo dataCadastro. */
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false, updatable = false)
	private Date dataCadastro;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public EntidadeSauron() {

	}

	/**
	 * Método responsável por inserir valores aos atributos de data e de status.
	 *
	 * @author marcosbuganeme
	 *
	 */
	@PrePersist
	private void executar() {

		this.status = EnumStatus.ATIVO;

		this.verificaDataCadastro();
	}

	/**
	 * Método responsável por verificar se a data de cadastro está nula, caso esteja, atribuirá um novo valor a ela.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void verificaDataCadastro() {

		if (this.dataCadastro == null) {

			this.dataCadastro = new Date();
		}
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.modelo.entidade.Entidade#getIdentificador()
	 */
	@Override
	public Serializable getIdentificador() {

		return this.id;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.modelo.entidade.Entidade#isNovoRegistro()
	 */
	@Override
	public boolean isNovoRegistro() {

		return this.getIdentificador() == null;
	}

	/**
	 * Retorna o valor do atributo <code>status</code>
	 *
	 * @return <code>EnumStatus</code>
	 */
	public EnumStatus getStatus() {

		return this.status;
	}

	/**
	 * Define o valor do atributo <code>status</code>.
	 *
	 * @param status
	 */
	public void setStatus(final EnumStatus status) {

		this.status = status;
	}

	/**
	 * Retorna o valor do atributo <code>dataCadastro</code>
	 *
	 * @return <code>Date</code>
	 */
	public Date getDataCadastro() {

		return this.dataCadastro;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int numeroPrimo = 31;

		int resultado = 1;

		resultado = numeroPrimo * resultado + ( ( this.getIdentificador() == null ) ? 0 : this.getIdentificador().hashCode() );

		return resultado;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object objeto) {

		if (this == objeto) {

			return true;
		}

		if (objeto == null) {

			return false;
		}

		if (!( objeto instanceof EntidadeSauron )) {

			return false;
		}

		final EntidadeSauron entidadeSauron = (EntidadeSauron) objeto;

		if (this.getIdentificador() == null) {

			if (entidadeSauron.getIdentificador() != null) {

				return false;
			}

		} else if (!this.getIdentificador().equals(entidadeSauron.getIdentificador())) {

			return false;
		}

		return true;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return String.format("%s[id=%d]", this.getClass().getSimpleName(), this.getIdentificador());
	}
}
