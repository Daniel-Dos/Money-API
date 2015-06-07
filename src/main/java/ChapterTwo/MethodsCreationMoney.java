package ChapterTwo;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;


import org.javamoney.moneta.Money;

/**
 * @author Daniel Dias
 * 
 * <br>
 * 
 * Utiliza��o da representa��o do valor monetario,
 * utilizando a interface MonetaryAmount, caracteristicas importantes
 * toas as implementa�oes precisam ser imutavel e thread-safe.
 * <br><br>
 * 
 * Dentro do moneta existem tres implementa�oes para a interface <code>MonetaryAmount</code>
 * 
 *<br>
 * <blockquote>Money: A implementa��o padrao, ela representa o valor numerico com o BigDecimal.
 *</blockquote> 
 *
 *  <br>
 *  
 *  <blockquote>
 *   RoundedMoney: assim como a implementa�ao Money, representa o valor numerico com o BigDecimal,
 *   a diferen�a entre eles � que com o RoundedMoney � possivel receber um MonetaryOperator para 
 *   ser chamada a cada opera�ao, por exemplo, a cada opera�ao aritimetica realizar uma opera�ao de
 *   arredondamento.
 *  </blockquote>
 *  
 *  <br>
 *  <blockquote>
 *  FastMoney:  a implementa��o que representa o valor n�mero com o primitivo long, das implementa��es apresentadas
ela � a mais r�pida, cerca de quinze vezes mais r�pidas que as outras duas, al�m de ser mais leve na cria��o. Por�m
ela possui uma maior limita��o em rela��o a precis�o, caso seja necess�rio trabalhar com essa precis�o, as
opera��es n�o podem ultrapassar de cinco casas decimais.
 *  
 *  </blockquote>
 */
public class MethodsCreationMoney {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("BRL"); // recupera o tipo da moeda : USD, BRL, JPY, EUR,etc
		MonetaryAmount money = Money.of(BigDecimal.TEN, currency); // O metodo of passando um number e um codido de moeda.
		MonetaryAmount zero = Money.zero(currency); 
		MonetaryAmount moneyFromCurrencyCode = Money.of(10,"USD");
	   MonetaryAmount moneyFromCents = Money.ofMinor(currency, 100_00); 
		
		System.out.println("Metodo of : " + money);
	}

}
