package br.com.coffeework.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.coffeework.modelo.entidade.Transacao;
import br.com.coffeework.negocio.service.facade.ManterTransacaoServiceFacade;
import br.com.coffeework.util.cdi.CDIServiceLocator;

/**
 * <p>
 * <b>Título:</b> TransacaoConverter.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por converter a entidade <code>Transacao</code> do estado objeto puro para um objeto do tipo String e vice versa.
 * </p>
 *
 * Data de criação: 31/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@FacesConverter(forClass = Transacao.class)
public class TransacaoConverter implements Converter {

	/** Atributo serviceFacade. */
	private final ManterTransacaoServiceFacade serviceFacade;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public TransacaoConverter() {

		this.serviceFacade = CDIServiceLocator.getBean(ManterTransacaoServiceFacade.class);
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

		Transacao transacaoRetornada = null;

		if (value != null) {

			final Long identificador = new Long(value);

			transacaoRetornada = this.serviceFacade.obterPorId(identificador);
		}

		return transacaoRetornada;
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

			final Transacao transacaoConvertida = (Transacao) value;

			return transacaoConvertida.getIdentificador() == null ? null : transacaoConvertida.getIdentificador().toString();
		}

		return "";
	}

}
