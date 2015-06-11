package ChapterFour;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.RoundedMoney;
import org.javamoney.moneta.function.MonetaryOperators;

/**
 * @author Daniel Dias
 *
 *<br>
 *   
 *   <h2>Formatando Dinheiro</h2>
 *   <br>
 *   
 *   A intera��o como o usuario na maioria dos software � uma parte fundamental, assim � necessario
 *   pensar na forma de apresentar a informa��o para o usuario alem da intera�ao com o software. O 
 *   dinheiro� uma parte importante desses softwares, assim � importante exibir o total gasto por um 
 *   servi�o ou o somatorio de produtos que o usuario deseja comprar. Sem falar na forma de intera��o,
 *   por exemplo , informar o dinhiero que sera transferido por uma outra conta via internet baking.
 *   Para trabalhar com a formata��o de um  {@code MonetaryAmount}  existe a interface  {@code MonetaryFormat}
 *   que basicamente expoe o {@code MonetaryAmount} como {@code String} e recupera um  {@code MonetaryAmount} 
 *   a partir de uma {@code String} .
 *   
 *   <br>
 *   
 *   {@code public interface MonetaryAmountFormat extends MonetaryQuery<String>{
 *    
 *     AmountFormatContext getContext();
 *     
 *     default String format(MonetaryAmount amount){...}
 *     
 *     void print(Appendable appendable, MonetaryAmount amount) throws IOException;
 *     
 *     MonetaryAmount parse(CharSequence text) throws MonetaryParseException;
 *     
 *   }}
 *   
 *   
 *   
 *   
 */
public class ToStringExample {
	public static void main(String[] args) {
		
		// Um exemplo simples � o toString e o parse dentro
		// das implementa��es do MonetaryAmount dentro do moneta
		
		CurrencyUnit currency = Monetary.getCurrency(Locale.US);
		MonetaryAmount money = Money.of(10, currency);
		MonetaryAmount money2 = FastMoney.of(20, currency);
		MonetaryAmount money3 = RoundedMoney.of(30, currency, MonetaryOperators.rounding());
		String text = money.toString();
		String text2 = money2.toString();
		String text3 = money3.toString();
		MonetaryAmount result = Money.parse(text);
		MonetaryAmount result2 = FastMoney.parse(text2);
		MonetaryAmount result3 = RoundedMoney.parse(text3);
		
		System.out.println("text :" + text +
				"\ntext2 :" + text2 +
				"\ntext3 :" + text3);
		
		System.out.println();
		
		System.out.println("result :" + result +
				"\nresult2 : " + result2 +
				"\nresult3 :" + result3);
	}

}
