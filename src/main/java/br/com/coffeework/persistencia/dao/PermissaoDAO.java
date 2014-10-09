package br.com.coffeework.persistencia.dao;

import java.util.Collection;

import br.com.coffeework.modelo.entidade.Permissao;

/**
 * <p>
 * <b>Título:</b> PermissaoDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por prover as funções de consulta para e entidade <code>Permissao</code>.
 * </p>
 *
 * Data de criação: 01/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public interface PermissaoDAO extends DAO<Permissao> {

	Collection<Permissao> obterPermissoesPorUsuario(final Long idUsuario);
}
