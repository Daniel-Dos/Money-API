package ChapterFour;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.CurrencyStyle;

/**
 * @author Daniel Dias
 * 
 * Outra forma
 *
 */
public class MonetaryFormatExempleQuery {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("USD");
		MonetaryAmount money  = Money.of(12, currency);
		
		MonetaryAmountFormat format = MonetaryFormats
				.getAmountFormat(AmountFormatQueryBuilder.of(Locale.US).set(CurrencyStyle.SYMBOL).build());
		
		String resultText = format.format(money);
		
		System.out.println(resultText);
	}

}
