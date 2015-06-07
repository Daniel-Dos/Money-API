package ChapterTwo;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryOperator;

import org.javamoney.moneta.RoundedMoney;
import org.javamoney.moneta.function.MonetaryOperators;



/**
 * @author Daniel Dias
 *
 * <h1>Metodos de cria�ao para o RoundedMoney</h1>
 * 
 * <br>
 * 
 * <p>
 *   Alem dos metodos comuns de constru�ao a classe 
 *   <code>RoundedMoney</code> , possui outras formas de 
 *   parametros para que seja possivel informar o <code>MonetaryOperator</code>
 *   para  ser executado apos cada opera�ao do <code>MonetaryAmount</code>, vale
 *   lembrar , a principal caracteristica dessa classe � realizar esse tipo de 
 *   opera�ao, caso nao seja necessario, outra implementa�ao � recomendada.
 * 
 * </p>
 */
public class RoundedMoneyCreation2 {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		MonetaryAmount money = RoundedMoney.of(BigDecimal.TEN, currency, MonetaryOperators.rounding()); //BRL 10
		MonetaryAmount zero = RoundedMoney.zero(currency);//BRL 0
		MonetaryAmount moneyFromCurrencyCode = RoundedMoney.of(10, "USD");//USD 10
		MonetaryAmount moneyFromCents = RoundedMoney.ofMinor(currency, 100_00);//BRL 10
	}

}
