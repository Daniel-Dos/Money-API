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
 * <br>
 * <h2>Valor minimo e valor maximo</h2>
 * <br>
 * 
 * é possivel realizar a redução pelo valor maximo e minimo, por exemplo
 * dado uma lista é possivel retorna o mais ou o menor valor da lista.
 *
 */
public class ReduceMaxMinMonetaryAmount {
	public static void main(String[] args) {
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		
		MonetaryAmount money = Money.of(10, dollar);
		MonetaryAmount money2 = Money.of(10, dollar);
		MonetaryAmount money3 = Money.of(10, dollar);
		MonetaryAmount money4 = Money.of(10, dollar);
		MonetaryAmount money5 = Money.of(10, dollar);
		
		Optional<MonetaryAmount> max = Stream.of(money,money2,money3,money4,money5)
				.reduce(MonetaryFunctions.max()); // exceção
		max.ifPresent(System.out::println);
		
		Optional<MonetaryAmount> min = Stream.of(money,money2,money3,money4,money5)
				.reduce(MonetaryFunctions.min());
		min.ifPresent(System.out::println);
				
	}

}
