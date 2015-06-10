package ChapterThree;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryOperator;
import javax.money.MonetaryQuery;

import org.javamoney.moneta.Money;

/**
 * @author Daniel Dias
 * 
 * <br>
 * <h2>MonetaryQuert vs MonetaryOperator</h2>
 * 
 * <br>
 * 
 * Mas com o {@code MonetaryQuery} � possivel tambem retorna {@code MonetaryAmount} e assim
 * temos o mesmo resultado que um {@code MonetaryOperator} , assim qual � o objetivo de ter duas interfaces ?
 * O objetivo de terem as duas interfaces � por questao de nomenclatura e padroniza��o. 
 * {@code MonetaryQuery} tem o objetivo extrair e buscar informa�oes dentro  do {@code MonetayAmount}. Ja o
 * {@code MonetaryOpetator} tem o objetivo de realizar opera�oes com dinheiro.
 *
 */
public class DiferenceMonetaryQueryMonetaryOperator {
	public static void main(String[] args) {
		
		//CurrencyUnit currency = Monetary.getCurrency("BRL");
		MonetaryQuery<MonetaryAmount> doubleQuery = m -> m.multiply(2);
		MonetaryOperator doubleOperator = m -> m.multiply(2);
		
		//MonetaryAmount money = Money.of(300, currency);
		//MonetaryAmount result =doubleQuery.queryFrom(money);
		//MonetaryAmount result2 = doubleOperator.apply(money);
		
		
		//System.out.println(result);
		//System.out.println(result2);
		
	}

}
