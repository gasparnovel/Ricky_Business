package edu.ricky.business.ricky;

import edu.ricky.business.ricky.CreditCard;

/**
* Crea una tarjeta de crédito para Abradolph.
 * Como es una AndromedanExpress
 * el crédito inicial es de 3000 EZIS
 */

public class App {

       public static void main( String[] args ) {
              System.out.println();

              CreditCard abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");

              System.out.println("\n" + "Tarjeta de Abradolph" + "\n" + 
                                          "===================="        );
              System.out.println(abradolph);

              /**
         * Construye el componente de reserva de Ovnis.
         * Recibe el objeto tarjeta de crédito del invitado/a
         * en el método dispatch(card)
         * y realiza un cargo a la tarjeta.
         * Si hay saldo suficiente se reserva un UberOvni
         * de los que estén libres.
         * El coste del ovni es de 500 EZIs.
         */
              /**
              UfosPark ufosPark = new UfosPark();

        // Da de alta en la flota de ovnis 2 UFOS.

              String[] ufosID = { "unx", "dox" };
		for (String ovni : ufosID) {
			ufosPark.add(ovni);
              } */
       }
}
