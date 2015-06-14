package ChapterSix;

import java.util.Optional;
import java.util.stream.Stream;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.convert.ExchangeRateType;
import org.javamoney.moneta.function.MonetaryFunctions;

/**
 * @author Daniel Dias
 * 
 *  caso sej a realizado a operaçao de minimo e maximo com moedas diferentes,
 *  acontecear uma exceça, e possivel passar um {@code ExchangeRateProvider} para 
 *  realizar a conversao e entao a comparaççao.
 *
 */
public class ReduceMaxMinMonetaryAmountExchange {
	public static void main(String[] args) {
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit euro = Monetary.getCurrency("EUR");
		ExchangeRateProvider provider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.IMF);
		
		MonetaryAmount money = Money.of(10, dollar);
		MonetaryAmount money2 = Money.of(10, euro);
		MonetaryAmount money3 = Money.of(10, dollar);
		MonetaryAmount money4 = Money.of(9, euro);
		MonetaryAmount money5 = Money.of(8 , dollar);
		
		Optional<MonetaryAmount> max = Stream.of(money,money2,money3,money4,money5)
				.reduce(MonetaryFunctions.max(provider)); // exceçao
		max.ifPresent(System.out::println);
		
		Optional<MonetaryAmount> min = Stream.of(money,money2,money3,money4,money5)
				.reduce(MonetaryFunctions.max(provider));
		min.ifPresent(System.out::println);
		
		
	}

}
