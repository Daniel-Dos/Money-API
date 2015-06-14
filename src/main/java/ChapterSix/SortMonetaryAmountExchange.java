package ChapterSix;

import java.util.List;
import java.util.stream.Collectors;
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
 * <br>
 *   <h2>Ordenação levando em consideração a cotação</h2>
 *   
 *   <br>
 *    Tambem é possivel realizar uma ordenção de forma crescente e descrescente levando em 
 *    consideração a contação da moeda. Para isso basta passar uma implementação de {@code ExchangeRateProvider}
 *    Por exemplo , dado uma lista com dez dolares , onze reais e nova euros, retornara de forma ascendete o valor de onze reais,
 *    dez dolares e nove euros , levando em consideração que pela cotação  o dolar é mais valioso que o real e menos que 
 *    valioso que o euro.
 *
 */
public class SortMonetaryAmountExchange {
	public static void main(String[] args) {
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit euro = Monetary.getCurrency("EUR");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		
		MonetaryAmount money = Money.of(9, euro);
		MonetaryAmount money2 = Money.of(10, dollar);
		MonetaryAmount money3 = Money.of(11,real);
		
		ExchangeRateProvider provider = 
				MonetaryConversions.getExchangeRateProvider(ExchangeRateType.IMF);
		
		List<MonetaryAmount> resultAsc = Stream.of(money, money2, money3)
				.sorted(MonetaryFunctions.sortValiable(provider)).collect(Collectors.toList());
		
		List<MonetaryAmount> resultDesc = Stream.of(money,money2,money3)
				.sorted(MonetaryFunctions.sortValiableDesc(provider)).collect(Collectors.toList());
		
		System.out.println("com Contação Ascendente : " + resultAsc +
				          "\nCom contação Descendemte :" + resultDesc);
		
	}

}
