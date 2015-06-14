package ChapterSix;

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
 *  <h2>Predicates</h2>
 *  <br>
 *  
 *  Operação de predicate é quando dado uma entrada o retorno é um valor
 *  boolean, ou seja, verdadeiro ou falso. dentro do Stream o predicate pode ser
 *  utilizado como filtragem, filtrar por uma moeda especifica , ou para mathc, verificar
 *  se existe algum elemento da lista ou todo batm com a condiçao.
 *
 */
public class BooleanMonetaryAmount {
	public static void main(String[] args) {
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		
		MonetaryAmount money =  Money.of(10, dollar);
		MonetaryAmount money2 = Money.of(10, real);
		MonetaryAmount money3 = Money.of(10, dollar);
		MonetaryAmount money4 = Money.of(9, real);
		MonetaryAmount money5 = Money.of(8, dollar);
		
		Stream<MonetaryAmount> justDollars = Stream.of(money,money2,money3,money4,money5)
				.filter(MonetaryFunctions.isCurrency(dollar));
		
		boolean anyMatch = Stream.of(money,money2,money3,money4,money5)
				.anyMatch(MonetaryFunctions.isCurrency(dollar)); // true
		
		boolean allMatch = Stream.of(money,money2,money3,money4,money5)
				.allMatch(MonetaryFunctions.isCurrency(dollar)); // true
		
		System.out.println("justDollars :" + justDollars +
				"\nanyMatch :" + anyMatch +
				"\nallMatch :" + allMatch);
	}

}

