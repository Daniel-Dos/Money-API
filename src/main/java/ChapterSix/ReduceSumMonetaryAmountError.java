package ChapterSix;

import java.util.Optional;
import java.util.stream.Stream;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryFunctions;

/**
 * @author Daniel Dias
 *
 */
public class ReduceSumMonetaryAmountError {
	public static void main(String[] args) {
		
		// caso tenha um moeda diferente no somatorio ele retornara um exceçaõ
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		
		MonetaryAmount money = Money.of(10, dollar);
		MonetaryAmount money2 = Money.of(10, dollar);
		MonetaryAmount money3 = Money.of(10, real);
		MonetaryAmount money4 = Money.of(10, dollar);
		MonetaryAmount money5 = Money.of(10, dollar);
		
		Optional<MonetaryAmount> result = Stream.of(money,money2,money3,money4,money5)
				.reduce(MonetaryFunctions.sum());
		
		result.ifPresent(System.out::println); // exceção
	}

}
