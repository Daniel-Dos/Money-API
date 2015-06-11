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
 * <h2>contação com ExchangeRateProvider</h2>
 * 
 *  <br>
 *  Com a money-api é possivel realizar a cotação da moeda, o responsavel por essa ação
 *  é a interface {@code ExchangeRateProvider}.
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
		 *  Dentro do moneta existem quatro implementaçoes de {@code ExchangeRateProvider}
		 *  
		 *  <ul>
		 *  <li>ECb - implementação que recupera informação recente do Banco Central Europeu</li>
		 *  <li>IMF - implementaçao que recupera as cotaçes mais recentes do fundo internacional monetario</li>
		 *  <li>IMF_HIST - implementaçao que permite recuperar cotaçao de uma data espeficica a partir do IMF</li>
		 *  <li>ECB_HIST90 - implementaçao que recupera os ultimos noventa dias do banco central europeu</li>
		 *  <li>ECB_HIST - implementaçao que recupera as cotaçoes desde 1999 do banco central europeu.</li>
		 *  
		 *  </ul>
		 */
	}

}
