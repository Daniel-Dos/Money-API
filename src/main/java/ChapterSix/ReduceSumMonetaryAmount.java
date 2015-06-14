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
 *  <br>
 *   <h2>Metodos de redução </h2>
 *     
 *      <br>
 *      A redução e´o processo em que , dado uma lista de valores ele devera
 *      retornar uma ou nenhuma saida, basicamente ,a partir de uma lista transforma-lo para apenas um
 *      elemento ou a usencia dele.
 *      
 *      <br>
 *      <h2>Somatorio</h2>
 *      A soma ou reduçã pela soma é definido em : dado um lista de {@code MonetaryAmount} ele
 *      retornara um elemento com o somatorio desses valores.
 */
public class ReduceSumMonetaryAmount {
	public static void main(String[] args) {
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		
		MonetaryAmount money = Money.of(10, dollar);
		MonetaryAmount money2 = Money.of(10, dollar);
		MonetaryAmount money3 = Money.of(10, dollar);
		MonetaryAmount money4 = Money.of(10, dollar);
		MonetaryAmount money5 = Money.of(10, dollar);
		
		Optional<MonetaryAmount> result  = Stream.of(money,money2,money3,money4,money5).reduce(MonetaryFunctions.sum());	
		result.ifPresent(System.out:: println); // :: referencia a metodos
	}

}
