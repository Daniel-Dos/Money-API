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
 *         <blockquote> FastMoney: a implementa��o que representa o valor n�mero
 *         com o primitivo long, das implementa��es apresentadas ela � a mais
 *         r�pida, cerca de quinze vezes mais r�pidas que as outras duas, al�m
 *         de ser mais leve na cria��o. Por�m ela possui uma maior limita��o em
 *         rela��o a precis�o, caso seja necess�rio trabalhar com essa precis�o,
 *         as opera��es n�o podem ultrapassar de cinco casas decimais.
 * 
 *         </blockquote>
 *
 */
public class MethodCreationsFastMoney {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("BRL");
		MonetaryAmount money = FastMoney.of(BigDecimal.TEN,currency);
		MonetaryAmount zero = FastMoney.zero(currency); 
		MonetaryAmount moneyFromCurrencyCode = FastMoney.of(10, "USD");
		MonetaryAmount moneyFromCents = FastMoney.ofMinor(currency,100_00); 
		
		System.out.println("Usando o FastMonet : " + money);
		System.out.println("Usando o FastMonet : " + moneyFromCurrencyCode);
	}

}
