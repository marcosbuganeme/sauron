package br.com.coffeework.visao.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.coffeework.exception.NegocioException;
import br.com.coffeework.modelo.entidade.Entidade;
import br.com.coffeework.util.jsf.UtilitarioJSF;

/**
 * <p>
 * <b>Título:</b> ManutencaoController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por prover funções pré estabelecidadas para recuperação e persistência de dados.
 * </p>
 *
 * Data de criação: 23/09/2014
 *
 * @author marcosbuganeme
 * 
 * @param <E>
 *            - Entidade que será manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
public abstract class ManutencaoController<E extends Entidade> extends ConsultaController<E> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -3930469472566435845L;

	/** Constante LOG. */
	private static final Log LOG = LogFactory.getLog(ManutencaoController.class);

	/** Constante MSG_SALVAR_SUCESSO. */
	private static final String MSG_SALVAR_SUCESSO = "registro.salvo.sucesso";

	/** Constante MSG_SALVAR_SUCESSO. */
	private static final String MSG_ALTERAR_SUCESSO = "registro.alterado.sucesso";

	/** Constante MSG_EXCLUIR_SUCESSO. */
	private static final String MSG_EXCLUIR_SUCESSO = "registro.remover.sucesso";

	/**
	 * Método responsável por navegar para a página de inclusão de um ECDU.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>página de inclusão</i>.
	 */
	public abstract String abreIncluir();

	/**
	 * Método responsável por persistir o objeto parametrizado na base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será persistido.
	 * 
	 * @throws NegocioException
	 */
	public void salvar() {

		try {

			this.getService().salvar(this.getFormulario().getEntidade());

			final String mensagemSalvar = this.getMessage(ManutencaoController.MSG_SALVAR_SUCESSO);

			UtilitarioJSF.addMensagemInfo(mensagemSalvar);

			this.limparDados();

		} catch (final NegocioException negocioException) {

			UtilitarioJSF.addMensagemError(this.getMessage(negocioException.getMessage()));

			ManutencaoController.LOG.error("ERRO MÉTODO SALVAR() " + this.getClass().getSimpleName(), negocioException.getCause());
		}
	}

	/**
	 * Método responsável por mesclar um objeto (Salvar e/ou alterar). <br>
	 * Merge: Verifica se o objeto existe na base de dados, caso exista, ele altera, caso não exista, ele salva.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será persistido/alterado.
	 */
	public void mesclar() {

		try {

			this.getService().mesclar(this.getFormulario().getEntidade());

			final String mensagemMesclar = this.getMessage(ManutencaoController.MSG_ALTERAR_SUCESSO);

			UtilitarioJSF.addMensagemInfo(mensagemMesclar);

			this.limparDados();

		} catch (final NegocioException negocioException) {

			UtilitarioJSF.addMensagemError(this.getMessage(negocioException.getMessage()));

			ManutencaoController.LOG.error("ERRO MÉTODO MESCLAR()" + this.getClass().getSimpleName(), negocioException.getCause());
		}
	}

	/**
	 * Método responsável por remover um objeto da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será persistido/alterado.
	 */
	public void remover() {

		try {

			this.getService().remover(this.getFormulario().getEntidade());

			this.getFormulario().getColecaoEntidades().remove(this.getFormulario().getEntidade());

			final String mensagemExcluir = this.getMessage(ManutencaoController.MSG_EXCLUIR_SUCESSO);

			UtilitarioJSF.addMensagemInfo(mensagemExcluir);

		} catch (final NegocioException negocioException) {

			UtilitarioJSF.addMensagemError(this.getMessage(negocioException.getMessage()));

			ManutencaoController.LOG.error("ERRO MÉTODO REMOVER()" + this.getClass().getSimpleName(), negocioException.getCause());
		}
	}

}
