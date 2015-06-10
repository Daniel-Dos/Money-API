package ChapterThree;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryQueries;

/**
 * @author Daniel Dias
 *
 *<br>
 *  
 *  O moneta traz por padão algumas implementaçoes de {@code MonetaryQuery} , a classe
 *  {@code MonetaryQueries}. Ela é uma classe utilitaria que traz algumas funcionalidades
 *  importantes e algumas vezes muito corriqueira dentro da vida de um desenvolvedor Java, como:
 *  
 *  <ul>
 *    <li>MonetaryQuery extractPart() - recupera a maior parte de um dinheiro, por exemplo EUR 2.35 retorna 2.</li>
 *    <li>MonetaryQuery convertMinorPart() - recupera o valor monetario , o convertendo para a menor parte, centavos de um 
 *    dinheiro, por exemplo USD 2.35 será retornado 235. </li>
 *  </ul>
 */
public class MonetaryQueriesExample {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency(Locale.US);
		
		MonetaryAmount money = Money.of(120.23, currency);
		Long moneyInCents = money.query(MonetaryQueries.convertMinorPart());
		Long majorPart = money.query(MonetaryQueries.extractMajorPart());
		Long minorPart = money.query(MonetaryQueries.extractMinorPart());
		
		System.out.println("convertMinorPart() : " + moneyInCents +
				           "\nextractMajorPart() :" + majorPart +
				            "\nextractMinorPart() : " + minorPart);
	}

}
