package MoneyAPI;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;

/**
 * @author Daniel Dias
 * 
 * <h1>Opera�oes Aritmeticas</h1>
 * 
 * <br>
 * 
 * <p>
 * Com o <code>MonetaryAmount</code> � possivel realizar opera�oes como subtra�ao e soma,
 * salientando que as implementa�oes soa imutaveis, ou seja, o resultado resultara em uma nova
 *  instancia. Ao realizar opera�oes que recebam um <code>MonetaryAmount</code> o
 *  resultado sera tambem um <code>MonetaryAmount</code>, mas da implementa�a da instancia
 *  que chamou o metodo.
 * 
 * 
 * </p>
 *
 */
public class ArithmeticOperations {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		MonetaryAmount money  = Money.of(BigDecimal.TEN, currency);
		MonetaryAmount money2 = FastMoney.of(BigDecimal.TEN, currency);
		MonetaryAmount addResult = money.add(money2); // opera��o de soma
		MonetaryAmount subtractResult = money2.subtract(addResult); // opera�ao de subtra�ao
		
		System.out.println("Opera��o de Soma : " + addResult  );
		System.out.println("Opera��es de Subtra��o com a implementa�ao do FastMoney:" + subtractResult);
		
	}

}
