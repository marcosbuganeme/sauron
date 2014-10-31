package br.com.coffeework.visao.controller;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.coffeework.visao.bundle.ResourceBundleArquitetura;
import br.com.coffeework.visao.bundle.ResourceBundleArquiteturaFactory;

/**
 * <p>
 * <b>Título:</b> Controller.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por prover funções para o fluxo de navegação do sistema.
 * </p>
 *
 * Data de criação: 21/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public abstract class Controller implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -900287521825004131L;

	/**
	 * Método responsável por inicializar os dados do controlador.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void iniciarDados() {

		return;
	}

	/**
	 * Método responsável por limpar os dados de uma entidade.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public abstract void limparDados();

	/**
	 * Método responsável por navegar para a página inicial de um ECDU.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>página inicial</i>.
	 */
	public abstract String abreIniciar();

	/**
	 * Método responsável por retornar a mensagem vinculada a chave passada como parâmetro.
	 * 
	 * @author marcosbuganeme
	 * 
	 * @param keyMessage
	 *            - Chave da mensagem.
	 * 
	 * @return <i>mensagem a ser exibida na tela</i>.
	 */
	public String getMessage(final String keyMessage) {

		return this.getBundle().getString(keyMessage);
	}

	/**
	 * Método responsável por retornar a mensagem vinculada a chave passada como parâmetro.
	 * 
	 * @author marcosbuganeme
	 * 
	 * @param keyMessage
	 *            - Chave da mensagem.
	 * 
	 * @param parametro
	 *            - Parâmetros da mensagem.
	 * 
	 * @return mensagem a ser exibida na tela.
	 */
	public String getMessage(final String keyMessage, final Object[] parametro) {

		final String mensagem = this.getBundle().getString(keyMessage);

		return MessageFormat.format(mensagem, parametro);
	}

	/**
	 * Método responsável por retornar as mensagens vinculadas as chaves passadas como parâmetro.
	 * 
	 * @author marcosbuganeme
	 * 
	 * @param keyMessages
	 *            Chaves das mensagem.
	 * 
	 * @return mensagens a serem exibidas na tela.
	 */
	public String[] getMessages(final String... keyMessages) {

		final String[] mensagens = new String[keyMessages.length];

		for (int indice = 0; indice < keyMessages.length; indice++) {

			mensagens[indice] = this.getBundle().getString(keyMessages[indice]);
		}

		return mensagens;
	}

	/**
	 * Retorna o valor do atributo bundle.
	 * 
	 * @return <code>ResourceBundle</code> Arquivo de mensagens da arquitetura.
	 */
	protected ResourceBundle getBundle() {

		return ResourceBundleArquiteturaFactory.getBundle(this.getResourceBundleFactory());
	}

	/**
	 * Obtem o ResourceBundleFactory para o controlador
	 * 
	 * @return ResourceBundleFactory para o controlador
	 * 
	 * @see ResourceBundleArquiteturaFactory
	 */
	protected Class<? extends ResourceBundleArquiteturaFactory> getResourceBundleFactory() {

		return ResourceBundleArquitetura.class;
	}
}
