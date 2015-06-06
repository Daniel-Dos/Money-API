package ChapterTwo;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

/**
 * @author Daniel Dias
 *
 * <br>
 *         <p>
 *         <blockquote> Com o <code>MonetaryAmount</code> � possivel realizar
 *         compara�oes em rela�oes a outros <code>MonetaryAmount</code>, com ele
 *         � possivel, por exemplo, verificar se um dinheiro � maior, menor ou
 *         igual ao outro. </blockquote>
 *         </p>
 *         
 *         
 */
public class BooleanOperations {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		MonetaryAmount money = Money.of(10, currency);
		MonetaryAmount money2 = Money.of(20,currency);
		
		//Opera��es
		boolean equalsToResult = money.isEqualTo(money2); // retorna verdadeiro caso a instancia � igual ao valor monetario passado no parametro.
		boolean greaterThan = money.isGreaterThan(money2); // Retorna verdadeiro se a instancia � maior que o valor passado.
		boolean greaterThanOrEqualTo = money.isGreaterThanOrEqualTo(money2);// caso sejam iguais, retorna verdadeiro.
		boolean lessThan = money.isLessThan(money2);  // retorna verdadeiro se a instancia � menor que o valor passado.
		boolean lessThanOrEqualTo = money.isLessThanOrEqualTo(money2); // retorna verdadeiro se a instancia � menor ou igual que o valor passado.
		boolean negative = money.isNegative(); // retorna verdadeiro se negativo
		boolean negativeOrZero = money.isNegativeOrZero(); // retorna verdadeiro se � negativo ou zero.
		boolean positive = money.isPositive(); // retorna verdadeiro se � posivivo
		boolean positiveOrZero = money.isPositiveOrZero(); // retorna veradeiro se positivo ou igual a zero.
		boolean zero = money.isZero(); // verfica se o valor do dinheiro � zero.
		
		System.out.println("isEqualTo :" + equalsToResult + 
				           "\nisGreaterThan :" + greaterThan +
				            "\nisGreaterThanOrEqualTo :" + greaterThanOrEqualTo +
				             "\nisLessThan :" + lessThan +
				             "\nisLessThanOrEqualTo :" + lessThanOrEqualTo +
				             "\nisNegative :" + negative +
				             "\nisNegativeOrZero :" + negativeOrZero +
				             "\nisPositive :" + positive +
				             "\nisPositiveOrZero :" + positiveOrZero +
				             "\nisZero :" + zero);
		
		
		
	}

}
