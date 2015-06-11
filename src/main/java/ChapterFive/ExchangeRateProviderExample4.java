package ChapterFive;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Comparator;
import java.util.stream.Stream;

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
 */
public class ExchangeRateProviderExample4 {
	public static void main(String[] args) {
		
		/*
		 *  Uma possivel soluçao para esse problema é passar o range de datas,
		 *  assim a implementação vai procurar algumas das datas, caso nao encontre
		 *  nenhuma lançara uma exceçao, vale salientar que a implementaçao buscara a partir
		 *  da ordem que foi definida.
		 * */
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		
		MonetaryAmount money = FastMoney.of(10, dollar);
		MonetaryAmount money2 = FastMoney.of(10, real);
		
		LocalDate localDate = Year.of(2011).atMonth(Month.JANUARY).atDay(9);
		LocalDate[] localDates = Stream.of(localDate, localDate.minusDays(1L), localDate.minusDays(2L),
				localDate.minusDays(3L)).sorted(Comparator.<LocalDate>naturalOrder().reversed()).toArray(LocalDate[]::new);
		ExchangeRateProvider provider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.IMF_HIST);
		ConversionQuery query = ConversionQueryBuilder.of().setTermCurrency(dollar).set(localDates).build();
		
		CurrencyConversion currencyConversion = provider.getCurrencyConversion(query);
		
		MonetaryAmount result = currencyConversion.apply(money2);
		MonetaryAmount sum = money.add(result);
		
		System.out.println(sum);
		
	}

}
