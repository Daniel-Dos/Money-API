package ChapterThree;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryOperator;

import org.javamoney.moneta.FastMoney;

/**
 * @author Daniel Dias
 *
 */
public class HelloMonetaryOperator {
	public static void main(String[] args) {
		
		//exibindo as informaçes do MonetaryOperator
		
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		MonetaryAmount money = FastMoney.of(10, currency);
		MonetaryOperator doubleOperator = m -> m.multiply(2); 
		MonetaryAmount result = doubleOperator.apply(money);
		MonetaryAmount result2 = result.with(doubleOperator);
		
		System.out.println("Resultado 1 :" + result +
				"\nResultado 2 : " + result2);
	}

}
