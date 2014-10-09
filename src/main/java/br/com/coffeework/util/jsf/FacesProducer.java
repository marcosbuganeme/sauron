package br.com.coffeework.util.jsf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FacesProducer {

	/**
	 * Método responsável por obter o objeto facesContext do JSF.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>facesContext para a aplicação</i>.
	 */
	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {

		return FacesContext.getCurrentInstance();
	}

	/**
	 * Método responsável por obter o objeto externalContext do jSF.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>externalContext paa a aplicação</i>.
	 */
	@Produces
	@RequestScoped
	public ExternalContext getExternalContext() {

		return this.getFacesContext().getExternalContext();
	}

//	/**
//	 * Método responsável por obter o httpServletResquest (objeto de requisição).
//	 *
//	 * @author marcosbuganeme
//	 *
//	 * @return <i>objeto de requisição servlet</i>.
//	 */
//	@Produces
//	@RequestScoped
//	public HttpServletRequest getHttpServletRequest() {
//
//		return ( (HttpServletRequest) this.getExternalContext().getRequest() );
//	}
//
//	/**
//	 * Método responsável por obter o objeto de resposta.
//	 *
//	 * @author marcosbuganeme
//	 *
//	 * @return <i>objeto de resposta servelt</i>.
//	 */
//	@Produces
//	@RequestScoped
//	public HttpServletResponse getHttpServletResponse() {
//
//		return ( (HttpServletResponse) this.getExternalContext().getResponse() );
//	}

}
