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
 *
 */
public class ExchangeRateProviderExample3 {
	public static void main(String[] args) {
		
		/*
		 *  Caso a data especificada nao seja encontrada sera retornada uma exceçao , por exemplo
		 *  nao sera possivel recuperar a contao do dia 9 de janeiro de 2011, uma vez  que essa data 
		 *  foi em um domingo e a grande maioria do provedores de cotaçao nao trabalham nesse dia.
		 * 
		 * */
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		
		MonetaryAmount money = FastMoney.of(10, dollar);
		MonetaryAmount money2 = FastMoney.of(10, real);
		
		LocalDate localDate = Year.of(20011).atMonth(Month.JANUARY).atDay(9);
		
		ExchangeRateProvider provider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.IMF_HIST);
		ConversionQuery query = ConversionQueryBuilder.of().setTermCurrency(dollar).set(localDate).build();
		
		CurrencyConversion currencyConversion = provider.getCurrencyConversion(query);
		MonetaryAmount result = currencyConversion.apply(money2);
		System.out.println(currencyConversion); // exceção vai ocorrer
		
		
	}

}
