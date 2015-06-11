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
 * Caso seja necessario configurar as informaçes como quantidade minima,
 * moeda,etc. Exitem duas classes:
 * <br />
 * 
 * <ul>
 *   <li>a primeira é a {@code MonetaryAmountSybomls} com ela é possivel definir
 *   os simbolos que serao utilizados por exemplo, simbolo da moeda,separador,etc.</li>
 *   
 *   <li>A classe {@code MonetaryAmountNumericInformation} cuidara das informaçoes com
 *   relação a formataçaõ do valor numerico , por exemplo, o numero minimo e maximo
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
