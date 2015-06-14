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
 * 
 *   <h3>Realizando ordenaçao com o valor numerico</h3>
 *   
 *   A ordenação pelo valor numerico ignora a moeda e ordena apenas levando em consideraçaõ
 *   o valor monetario , vale salientar que esse ordençao nao realiza cotaçao de valores ,
 *   em outraas palavras , o valor de dez reais terá o mesmo valor que dez dolares.
 *   Tambem é possivel retornar de forma ascendente e descendete.
 *
 */
public class SortMonetaryAmountNumber {
	public static void main(String[] args) {
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit euro = Monetary.getCurrency("EUR");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		
		MonetaryAmount money = Money.of(9, euro);
		MonetaryAmount money2 = Money.of(10, dollar);
		MonetaryAmount money3 = Money.of(11, real);
		
		List<MonetaryAmount> resultAsc = Stream.of(money, money2,money3)
				.sorted(MonetaryFunctions
						.sortNumber()).collect(Collectors.toList());
		
		List<MonetaryAmount> resultDesc = Stream.of(money,money2,money3)
				.sorted(MonetaryFunctions
						.sortNumberDesc()).collect(Collectors.toList());
		
		System.out.println("Ordenação Numerica Ascesdente :" + resultAsc +
				"\nOrdenaçãoo Numerica Descendente :" + resultDesc);
	}

}
