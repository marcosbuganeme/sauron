package br.com.coffeework.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.coffeework.modelo.enuns.EnumPermissao;

/**
 * <p>
 * <b>Título:</b> Permissao.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por representar as permissões de acesso que um determinado usuário tenha em relação ao comportamento do sistema.
 * </p>
 *
 * Data de criação: 25/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "permissao")
public class Permissao extends EntidadeSauron {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -753804284935371761L;

	/** Atributo colecaoUsuarios. */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_USUARIO_PERMISSAO"))
	private Usuario usuario;

	/** Atributo tipoPermissao. */
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "permissao", length = 20)
	private EnumPermissao permissao;

	/** Atributo descricao. */
	@NotEmpty
	@Column(name = "descricao", length = 80)
	private String descricao;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public Permissao() {

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
	 * Retorna o valor do atributo <code>permissao</code>
	 *
	 * @return <code>EnumPermissao</code>
	 */
	public EnumPermissao getPermissao() {

		return this.permissao;
	}

	/**
	 * Define o valor do atributo <code>permissao</code>.
	 *
	 * @param permissao
	 */
	public void setPermissao(final EnumPermissao permissao) {

		this.permissao = permissao;
	}

	/**
	 * Retorna o valor do atributo <code>descricao</code>
	 *
	 * @return <code>String</code>
	 */
	public String getDescricao() {

		return this.descricao;
	}

	/**
	 * Define o valor do atributo <code>descricao</code>.
	 *
	 * @param descricao
	 */
	public void setDescricao(final String descricao) {

		this.descricao = descricao;
	}

}
