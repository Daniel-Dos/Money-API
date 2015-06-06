package ChapterTwo;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

/**
 * @author Daniel Dias
 * 
 * <br>
 * <h1>NumberValues: A representação da parte numérica do money</h1>
 * 
 * <br>
 * 
 * <blockquote>
 * 
 * Em alguns momentos é importante recupera e tratar informaçoes do dinheiro de forma separada,
 * para isso, a interface dispoe de metodo para recuperar tanto a moeda qunato o valor monetario;
 * Para a moeda ele obviamente retorna a interface <code>CurrencyUnit</code> e para representar o valor
 * numerico é retornada a classe <code>NumberValue</code>. Essa classe é filha da 
 * <code>Number</code> do Java, assim é possivel recuperar os tipos primitivos basico do Java(int,long,float,double, etc).
 * 
 * </blockquote>
 *
 */
public class BetriveInformationMethods {
	public static void main(String[] args) {
		
		MonetaryAmount money = Money.of(10, Monetary.getCurrency("BRL"));
		CurrencyUnit currency = money.getCurrency();
		Number number = money.getNumber(); // recupera o valor numerico
		
		System.out.println(number);
	}

}
