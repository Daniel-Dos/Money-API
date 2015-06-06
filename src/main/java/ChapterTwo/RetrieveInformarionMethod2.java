package ChapterTwo;

import java.math.BigDecimal;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.NumberValue;

import org.javamoney.moneta.Money;

/**
 * @author Daniel Dias
 *
 *<br>
 *
 *  <blockquote>
 *  Al�m dissom com o <code>NumberValue</code> � possivel realizar mais algumas opera��es,
 *  por exemplo, � possivel definir qual desse ser� recuperada a partir do <code>NumberValue</code>
 *  ,desde que essa classe seja filha da classe <code>Number</code>. No caso da implementa��o
 *  de referencia serao todas as classes que sao <code>Number</code> e est�o dentro do JDK.
 *  
 *  
 *  
 *  </blockquote>
 */
public class RetrieveInformarionMethod2 {
	public static void main(String[] args) {
		
		MonetaryAmount money = Money.of(BigDecimal.valueOf(10.21), Monetary.getCurrency("BRL"));
		NumberValue number = money.getNumber();
		int precision = number.getPrecision();
		int scale = number.getScale();
		long amountFractionDenominator = number.getAmountFractionDenominator();
		long amountFractionNumerator = number.getAmountFractionNumerator();
		Class<?> numberType = number.getNumberType();//java.math.BigDecimal
		BigDecimal value = number.numberValue(BigDecimal.class);
		Integer interValue = number.numberValue(Integer.class);
		
		System.out.println("Precision : " + precision);
		System.out.println("Scale : " + scale);
		System.out.println("AmountFractionDenominator : " + amountFractionDenominator);
		System.out.println("AmountFractionNumerator : " + amountFractionNumerator);
		System.out.println("Number Type : " + numberType);
		System.out.println("Number Value BigDecimal : " + value);
		System.out.println("Number Value Integer :" + interValue);
	}
}
