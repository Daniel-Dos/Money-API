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
 * <h1>Operaçoes Aritmeticas</h1>
 * 
 * <br>
 * 
 * <p>
 * Com o <code>MonetaryAmount</code> é possivel realizar operaçoes como subtraçao e soma,
 * salientando que as implementaçoes soa imutaveis, ou seja, o resultado resultara em uma nova
 *  instancia. Ao realizar operaçoes que recebam um <code>MonetaryAmount</code> o
 *  resultado sera tambem um <code>MonetaryAmount</code>, mas da implementaça da instancia
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
		MonetaryAmount addResult = money.add(money2); // operação de soma
		MonetaryAmount subtractResult = money2.subtract(addResult); // operaçao de subtraçao
		
		System.out.println("Operação de Soma : " + addResult  );
		System.out.println("Operações de Subtração com a implementaçao do FastMoney:" + subtractResult);
		
	}

}
