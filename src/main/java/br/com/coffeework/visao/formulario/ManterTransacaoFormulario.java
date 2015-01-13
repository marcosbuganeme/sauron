package br.com.coffeework.visao.formulario;

import java.util.Collection;

import br.com.coffeework.modelo.entidade.BitCoin;
import br.com.coffeework.modelo.entidade.Carteira;
import br.com.coffeework.modelo.entidade.Transacao;

/**
 * <p>
 * <b>Título:</b> ManterTransacaoFormulario.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por prover os atributos de controle do ECDU07 - Manter Transação.
 * </p>
 *
 * Data de criação: 29/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class ManterTransacaoFormulario extends Formulario<Transacao> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 7338989568529585746L;

	/** Atributo colecaoComboBoxBitcoins. */
	private Collection<BitCoin> colecaoComboBoxBitcoins;

	/** Atributo colecaoComboBoxCarteiras. */
	private Collection<Carteira> colecaoComboBoxCarteiras;

	/** Atributo saldoBitcoinTransacao. */
	private Double valorUnitarioBitcoinDaTransacao;

	/** Atributo isMostrarValorUnitarioBitcoinDaTransacao. */
	private boolean isMostrarValorUnitarioBitcoinDaTransacao;

	/** Atributo comboBoxCarteiraUsuarioLogado. */
	private Collection<Carteira> comboBoxCarteiraUsuarioLogado;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public ManterTransacaoFormulario() {

	}

	/**
	 * Retorna o valor do atributo <code>colecaoComboBoxBitcoins</code>
	 *
	 * @return <code>Collection<BitCoin></code>
	 */
	public Collection<BitCoin> getColecaoComboBoxBitcoins() {

		return this.colecaoComboBoxBitcoins;
	}

	/**
	 * Define o valor do atributo <code>colecaoComboBoxBitcoins</code>.
	 *
	 * @param colecaoComboBoxBitcoins
	 */
	public void setColecaoComboBoxBitcoins(final Collection<BitCoin> colecaoComboBoxBitcoins) {

		this.colecaoComboBoxBitcoins = colecaoComboBoxBitcoins;
	}

	/**
	 * Retorna o valor do atributo <code>colecaoComboBoxCarteiras</code>
	 *
	 * @return <code>Collection<Carteira></code>
	 */
	public Collection<Carteira> getColecaoComboBoxCarteiras() {

		return this.colecaoComboBoxCarteiras;
	}

	/**
	 * Define o valor do atributo <code>colecaoComboBoxCarteiras</code>.
	 *
	 * @param colecaoComboBoxCarteiras
	 */
	public void setColecaoComboBoxCarteiras(final Collection<Carteira> colecaoComboBoxCarteiras) {

		this.colecaoComboBoxCarteiras = colecaoComboBoxCarteiras;
	}

	/**
	 * Retorna o valor do atributo <code>valorUnitarioBitcoinDaTransacao</code>
	 *
	 * @return <code>BigDecimal</code>
	 */
	public Double getValorUnitarioBitcoinDaTransacao() {

		return this.valorUnitarioBitcoinDaTransacao;
	}

	/**
	 * Define o valor do atributo <code>valorUnitarioBitcoinDaTransacao</code>.
	 *
	 * @param valorUnitarioBitcoinDaTransacao
	 */
	public void setValorUnitarioBitcoinDaTransacao(final Double valorUnitarioBitcoinDaTransacao) {

		this.valorUnitarioBitcoinDaTransacao = valorUnitarioBitcoinDaTransacao;
	}

	/**
	 * Retorna o valor do atributo <code>isMostrarValorUnitarioBitcoinDaTransacao</code>
	 *
	 * @return <code>boolean</code>
	 */
	public boolean isMostrarValorUnitarioBitcoinDaTransacao() {

		return this.isMostrarValorUnitarioBitcoinDaTransacao;
	}

	/**
	 * Define o valor do atributo <code>isMostrarValorUnitarioBitcoinDaTransacao</code>.
	 *
	 * @param isMostrarValorUnitarioBitcoinDaTransacao
	 */
	public void setMostrarValorUnitarioBitcoinDaTransacao(final boolean isMostrarValorUnitarioBitcoinDaTransacao) {

		this.isMostrarValorUnitarioBitcoinDaTransacao = isMostrarValorUnitarioBitcoinDaTransacao;
	}

	/**
	 * Retorna o valor do atributo <code>comboBoxCarteiraUsuarioLogado</code>
	 *
	 * @return <code>Collection<Carteira></code>
	 */
	public Collection<Carteira> getComboBoxCarteiraUsuarioLogado() {

		return this.comboBoxCarteiraUsuarioLogado;
	}

	/**
	 * Define o valor do atributo <code>comboBoxCarteiraUsuarioLogado</code>.
	 *
	 * @param comboBoxCarteiraUsuarioLogado
	 */
	public void setComboBoxCarteiraUsuarioLogado(final Collection<Carteira> comboBoxCarteiraUsuarioLogado) {

		this.comboBoxCarteiraUsuarioLogado = comboBoxCarteiraUsuarioLogado;
	}
}
