package ChapterFour;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.format.MonetaryAmountFormat;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.MonetaryAmountFormatSymbols;

/**
 * @author Daniel Dias
 * 
 * <br>
 * 
 * <h2>MonetaryAmountFormatSymbols</h2>
 * 
 * <br>
 * 
 * Existe tambem a interface {@code MonetaryAmountFormatSymbols}, que de forma semelhante a classe
 * {@code DecimalFormat} com a classe {@docRoot Number}, tem o objetivo de realizar formataçoes
 * do dinheiro a partir de configuraçoes de simbolos, moedas, quantidade minima e maxima de digitos antes 
 * e depois da virgula , etc.
 *
 */
public class MonetaryAmountFormatsSymbolsExample {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		MonetaryAmount money = Money.of(12, currency);
		MonetaryAmountFormat defafult = MonetaryAmountFormatSymbols.getDefafult();
		String format = defafult.format(money);
		MonetaryAmount moneyParsed = Money.parse(format , defafult); // or using defafult.parse(format);
		
		System.out.println("fomrat = defafult : " + format +
				"\nmoneyPersed : " + moneyParsed);
	}

}
