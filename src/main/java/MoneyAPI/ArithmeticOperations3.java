package MoneyAPI;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

/**
 * @author Daniel Dias
 *
 *<br>
 *
 * Tambem � possivel realizar opera��es de sinais com o <code>MonetaryAmount</code>
 */
public class ArithmeticOperations3 {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		MonetaryAmount money = Money.of(100, currency);
		MonetaryAmount negateResult = money.negate(); //Realiza a nega��o do montante monet�rio, ou seja, -this.
		MonetaryAmount plusResult = money.plus();
		
		System.out.println("Nega��o :" + negateResult);
		System.out.println("Positivo :" + plusResult);
	}

}
