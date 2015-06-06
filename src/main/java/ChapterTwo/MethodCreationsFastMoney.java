package ChapterTwo;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.FastMoney;

/**
 * @author Daniel Dias
 * 
 * <br>
 *         <blockquote> FastMoney: a implementação que representa o valor número
 *         com o primitivo long, das implementações apresentadas ela é a mais
 *         rápida, cerca de quinze vezes mais rápidas que as outras duas, além
 *         de ser mais leve na criação. Porém ela possui uma maior limitação em
 *         relação a precisão, caso seja necessário trabalhar com essa precisão,
 *         as operações não podem ultrapassar de cinco casas decimais.
 * 
 *         </blockquote>
 *
 */
public class MethodCreationsFastMoney {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		MonetaryAmount money = FastMoney.of(BigDecimal.TEN,currency);
		//MonetaryAmount zero = FastMoney.zero(currency); nao funciona
		MonetaryAmount moneyFromCurrencyCode = FastMoney.of(10, "USD");
		//MonetaryAmount moneyFromCents = FastMoney.ofMinor(currency,100_00); nao funciona
		
		System.out.println("Usando o FastMonet : " + money);
		System.out.println("Usando o FastMonet : " + moneyFromCurrencyCode);
	}

}
