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
 * Tambem é possivel realizar operações de sinais com o <code>MonetaryAmount</code>
 */
public class ArithmeticOperations3 {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		MonetaryAmount money = Money.of(100, currency);
		MonetaryAmount negateResult = money.negate(); //Realiza a negação do montante monetário, ou seja, -this.
		MonetaryAmount plusResult = money.plus();
		
		System.out.println("Negação :" + negateResult);
		System.out.println("Positivo :" + plusResult);
	}

}
