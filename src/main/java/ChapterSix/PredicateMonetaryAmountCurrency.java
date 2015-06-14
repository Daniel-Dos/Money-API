package ChapterSix;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryFunctions;

/**
 * @author Daniel Dias
 * 
 * <br>
 *   <h2>Predicate com moedas</h2>
 *   
 *   <br>
 *   Com o moneta é possivel realizar predicate a partir da moeda, usando o inclusive e o exclusive. Ambos utilizam varargs
 *   ou seja , é possivel adicionar n elementos na condição:
 *   
 *   <ul>
 *     <li>{@code isCurrency(CurrencyUnit... currencies)} : retorna verdadeiro caso o MonetaryAmount tenha a uma das moedas
 *     especificadas </li>
 *     
 *     <li>{@code filterByExcludingCurrency(CurrencyUnit... currencies)} : Retorna verdadeiro caso o MonetaryAmount
 *     nao tenha nenhuma das moedas especificadas.</li>
 *    
 *   </ul>
 *
 */
public class PredicateMonetaryAmountCurrency {
	public static void main(String[] args) {
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit real  = Monetary.getCurrency("BRL");
		CurrencyUnit euro = Monetary.getCurrency("EUR");
		
		MonetaryAmount money = Money.of(10, dollar);
		MonetaryAmount money2 = Money.of(10, real);
		MonetaryAmount money3 = Money.of(10, dollar);
		MonetaryAmount money4 = Money.of(9, real);
		MonetaryAmount money5 = Money.of(8, dollar);
		
		List<MonetaryAmount> justDollar = Stream.of(money,money2,money3,money4,money5)
				.filter(MonetaryFunctions.isCurrency(dollar)).collect(Collectors.toList());
		
		boolean anyDollar = Stream.of(money,money2,money3,money4,money5)
				.anyMatch(MonetaryFunctions.isCurrency(dollar));
		
		boolean allDollar = Stream.of(money,money2,money3,money4,money5)
				.allMatch(MonetaryFunctions.isCurrency(dollar));
		
		List<MonetaryAmount> notDollar = Stream.of(money,money2,money3,money4,money5)
				.filter(MonetaryFunctions.filterByExcludingCurrency(dollar)).collect(Collectors.toList());
		
		boolean anyMatch = Stream.of(money,money2,money3,money4,money5)
				.anyMatch(MonetaryFunctions.filterByExcludingCurrency(euro));
		
		boolean allMatch = Stream.of(money,money2,money3,money4,money5)
				.allMatch(MonetaryFunctions.filterByExcludingCurrency(euro));
		
		System.out.println("justDollar : " + justDollar +
				"\nanyDollar : " + anyDollar +
				"\nallDollar : " + allDollar +
				"\notDollar : " + notDollar +
				"\nanyMatch : " + anyMatch +
				"\nallMatch : " + allMatch);
				
	}

}
