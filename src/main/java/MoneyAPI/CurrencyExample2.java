package MoneyAPI;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

/**
 * @author Daniel Dias
 *
 */
public class CurrencyExample2 {
	public static void main(String[] args) {
		
		/*
		 * Outra forma simples é utilizar a class "Locale",
		 * essa criação é muito interressante, por exemplo,
		 * em uma aplicaçao web de compras em que a partir do 
		 * "Locale" do request sera possivel saber qual é a moeda do 
		 * usuario que esta acessando a aplicação.
		 */
		
		CurrencyUnit currencyUnit = Monetary.getCurrency(Locale.US);
		String currencyCode = currencyUnit.getCurrencyCode();
		int numericCurrencyCode = currencyUnit.getNumericCode();
		int fractionDigits = currencyUnit.getDefaultFractionDigits();
		
		System.out.println("Exiindo os Resultados:");
		System.out.println("======================");
		System.out.println("Recuperando o codigo da Moeda :" + currencyCode);
		System.out.println("Recuperando o codigo Numerido :" + numericCurrencyCode);
		System.out.println("Recuperando o Numero de Digitos utilizado pela Moeda :" + fractionDigits);
		System.out.println("======================"); 
		
	

	}
}
