package ChapterSix;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.swing.JOptionPane;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryFunctions;

/**
 * @author Daniel Dias
 *
 *<br>
 *  <h1>Trabalhando com Streams</h1>
 *    <h3>Ordeando uma lista monetaria</h3>
 *    
 *    <br>
 *    
 *     Dentroda classe {@code MonetaryFuncitons} � possivel ordenar pela moeda , pelo valor
 *     numerico apenas , alem da valiosidade de um dinheiro, levando em considera�a� a conta��o
 *     da moeda , de forma ascendente e descedente.
 */
public class SortMonetaryAmountCurrency {
	
	/*
	 *  Realizando ordena��o com moeda
	 *   No caso da ordena��o da moeda � levado em considera��o o codigo
	 *   da moeda. Por exemplo, uma lista com as moedas USD,EUR,BRL  
	 *   retornara BRL, EUR e USD de forma ascendente e USD,EUR,BRL de fora descrescente.
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit euro = Monetary.getCurrency("EUR");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		
		MonetaryAmount money = Money.of(9, euro);
		MonetaryAmount money2 = Money.of(10, dollar);
		MonetaryAmount money3 = Money.of(11, real);
		
		List<MonetaryAmount> resultAsc = Stream.of(money,money2,money3)
				.sorted(MonetaryFunctions.sortCurrencyUnit()).collect(Collectors.toList());
		
		List<MonetaryAmount> resultDesc = Stream.of(money,money2,money3)
				.sorted(MonetaryFunctions.sortCurrencyUnitDesc()).collect(Collectors.toList());
		
		System.out.println ("Ordem Ascendente :" + resultAsc + 
				"\nOrdem Descendente :" + resultDesc);
		
		
	}

}
