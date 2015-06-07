package ChapterThree;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryOperator;

import org.javamoney.moneta.FastMoney;

/**
 * @author Daniel Dias
 * 
 * <h3>MonetaryOperator</h3>
 * 
 * <br>
 * O {@code MonetaryOperator} é uma interface funcional que recebe um
 * {@code MonetaryAmount}. Essa interface é muito discutida ao se falar
 * sobre a implementação do {@code RoundedMoney} que a utiliza como agente
 * arredondador.Com essa interface é possivel realizar operaçoes de arredondamento,
 * retornar parte do dinheiro, o dobro do valor,etc.
 *
 */
public class MonetaryOperatorExamples {
	public static void main(String[] args) {
		
		MonetaryOperator doubleOperator = m -> m.multiply(2);
		MonetaryOperator halfOperator = m -> m.divide(2);
		
		MonetaryOperator operator = m -> {
			
			if(m.isPositive()) {
				return m.multiply(2);
			}
			return m.divide(2);
		};
		
		/* para executa-lo basta chamr o metodo apply da interface ou chamar o metodo
		 * with dentro MonetaryAmount*/
		
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		MonetaryAmount money = FastMoney.of(10, currency);
		MonetaryAmount result = doubleOperator.apply(money);
		MonetaryAmount result2 = result.with(doubleOperator);
		
		System.out.println("Resultado 1 :" + result +
				"\nResultado 2 : " + result2);
		
		
	}

}
