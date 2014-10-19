package br.com.coffeework.visao.controller;

import java.io.IOException;
import java.io.Serializable;

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
 * <b>Descrição:</b> Classe responsável por manter o usuário logado em sessão.
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
public class ManterLoginController implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 3370166387308296693L;

	/** Atributo email. */
	private String email;

	/** Atributo facesContext. */
	@Inject
	private FacesContext facesContext;

	/**
	 * Método responsável por inicialziar o ciclo de vida do JSF e executar logo na sexta fase.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void preRender() {

		if ("true".equals(this.getRequest().getParameter("invalid"))) {

			UtilitarioJSF.addMensagemError("Usuário e/ou senha inválido!");
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

}
