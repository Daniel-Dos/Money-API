package MoneyAPI;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

/**
 * @author Daniel Dias
 * 
 * Para as Opera�oes de multiplica�ao, divisao e resto 
 * � necessario passar um parametro do tipo <code>Number</code>
 *
 */
public class AritmeticOperations2 {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		MonetaryAmount money = Money.of(100, currency);
		Number number = 20 ;
		MonetaryAmount divideResult = money.divide(number);
		MonetaryAmount remainderResult = money.remainder(30);
		MonetaryAmount resultMultiply = money.multiply(5);
		
		System.out.println("Divis�o :" + divideResult);
		System.out.println("Resto :" + remainderResult);
		System.out.println("Multiplica��o :" + resultMultiply);
		
		
	}

}
