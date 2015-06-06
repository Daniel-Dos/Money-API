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
 * Utilização da representação do valor monetario,
 * utilizando a interface MonetaryAmount, caracteristicas importantes
 * toas as implementaçoes precisam ser imutavel e thread-safe.
 * <br><br>
 * 
 * Dentro do moneta existem tres implementaçoes para a interface <code>MonetaryAmount</code>
 * 
 *<br>
 * <blockquote>Money: A implementação padrao, ela representa o valor numerico com o BigDecimal.
 *</blockquote> 
 *
 *  <br>
 *  
 *  <blockquote>
 *   RoundedMoney: assim como a implementaçao Money, representa o valor numerico com o BigDecimal,
 *   a diferença entre eles é que com o RoundedMoney é possivel receber um MonetaryOperator para 
 *   ser chamada a cada operaçao, por exemplo, a cada operaçao aritimetica realizar uma operaçao de
 *   arredondamento.
 *  </blockquote>
 *  
 *  <br>
 *  <blockquote>
 *  FastMoney:  a implementação que representa o valor número com o primitivo long, das implementações apresentadas
ela é a mais rápida, cerca de quinze vezes mais rápidas que as outras duas, além de ser mais leve na criação. Porém
ela possui uma maior limitação em relação a precisão, caso seja necessário trabalhar com essa precisão, as
operações não podem ultrapassar de cinco casas decimais.
 *  
 *  </blockquote>
 */
public class MethodsCreationMoney {
	public static void main(String[] args) {
		
		CurrencyUnit currency = Monetary.getCurrency("BRL"); // recupera o tipo da moeda : USD, BRL, JPY, EUR,etc
		MonetaryAmount money = Money.of(BigDecimal.TEN, currency); // O metodo of passando um number e um codido de moeda.
		//MonetaryAmount zero = Money.zero(currency); // nao funciona
		MonetaryAmount moneyFromCurrencyCode = Money.of(10,"USD");
	   //MonetaryAmount moneyFromCents = Money.ofMiner(currency, 100_00); // nao funciona
		
		System.out.println("Metodo of : " + money);
	}

}
