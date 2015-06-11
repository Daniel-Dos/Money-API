package ChapterFive;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryException;

import org.javamoney.moneta.FastMoney;

/**
 * @author Daniel Dias
 * 
 * <br>
 * 
 * <h2>Cotação</h2>
 *
 */
public class MistakeExample {
	public static void main(String[] args) {
		
		// realizando operaçoes com moedas diferentes
		CurrencyUnit dollar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");
		MonetaryAmount money = FastMoney.of(10, dollar);
		MonetaryAmount money2 = FastMoney.of(10, real);
		
		MonetaryAmount result = money.add(money2); // faz adição
			System.out.println(result);
			
		
		
		/*
		 *  utilizando a money-api, ele gerara uma exceção afimando que existe um erro
		 *  ao tentar somar dinheiro com moedas diferentes, nesse caso real com dolar. Essa
		 *  exceção foi lançada de forma correta uma vez que nao necessariamente um dolar equilave a um real.
		 *  Para realizar tal operaçao de somatoria entre moedas diferentes , e´necessario primeiro
		 *  realizar a cotaçao da moeada. A taxa de cambio é a relaçao das moedas entre dois paises que 
		 *  resulta no preço de uma delas com relaçao a outra.
		 * 
		 * */
	}

}
