package ChapterFour;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.MonetaryAmountFormatSymbols;
import org.javamoney.moneta.format.MonetaryAmountNumericInformation;
import org.javamoney.moneta.format.MonetaryAmountSymbols;


/**
 * @author Daniel Dias
 * <br>
 * 
 * <br/>
 * 
 * Caso seja necessario configurar as informa�es como quantidade minima,
 * moeda,etc. Exitem duas classes:
 * <br />
 * 
 * <ul>
 *   <li>a primeira � a {@code MonetaryAmountSybomls} com ela � possivel definir
 *   os simbolos que serao utilizados por exemplo, simbolo da moeda,separador,etc.</li>
 *   
 *   <li>A classe {@code MonetaryAmountNumericInformation} cuidara das informa�oes com
 *   rela��o a formata�a� do valor numerico , por exemplo, o numero minimo e maximo
 *   de digitos antes e depos da virgula.</li>
 * 
 * </ul>
 * 
 * <br>
 * 
 * 
 *
 */
public class MonetaryAmountFormatSymbolsExample2 {
	public static void main(String[] args) {
		
		MonetaryAmountFormatSymbols defafult = MonetaryAmountFormatSymbols.getDefafult();
		MonetaryAmountSymbols amountSymbols = defafult.getAmountSymbols();
		MonetaryAmountNumericInformation numericInformation = defafult.getNumericInformation();
		
		
		
		
	}

}
