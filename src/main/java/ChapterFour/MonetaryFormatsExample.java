package ChapterFour;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.Money;

/**
 * @author Daniel Dias
 * 
 * <br>
 * 
 * <h2>MonetaryAmountFormat</h2>
 * 
 * <br>
 * 
 * A implementação de referencia tem duas formas de criar formatador para dinheiro.
 * A primeira opção é com a classe , {@code MonetaryFormats} com ela é possivel criar
 * formatador a partir de uma query builder ou utilizando apenas pelo {@code Locale} . Alem
 * do parse sem parametro nas implementaçoes do {@code MoneraryAmount}, tambem existe o 
 * metodo pare que aceita o {@code MonetaryAmountFormat}.
 *
 */
public class MonetaryFormatsExample {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("EUR");
		MonetaryAmount money = Money.of(12, currency);
		
		MonetaryAmountFormat  format =  MonetaryFormats.getAmountFormat(Locale.US);
		
		String resultText = format.format(money); // EUR 12
		MonetaryAmount monetaryAmount = format.parse(resultText);
		MonetaryAmount result2 = Money.parse(resultText , format);
		
		System.out.println("money :" + money +
				"\nresultText :" + resultText + 
				"\nmonetaryAmount :" + monetaryAmount +
				"\nresult2 : " + result2); 
		
		
		
	}

}
