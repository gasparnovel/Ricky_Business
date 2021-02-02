/**
 * Ricksy Business
 * ===============
 * Rick se queda a cargo Morty y Summer, 
 * y celebra una pedazo de fiesta. 
 * Entre los invitados hay adolescentes, aliens, 
 * Gearhead, Squanchy, Birdpearson y 
 * Abradolph Lincler (una combinación de DNA
 * de Adolf Hitler y Abraham Lincoln).
 * 
 * Cuando un invitado/a llega a la fiesta, 
 * se le da de alta en el receptivo del sistema
 * mediante su tarjeta de crédito.
 * 
 * El receptivo carga en el crédito de la tarjeta:
 * - El coste del UberOvni de vuelta a casa
 * - El coste del pack de bienvenida (Collaxion crystals).
 * 
 * El componente de reserva de Ovnis y el componente
 * de entrega del pack de bienvenida observan al
 * componente receptivo, de modo que cuando el receptivo
 * da de alta a un invitado/a automáticamente cargan 
 * en la tarjeta del invitado/a el coste de ambos servicios. 
 */


package edu.ricky.business.ricky;

import edu.ricky.business.ricky.CreditCard;


public class RicksyBusiness {

       public static void main( String[] args ) {
              System.out.println();

              /**
               * Crea una tarjeta de crédito para Abradolph.
               * Como es una AndromedanExpress
               * el crédito inicial es de 3000 EZIS
               */

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
              UfosPark ufospark = new UfosPark();

              String[] ufosID = {"unx", "dox"};
                     for (String ovni : ufosID) {
                            ufospark.add(ovni);
              }
       
              // Procesamos el pago y reserva de ovni de Abradolph

              ufospark.dispatch(abradolph);

              // Mostramos el ID del ovni asignado a Abradolph

              System.out.println("\nOvni de Abradolph\n" +
                                   "==================");
              System.out.println(ufospark.getUfoOf(abradolph.getNumber()));
       
              // Mostramos el credito de la tarjeta de Abradolph

              System.out.println("Credito de Abradolph: " + abradolph.getCredit());

              // La dualidad en Abradolph quiere reservar otro ovni.
              // El sistema detecta que ya tiene uno 
              // e ignora la petición.

              System.out.println("\nAbradolph quiere otro ovni\n" + 
                            "==========================");
              ufospark.dispatch(abradolph);
              System.out.println("Su credito no ha cambiado: " + abradolph.getCredit());
              System.out.println("Ovni de Abradolph: " + ufospark.getUfoOf(abradolph.getNumber()));
       }
}
