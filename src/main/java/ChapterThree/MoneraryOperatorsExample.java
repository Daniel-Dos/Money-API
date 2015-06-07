package ChapterThree;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryOperator;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryOperators;

/**
 * @author Daniel Dias
 * 
 * <br>
 * O moneta traz por padão algumas implementaçoes de {@code MonetaryOperator}, a classe
 * {@code MonetaryOperators}. Ela é uma classe utilitaria que traz algumas funcionalidades
 * importantes e algumas vezes muito corriquira dentro da vida de um desenvolvedor Java ,como:
 * 
 * <br>
 * 
 * <ul>
 * 
 * <li>reciprocal(): retorna o dinheiro como reciprocal, multiplicando pelo valor inverso (1/n)</li>
 * <li>permil(Number number): retorna o valor permil do dinheiro, por exemplo, {@code permil(10)} de EUR 2.35 retorá EUR 0.235</li>
 * <li>percent(Number number): retorna o percentual de um dinheiro, por exemplo {@code percent(10)} de EUR 200.00 é EUR 20.00</li>
 * <li>minorPart() retorna o valor que se encontra na direita da virgula, por exemplo , a menor parte de EUR 2.35 é EUR 0.35</li>
 * <li>majorPart() retorna o valor inteiro do dinheiro , por exemplo maior parte de EUR 2.35 é EUR 2</li>
 * <li>rounding() realiza o processo de arredondamento do dinheiro, para saber o numero de casas apos a virgula é 
 * recuperado a informaçao do metedo getDefaultFractionDigits() da interface CurrencyUnit.</li>
 * <li>exchange(CurrencyUnit currency): dado um dinheiro esse operador realizará a troca da moeda , ou seja
 * ele apenas vai trocar mudar a moeda não levando em consideraçao a sua cotaçao, por exemplo , EUR 2.35 {@code exachange('BRL')}
 * retornará BRL 2.35</li>
 * 
 * 
 * </ul>
 *
 */
public class MoneraryOperatorsExample {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		CurrencyUnit dollar = Monetary.getCurrency(Locale.US);
		MonetaryAmount money = Money.of(120.231, currency);
		
		MonetaryAmount majorPartResult  = money.with(MonetaryOperators.majorPart());
		MonetaryAmount minorPartResult = money.with(MonetaryOperators.minorPart());
		MonetaryAmount percentResult = money.with(MonetaryOperators.percent(20));
		MonetaryAmount permilResult  = money.with(MonetaryOperators.permil(100));
		MonetaryAmount roundingResult = money.with(MonetaryOperators.rounding());
		MonetaryAmount resultExchange = money.with(MonetaryOperators.exchange(dollar));
		
		System.out.println("MajorPart : " + majorPartResult + 
				"\nminorPart : " + minorPartResult +
				"\npercent : " + percentResult +
				"\npermil : " + permilResult +
				"\nrounding : " + roundingResult +
				"\nexchange : " + resultExchange);
		
		
	}

}
