package ChapterFive;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.convert.ExchangeRateType;

/**
 * @author Daniel Dias
 * 
 * <br>
 * 
 * <h2>conta��o com ExchangeRateProvider</h2>
 * 
 *  <br>
 *  Com a money-api � possivel realizar a cota��o da moeda, o responsavel por essa a��o
 *  � a interface {@code ExchangeRateProvider}.
 *
 */
public class ExchangeRateProviderExample {
	public static void main(String[] args) {
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		MonetaryAmount money = FastMoney.of(10, dollar);
		MonetaryAmount money2 = FastMoney.of(10,real);
		ExchangeRateProvider provider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.ECB);
		CurrencyConversion currencyConversion = provider.getCurrencyConversion(dollar);
		MonetaryAmount result = currencyConversion.apply(money2); // value on dollar
		MonetaryAmount monetaryAmount = money.add(result); // result on dollar
		
		System.out.println("Result : " + result +
				"\nmonetaryAmount : " + monetaryAmount);
		
		/**
		 * 
		 *  Dentro do moneta existem quatro implementa�oes de {@code ExchangeRateProvider}
		 *  
		 *  <ul>
		 *  <li>ECb - implementa��o que recupera informa��o recente do Banco Central Europeu</li>
		 *  <li>IMF - implementa�ao que recupera as cota�es mais recentes do fundo internacional monetario</li>
		 *  <li>IMF_HIST - implementa�ao que permite recuperar cota�ao de uma data espeficica a partir do IMF</li>
		 *  <li>ECB_HIST90 - implementa�ao que recupera os ultimos noventa dias do banco central europeu</li>
		 *  <li>ECB_HIST - implementa�ao que recupera as cota�oes desde 1999 do banco central europeu.</li>
		 *  
		 *  </ul>
		 */
	}

}
