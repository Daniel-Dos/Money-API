package MoneyAPI;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

/**
 * @author Daniel Dias
 * <br>
 * Testendo a Api money e Currency 
 * 
 *
 
<br> <br>

 * String getCurrencyCode()<br>
 * 
 * Retorna o código da moeda, para as moedas que seguem o ISO isso serão
 * retornado tres letras
 * 
 * <br>
 * exemplo : BRL par o real brasileiro USD para dolares amaericanos
 * 
 * <br>
 * int getNumericCode()
 * 
 * <br>
 * Retorna o codigo numerico da moeda , assim como o codigo eles possui tres
 * digitos
 * 
 * <br>
 * exemplo : 986 para moeda brasileira 840 para americano
 * 
 * <br>
 * int getDefaultFractionDigits() <br>
 * 
 * Retorna o numero de digitos normalmente utilzado pela moeda exemplo : BRL tem
 * dois JPY não tem.
 */

public class CurrencyExample1 {
	
	public static void main(String[] args) {
		
		/*
		 * Implementação MONETA, com ela é possivel criar 
		 * uma instancia de moedas de duas formas.
		 */
		
		CurrencyUnit currencyUnit = Monetary.getCurrency("BRL"); // recupera o tipo da moeda : USD, BRL, JPY, EUR,etc
		String currencyCode = currencyUnit.getCurrencyCode(); // Retorna o código da moeda
		int numericCurrencyCode = currencyUnit.getNumericCode(); // Retorna o Codigo Numerico da moeda
		int fractionDigits = currencyUnit.getDefaultFractionDigits(); // Retorna o numero de digitos utilizado pela moeda.
		
		System.out.println("Exiindo os Resultados:");
		System.out.println("======================");
		System.out.println("Recuperando o codigo da Moeda :" + currencyCode);
		System.out.println("Recuperando o codigo Numerido :" + numericCurrencyCode);
		System.out.println("Recuperando o Numero de Digitos utilizado pela Moeda :" + fractionDigits);
		System.out.println("======================"); 
		
	}

}
