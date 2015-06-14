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
 *  <br>
 *  
 *  <h2>Juntando as ordenaçoes </h2>
 *  
 *  Apenas como recordação. ja que esse recurso nao é da money-api e sim
 *  do Java 8, é possivel tambem misturar mais de um ordenador, para isso
 *  basta utilizar o metodo {@code thenComparing}. Basicamente ele faz a 
 *  ordenação e caso os valores tenham o mesmo peso, ao usar o compare o valor
 *  zero, ele usara o outro ordenador , assim a ordem que for definida o sort
 *  influcenciara no resultado da ordenação.
 *
 */
public class SortMixMonetaryAmountNumberCurrency {
	public static void main(String[] args) {
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit euro = Monetary.getCurrency("EUR");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		
		MonetaryAmount money = Money.of(10, euro);
		MonetaryAmount money2 = Money.of(10, dollar);
		MonetaryAmount money3 = Money.of(10, real);
		MonetaryAmount money4 = Money.of(9, real);
		MonetaryAmount money5 = Money.of(8, dollar);
		
		List<MonetaryAmount> resultAsc = Stream.of(money,money2,money3,money4,money5)
				.sorted(MonetaryFunctions
						.sortNumber().thenComparing(MonetaryFunctions.sortCurrencyUnit()))
						.collect(Collectors.toList());
		
		List<MonetaryAmount> resultDesc = Stream.of(money, money2,money3,money4,money5)
				.sorted(MonetaryFunctions
						.sortNumberDesc().thenComparing(MonetaryFunctions.sortCurrencyUnitDesc()))
						.collect(Collectors.toList());
		
		// Usingg currency first
		List<MonetaryAmount> resultCurrencyAsc = Stream.of(money,money2,money3,money4,money5)
				.sorted(MonetaryFunctions
						.sortCurrencyUnit().thenComparing(MonetaryFunctions.sortNumber()))
						.collect(Collectors.toList());
		
		List<MonetaryAmount> resultCurrencyDesc = Stream.of(money,money2,money3,money4,money5)
				.sorted(MonetaryFunctions
						.sortCurrencyUnitDesc().thenComparing(MonetaryFunctions.sortNumberDesc()))
						.collect(Collectors.toList());
		
		System.out.println("resultAsc : " + resultAsc +
				"\nresultDes : " + resultDesc +
				"\nresultCurrencyAsc : " + resultCurrencyAsc +
				"\nresultCurrencyDesc : " + resultCurrencyDesc);
	}

}
