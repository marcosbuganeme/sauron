//package br.com.coffeework.visao.controller;
//
//import java.io.Serializable;
//
//import javax.enterprise.context.SessionScoped;
//import javax.faces.context.FacesContext;
//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * <p>
// * <b>Título:</b> ManterLoginBean.java
// * </p>
// *
// * <p>
// * <b>Descrição:</b> Classe responsável por manter o usuário logado.
// * </p>
// *
// * Data de criação: 07/10/2014
// *
// * @author marcosbuganeme
// *
// * @version 1.0.0
// */
//@Named
//@SessionScoped
//public class ManterUsuarioLogadoController implements Serializable {
//
//	/** Atributo serialVersionUID. */
//	private static final long serialVersionUID = -4958821882929624615L;
//
//	/** Atributo email. */
//	private String email;
//
//	/** Atributo context. */
//	@Inject
//	private FacesContext context;
//
//	/** Atributo request. */
//	@Inject
//	private HttpServletRequest request;
//
//	/** Atributo response. */
//	@Inject
//	private HttpServletResponse response;
//
//	/**
//	 * Método responsável por realizar o login do usuário no sistema.
//	 *
//	 * @author marcosbuganeme
//	 *
//	 */
//	public void login() {
//
//		final RequestDispatcher dispacher = this.request.getRequestDispatcher("/j_spring_security_check");
//
//	}
//
//	/**
//	 * Retorna o valor do atributo <code>email</code>
//	 *
//	 * @return <code>String</code>
//	 */
//	public String getEmail() {
//
//		return this.email;
//	}
//
//	/**
//	 * Define o valor do atributo <code>email</code>.
//	 *
//	 * @param email
//	 */
//	public void setEmail(final String email) {
//
//		this.email = email;
//	}
//
//}
