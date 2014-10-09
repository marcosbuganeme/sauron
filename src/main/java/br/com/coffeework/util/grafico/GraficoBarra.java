package br.com.coffeework.util.grafico;

import java.io.Serializable;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

public class GraficoBarra implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -5199774959629742964L;

	/** Atributo chartModel. */
	private final CartesianChartModel chartModel;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public GraficoBarra() {

		this.chartModel = new CartesianChartModel();
	}

	public void adicionarSerie(final String rotulo) {

		final ChartSeries series = new ChartSeries();

		this.chartModel.addSeries(series);
	}

	/**
	 * Retorna o valor do atributo <code>chartModel</code>
	 *
	 * @return <code>CartesianChartModel</code>
	 */
	public CartesianChartModel getChartModel() {

		return this.chartModel;
	}

}
