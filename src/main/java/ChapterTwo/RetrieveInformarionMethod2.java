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
 *  Além dissom com o <code>NumberValue</code> é possivel realizar mais algumas operações,
 *  por exemplo, é possivel definir qual desse será recuperada a partir do <code>NumberValue</code>
 *  ,desde que essa classe seja filha da classe <code>Number</code>. No caso da implementação
 *  de referencia serao todas as classes que sao <code>Number</code> e estão dentro do JDK.
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
