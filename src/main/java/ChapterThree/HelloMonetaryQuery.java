package ChapterThree;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryQuery;

import org.javamoney.moneta.FastMoney;

/**
 * @author Daniel Dias
 *
 */
public class HelloMonetaryQuery {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		MonetaryAmount money = FastMoney.of(10, currency);
		MonetaryQuery<String> currencyCodeQuery = m -> m.getCurrency().getCurrencyCode();
		String result = currencyCodeQuery.queryFrom(money);
		String result2 = money.query(currencyCodeQuery);
		
		System.out.println("queryFrom :" + result + "\nquery :" + result2);
	}

}
