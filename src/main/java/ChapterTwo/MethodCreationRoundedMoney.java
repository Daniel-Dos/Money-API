package ChapterTwo;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.RoundedMoney;

/**
 * @author Daniel Dias <br>
 * 
 *         <blockquote> RoundedMoney: assim como a implementa�ao Money,
 *         representa o valor numerico com o BigDecimal, a diferen�a entre eles
 *         � que com o RoundedMoney � possivel receber um MonetaryOperator para
 *         ser chamada a cada opera�ao, por exemplo, a cada opera�ao aritimetica
 *         realizar uma opera�ao de arredondamento. </blockquote>
 *
 */
public class MethodCreationRoundedMoney {
	public static void main(String[] args) {
		
		CurrencyUnit currenct = Monetary.getCurrency("BRL");
		MonetaryAmount money = RoundedMoney.of(BigDecimal.TEN,currenct);
		MonetaryAmount zero = RoundedMoney.zero(currenct); 
		MonetaryAmount moneyFromCurrencyCode = RoundedMoney.of(10, "USD");
		MonetaryAmount moneyFromCents = RoundedMoney.ofMinor(currenct,100_00);
		
		System.out.println("usando Roundmoney :" + money);
		System.out.println("usando roundedMoney :" + moneyFromCurrencyCode);
	}

}
