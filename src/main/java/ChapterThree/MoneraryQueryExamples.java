package ChapterThree;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryQuery;

import org.javamoney.moneta.Money;

/**
 * @author Daniel Dias
 * 
 * <br>
 * <h3>MonetaryQuery</h3>
 * 
 * <br>
 * 
 * O {@code MonetaryQuery} semelhante ao {@code MonetaryOperator} é uma interface funcional que recebe
 * um {@code MonetaryOperator} , a sua diferença esta no retorno, ele pode retornar qualquer tipo de objeto a partir
 *  do generics. Com o {@code MonetaryQuery} é possivel recuperar algumas informaçoes no {@code MonetaryAmount},
 *  por exemplo, o codigo da moeda, apenas o numero no formato {@link long} ou em {@link BigDecimal}
 *  
 *
 */
public class MoneraryQueryExamples {
	public static void main(String[] args) {
		
		MonetaryQuery<Long> longQuery = m -> m.getNumber().longValue(); // recupera numero
		MonetaryQuery<String> currencyCodeQuery = m -> m.getCurrency().getCurrencyCode(); // recupera o codigo da moeda
		MonetaryQuery<Integer> fractionDigits = m -> m.getCurrency().getDefaultFractionDigits(); // recupera o digito fracionado
		
		// para executando
		
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		MonetaryAmount money = Money.of(10, currency);
		Long result = longQuery.queryFrom(money);
		String result2= currencyCodeQuery.queryFrom(money);
		Integer result3 = fractionDigits.queryFrom(money);
		
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
		
	}

}
