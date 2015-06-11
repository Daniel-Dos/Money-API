package ChapterFive;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryOperator;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.function.MonetaryOperators;

/**
 * @author Daniel Dias
 * 
 * <br> 
 * 
 * <h2>Ignorando a contação</h2>
 * 
 * Em alguns momentos é necessrio realizar uma troca de moeda
 * sem realizar cotaçao, para isso existe o metodo exchange dentro
 * {@code MonetaryOperator}
 *
 */
public class ExchangeRateProviderExamples5 {
	public static void main(String[] args) {
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		
		MonetaryAmount money = FastMoney.of(10, dollar);
		MonetaryAmount money2 = FastMoney.of(10, real);
		
		MonetaryOperator operator = MonetaryOperators.exchange(dollar);
		MonetaryAmount result = money2.with(operator).add(money);
		
		
		
		
		
		System.out.println(result);
	}

}
