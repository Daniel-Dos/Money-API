package ChapterFour;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.format.MonetaryAmountFormat;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.MonetaryAmountFormatSymbols;
import org.javamoney.moneta.format.MonetaryAmountSymbols;
import org.javamoney.moneta.spi.MoneyProducer;

/**
 * @author Daniel Dias
 * 
 * <br>
 * 
 * Tambem � possivel definir qual implementa��o que sera utilizada na serializa�ao de objeto. para isso existe a classe
 * funcional {@code MonetaryAmountProducer} , com ela � possivel definir sua propria implementa�ao a partir do number e da moeda.
 * O moneta por padrao ja vem com tres implementa�oes.
 * 
 * <ul>
 * 
 * <lli>{@code FastMoneyProducer} produtor de {@code MonetaryAmount} com a implementa�ao {@code FastMoney}</li>
 * <li>{@code MoneyProducer} produtor do {@code} MonetaryAmount com a implementa��o {@code Money}</li>
 * <li>{@code RoundedMoneyProducer} produtor de {@code MonetaryAmount} com a implementa��o {@code RoundedMoney}, nela � possivel
 *  passar um {@code MonetaryOperator} que sera utilizado na constru�ao dessa implementa�ao caso nao seja informado um operador de
 *  arredondamento sera utilizado o {@code MonetaryOperators.rounding()} . Lembrando que {@code MonetaryOperator} dentro da implementa�ao
 *  {@code RoundedMoney} , sera utilizado como agente arrendondador , ou seja , para casa opera��o esse operador sera chamado.
 * 
 * </ul>
 *
 */
public class MonetaryAmountFormatSymbolsExample3 {
	public static void main(String[] args) {
		
		MonetaryAmountSymbols symbols = new MonetaryAmountSymbols(Locale.US); // new MonetaryAmountSymbols();
		symbols.setCurrencySymbol("Mon");
		MonetaryAmountFormat formater = MonetaryAmountFormatSymbols.of(symbols, new MoneyProducer());
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		String text = formater.format(Money.of(10, currency));
		
		System.out.println("Primeira forma :" + text );
		teste();
		
		
	}
	
	
	 public static void teste() {
			
			// tambem � possivle passar uma String  como pattern para a formata�ao, esse
					// String segue o mesmo padrao da classe DecimalFormat
			
			MonetaryAmountSymbols symbols = new MonetaryAmountSymbols(Locale.US);
			symbols.setCurrencySymbol("Mon");
			MonetaryAmountFormat formater = MonetaryAmountFormatSymbols.of("� ###,###.00", symbols, new MoneyProducer());
			CurrencyUnit currency = Monetary.getCurrency("BRL");
			String text = formater.format(Money.of(10_000_00, currency));
			System.out.println("Segunda forma :" + text);
			
		}
	

}


	 
	
	 
 