package br.com.coffeework.util.pattern;

/**
 * <p>
 * <b>Título:</b> UtilCPF.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por prover funções pré definidas sobre geração e validação de CPF.
 * </p>
 *
 * Data de criação: 03/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public final class UtilCPF {

	/**
	 * Método responsável por gerar um cpf com 09 números iniciais aleatórios.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>um cpf completo de 11 dígitos</i>.
	 */
	public static String geraCPF() {

		String noveDigitosIniciaisCPF = "";

		Integer numero;

		for (int i = 0; i < 9; i++) {

			numero = new Integer((int) ( Math.random() * 10 ));

			noveDigitosIniciaisCPF += numero.toString();
		}

		return noveDigitosIniciaisCPF + UtilCPF.calcularDigitosVerifacacao(noveDigitosIniciaisCPF);
	}

	/**
	 * Método responsável por calcular os últimos 2 dígitos do CPF baseado no número gerado automaticamente pelo método invocador.
	 *
	 * @author marcosbuganeme
	 *
	 * @param noveDigitosIniciaisCPF
	 *            - cpf aleatório de 9 dígitos gerados pelo método invocador.
	 * 
	 * @return <i>os 2 últimos dígitos do CPF</i>.
	 */
	private static String calcularDigitosVerifacacao(final String noveDigitosIniciaisCPF) {

		Integer decimoNumeroCPF, decimoPrimeiroNumeroCPF;

		int soma = 0, peso = 10;

		for (int i = 0; i < noveDigitosIniciaisCPF.length(); i++) {

			soma += Integer.parseInt(noveDigitosIniciaisCPF.substring(i, i + 1)) * peso--;
		}

		if (soma % 11 == 0 | soma % 11 == 1) {

			decimoNumeroCPF = new Integer(0);

		} else {

			decimoNumeroCPF = new Integer(11 - ( soma % 11 ));
		}

		soma = 0;

		peso = 11;

		for (int i = 0; i < noveDigitosIniciaisCPF.length(); i++) {

			soma += Integer.parseInt(noveDigitosIniciaisCPF.substring(i, i + 1)) * peso--;
		}

		soma += decimoNumeroCPF.intValue() * 2;

		if (soma % 11 == 0 | soma % 11 == 1) {

			decimoPrimeiroNumeroCPF = new Integer(0);

		} else {

			decimoPrimeiroNumeroCPF = new Integer(11 - ( soma % 11 ));
		}

		return decimoNumeroCPF.toString() + decimoPrimeiroNumeroCPF.toString();
	}

	/**
	 * Método responsável por validar um cpf parametrizado.
	 *
	 * @author marcosbuganeme
	 *
	 * @param cpf
	 *            - objeto que será validado.
	 * 
	 * @return <i>validação do cpf, true para cpf válido</i>.
	 */
	public static boolean validaCPF(final String cpf) {

		if (cpf.length() != 11) {

			return false;
		}

		final String numDig = cpf.substring(0, 9);

		return UtilCPF.calcularDigitosVerifacacao(numDig).equals(cpf.substring(9, 11));
	}
}
