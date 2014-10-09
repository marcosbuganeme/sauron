package br.com.coffeework.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.coffeework.modelo.entidade.Usuario;
import br.com.coffeework.negocio.service.facade.ManterUsuarioServiceFacade;
import br.com.coffeework.util.cdi.CDIServiceLocator;

/**
 * <p>
 * <b>Título:</b> UsuarioConverter.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por converter a entidade <code>Usuario</code> do estado objeto puro para um objeto do tipo String e vice versa.
 * </p>
 *
 * Data de criação: 28/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

	/** Atributo serviceFacade. */
	private final ManterUsuarioServiceFacade serviceFacade;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public UsuarioConverter() {

		this.serviceFacade = CDIServiceLocator.getBean(ManterUsuarioServiceFacade.class);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {

		Usuario usuarioRetornado = null;

		if (value != null) {

			final Long identificador = new Long(value);

			usuarioRetornado = this.serviceFacade.obterPorId(identificador);
		}

		return usuarioRetornado;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {

		if (value != null) {

			final Usuario usuarioConvertido = (Usuario) value;

			return usuarioConvertido.getIdentificador() == null ? null : usuarioConvertido.getIdentificador().toString();
		}

		return "";
	}

}
