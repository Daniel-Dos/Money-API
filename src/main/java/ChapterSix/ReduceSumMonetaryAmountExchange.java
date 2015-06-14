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
 */
public class ReduceSumMonetaryAmountExchange {
	public static void main(String[] args) {
		
		// Caso seja necessario somar e converter para um especifica moeda,
		//o moneta das suporte para isso , basta informar uma implementação
		//de ExchangeRateProvider e tambem a moeda que todos os valoes serao convertidos.
		
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		ExchangeRateProvider  provider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.IMF);
		
		MonetaryAmount money = Money.of(10, dollar);
		MonetaryAmount money2 = Money.of(10,dollar);
		MonetaryAmount money3 = Money.of(10, real);
		MonetaryAmount money4 = Money.of(9, dollar);
		MonetaryAmount money5 = Money.of(8, dollar);
		
		Optional<MonetaryAmount> result = Stream.of(money,money2,money3,money4,money5)
				.reduce(MonetaryFunctions.sum(provider,dollar)); // exceçaõ 
		result.ifPresent(System.out::println);
	}

}
