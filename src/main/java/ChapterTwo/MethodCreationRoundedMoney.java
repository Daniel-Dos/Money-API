package ChapterTwo;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.RoundedMoney;

/**
 * @author Daniel Dias <br>
 * 
 *         <blockquote> RoundedMoney: assim como a implementaçao Money,
 *         representa o valor numerico com o BigDecimal, a diferença entre eles
 *         é que com o RoundedMoney é possivel receber um MonetaryOperator para
 *         ser chamada a cada operaçao, por exemplo, a cada operaçao aritimetica
 *         realizar uma operaçao de arredondamento. </blockquote>
 *
 */
public class MethodCreationRoundedMoney {
	public static void main(String[] args) {
		
		CurrencyUnit currenct = Monetary.getCurrency("BRL");
		MonetaryAmount money = RoundedMoney.of(BigDecimal.TEN,currenct);
		//MonetaryAmount zero = RoundedMoney.zero(currenct); nao funciona
		MonetaryAmount moneyFromCurrencyCode = RoundedMoney.of(10, "USD");
		//MonetaryAmount moneyFromCents = RoundedMoney.ofMinor(currenct); nao funciona
		
		System.out.println("usando Roundmoney :" + money);
		System.out.println("usando roundedMoney :" + moneyFromCurrencyCode);
	}

}
