package ChapterSix;

import java.math.BigDecimal;
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
 * <br>
 * 
 * <h2> predicate com o valor numerico</h2>
 * <br>
 * 
 * alem de operaçoes com moeda é possivel realizar condiçoes com valor
 * numerico do {@code MonetaryAmount}. os metodos tem o mesmo comportamento
 * da interface do {@code MonetaryAmount} :
 * 
 * <ul>
 *   <li>{@code MonetaryFunctions.isLessThanOrEqualTo(monetaryAmount)}</li>
 *   <li>{@code MonetaryFunctions.isLessThan(moneraryAmount)}</li>
 *   <li>{@code MonetaryFunctions.isGreaterThanOrEqualTo(monetaryAmount)}</li>
 *   <li>{@code MonetaryFunctions.isGraeterThan(monetaryAmount)}</li>
 *   <li>{@code isBetween(MonetaryAmount min, MonetaryAmount max)}</li>
 * 
 * </ul>
 *
 */
public class PredicateMonetaryAmountNumberValue {
	public static void main(String[] args) {
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		
		MonetaryAmount money = Money.of(10, dollar);
		MonetaryAmount money2 = Money.of(10, dollar);
		MonetaryAmount money3 = Money.of(10, dollar);
		MonetaryAmount money4 = Money.of(9, dollar);
		MonetaryAmount money5 = Money.of(8, dollar);
		
		List<MonetaryAmount> greaterThanZero = Stream.of(money,money2,money3,money4,money5)
				.filter(MonetaryFunctions.isGreaterThan(Money.zero(dollar)))
				.collect(Collectors.toList());
		
		boolean hasAnyGreaterThanZero = Stream.of(money,money2,money3,money4,money5)
				.anyMatch(MonetaryFunctions.isGreaterThan(Money.zero(dollar)));
		
		boolean allBetweenAntTen = Stream.of(money,money2,money3,money4,money5)
				.allMatch(MonetaryFunctions.isBetween(Money.zero(dollar), Money.of(BigDecimal.TEN, dollar)));
		
		System.out.println("greaterThanZero : " + greaterThanZero +
				"\nhasAnyGreaterThanZero : " + hasAnyGreaterThanZero +
				"\nallBetweenAntTen : " + allBetweenAntTen);
		
	}

}
