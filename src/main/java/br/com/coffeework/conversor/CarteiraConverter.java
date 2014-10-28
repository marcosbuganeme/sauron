package br.com.coffeework.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.coffeework.modelo.entidade.Carteira;
import br.com.coffeework.negocio.service.facade.ManterCarteiraServiceFacade;
import br.com.coffeework.util.cdi.CDIServiceLocator;

/**
 * <p>
 * <b>Título:</b> BitcoinConverter.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por converter a entidade <code>Bitcoin</code> do estado objeto puro para um objeto do tipo String e vice versa.
 * </p>
 *
 * Data de criação: 27/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@FacesConverter(forClass = Carteira.class)
public class CarteiraConverter implements Converter {

	/** Atributo serviceFacade. */
	private final ManterCarteiraServiceFacade serviceFacade;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public CarteiraConverter() {

		this.serviceFacade = CDIServiceLocator.getBean(ManterCarteiraServiceFacade.class);
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

		Carteira carteiraRetornada = null;

		if (value != null) {

			final Long identificador = new Long(value);

			carteiraRetornada = this.serviceFacade.obterPorId(identificador);
		}

		return carteiraRetornada;
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

			final Carteira carteiraRetornada = (Carteira) value;

			return carteiraRetornada.getIdentificador() == null ? null : carteiraRetornada.getIdentificador().toString();
		}

		return "";
	}

}
