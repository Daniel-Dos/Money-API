package ChapterFive;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.ConversionQuery;
import javax.money.convert.ConversionQueryBuilder;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.convert.ExchangeRateType;

/**
 * @author Daniel Dias
 * 
 * <br>
 * <h2>cota��o a partir de uma data especifica</h2>
 * 
 * Com o moneta � possivel realizar uma busca a partir de uma data especifica
 * para isso � utilizado a classe {@code ConversionQuery} com ela � possivel realizar
 * buscas de datas diferentes ou num range de datas. A representa��o pe a classe {@code LocalDate}
 *
 */
public class ExchangeRateProviderExample2 {
	public static void main(String[] args) {
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		
		MonetaryAmount money = FastMoney.of(10, dollar);
		MonetaryAmount money2 = FastMoney.of(10, real);
		
		LocalDate localDate = Year.of(2009).atMonth(Month.JANUARY).atDay(9);
		
		ExchangeRateProvider  provider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.IMF_HIST);
		ConversionQuery query = ConversionQueryBuilder.of().setTermCurrency(dollar).set(localDate).build();
		
		CurrencyConversion currencyConversion = provider.getCurrencyConversion(query);
		
		MonetaryAmount result = currencyConversion.apply(money2);
		MonetaryAmount monetaryAmount = money.add(result);
		System.out.println(monetaryAmount);
		
		
		
	}

}
