package br.com.coffeework.visao.controller;

import java.io.IOException;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coffeework.util.jsf.UtilitarioJSF;

/**
 * <p>
 * <b>Título:</b> ManterLoginController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pelo controle de regras de negócio da tela do ECDU01 - Manter Login.
 * </p>
 *
 * Data de criação: 08/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Named
@SessionScoped
public class ManterLoginController extends Controller {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 3370166387308296693L;

	/** Constante FALHA_VALIDACAO_CREDENCIAIS. */
	private static final String FALHA_VALIDACAO_CREDENCIAIS = "credencial.invalida";

	/** Atributo facesContext. */
	@Inject
	private FacesContext facesContext;

	/** Atributo email. */
	private String email;

	/**
	 * Método responsável por inicializar o ciclo de vida do JSF na sexta fase (RENDER_RESPONSE).
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void preRender() {

		if ("true".equals(this.getRequest().getParameter("invalid"))) {

			final String mensagemCredencialInvalida = this.getMessage(ManterLoginController.FALHA_VALIDACAO_CREDENCIAIS);

			UtilitarioJSF.addMensagemError(mensagemCredencialInvalida);
		}
	}

	/**
	 * Método responsável por autenticar um usuário, verificando suas credenciais na base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @throws ServletException
	 * 
	 * @throws IOException
	 */
	public void autenticar() throws ServletException, IOException {

		final RequestDispatcher dispatcher = this.getRequest().getRequestDispatcher("/j_spring_security_check");

		dispatcher.forward(this.getRequest(), this.getResponse());

		this.facesContext.responseComplete();
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
	 * Retorna o valor do atributo <code>request</code>
	 *
	 * @return <code>HttpServletRequest</code>
	 */
	protected HttpServletRequest getRequest() {

		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * Retorna o valor do atributo <code>response</code>
	 *
	 * @return <code>HttpServletResponse</code>
	 */
	protected HttpServletResponse getResponse() {

		return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.controller.Controller#limparDados()
	 */
	@Override
	public void limparDados() {

		this.email = new String();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.controller.Controller#abreIniciar()
	 */
	@Override
	public String abreIniciar() {

		return null;
	}

}
