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
import edu.ricky.business.ricky.UfosPark;
import edu.ricky.business.ricky.Receptivo;
import edu.ricky.business.ricky.RickMenuDispatcher;
import edu.ricky.business.ricky.GuestDispatcher;
import edu.ricky.business.ricky.CrystalExpender;



public class RicksyBusiness {

       public static void main(String[] args) {
              System.out.println();

              /**
               * Crea una tarjeta de crédito para Abradolph. Como es una AndromedanExpress el
               * crédito inicial es de 3000 EZIS
               */

              CreditCard abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");

              System.out.println("\n" + "Tarjeta de Abradolph" + "\n" + "====================");
              System.out.println(abradolph);

              /**
               * Construye el componente de reserva de Ovnis. Recibe el objeto tarjeta de
               * crédito del invitado/a en el método dispatch(card) y realiza un cargo a la
               * tarjeta. Si hay saldo suficiente se reserva un UberOvni de los que estén
               * libres. El coste del ovni es de 500 EZIs.
               */
              UfosPark ufospark = new UfosPark();

              String[] ufosID = { "unx", "dox" };
              for (String ovni : ufosID) {
                     ufospark.add(ovni);
              }

              // Procesamos el pago y reserva de ovni de Abradolph

              ufospark.dispatch(abradolph);

              // Mostramos el ID del ovni asignado a Abradolph

              System.out.println("\nOvni de Abradolph\n" + "==================");
              System.out.println(ufospark.getUfoOf(abradolph.getNumber()));

              // Mostramos el credito de la tarjeta de Abradolph

              System.out.println("Credito de Abradolph: " + abradolph.getCredit());

              // La dualidad en Abradolph quiere reservar otro ovni.
              // El sistema detecta que ya tiene uno
              // e ignora la petición.

              System.out.println("\nAbradolph quiere otro ovni\n" + "==========================");
              ufospark.dispatch(abradolph);
              System.out.println("Su credito no ha cambiado: " + abradolph.getCredit());
              System.out.println("Ovni de Abradolph: " + ufospark.getUfoOf(abradolph.getNumber()));

              // A GearHead le vacía la tarjeta el alien "Cámara Lenta"
              // mientras le daba la chapa, justo antes de pagar el ovni.
              // Intenta reservarlo y el componente de reserva de ovnis
              // no le asigna ninguno.

              System.out.println("\nLLega GearHead!\n" + "===============");
              CreditCard gearHead = new CreditCard("Gearhead", "8888888888888888");

              gearHead.pay(3000); // le vacían la cartera

              ufospark.dispatch(gearHead);
              System.out.println("Su credito es cero: " + gearHead.getCredit());
              System.out.println("No puede reservar ovni: " + ufospark.getUfoOf(gearHead.getNumber()));

              // Squanchy deja su ovni reservado
              // antes de irse a squanchear

              System.out.println("\nLLega Squanchy!\n" + "==============");
              CreditCard squanchy = new CreditCard("Squanchy", "4444444444444444");
              ufospark.dispatch(squanchy);
              System.out.println("Su credito es: " + squanchy.getCredit());
              System.out.println("Su ovni es: " + ufospark.getUfoOf(squanchy.getNumber()));

              // Morty quiere un ovni para huir de la fiesta
              // pero ya no queda ninguno disponible

              System.out.println("\nAlgun ovni para Morty?\n" + "======================");
              CreditCard morty = new CreditCard("Morty", "0000000000000000");
              ufospark.dispatch(morty);
              System.out.println("Su credito no ha cambiado: " + morty.getCredit());
              System.out.println("No hay ovni Morty: " + ufospark.getUfoOf(morty.getNumber()));

              // Metemos un ovni más en la flota de ovnis
              // y mostramos la flota por consola

              System.out.println("\nFlota de ovnis\n" + "==============");
              ufospark.add("trex");
              System.out.println(ufospark);

              /**
               * Construye el dispensador de packs de bienvenida. Indica el numero de unidades
               * y el coste de cada uno de ellos, que es de 50 EZIs
               */

              GuestDispatcher packExpender = (GuestDispatcher) new CrystalExpender(3, 50);

              // Muestra el total de packs y su precio unidad
              System.out.println("\nPacks\n" + "=====");
              System.out.println(packExpender);

              // Abradolph compra su pack de bienvenida
              packExpender.dispatch(abradolph);

              System.out.println("\nAbradolph compra su pack\n" + "========================");
              System.out.println("Packs\n" + packExpender);
              System.out.println("Credito de Abradolph: " + abradolph.getCredit());

              // El pobre GerHead no tiene crédito para comprar su pack
              System.out.println("\nGearHead sin credito para su pack\n" + "=================================");
              packExpender.dispatch(gearHead);
              System.out.println("Packs\n" + packExpender);
              System.out.println("Credito de GearHead: " + gearHead.getCredit());
              
              /**
               * Vamos a automatizar ahora ambas tareas, de modo que
               * cuando llega un invitado/a se le asiga un ovni
               * y un pack y se realiza el cargo a la tarjeta.
               * 
               * Para ello, crea el componente receptivo
               * y registra (añade) los componentes UfosPark
               * y CrystalDispatcher al receptivo
               */

              Receptivo receptivo = new Receptivo();
              receptivo.registra(ufospark);
              receptivo.registra(packExpender);

              // Implementa el metodo receptivo.dispatch()
              // para que invoque a UfosPark.dispatch()
              // y a CrystalExpender.dispatch()

              // Squanchy reserva ovni (ya tiene) y pack

              System.out.println("\nLLega Squanchy!\n" + 
                                   "===============");
              receptivo.dispatch(squanchy);
              mostrarReserva(squanchy, packExpender, ufospark);

              // Gearhead reserva ovni y pack.
              // No tiene crédito.

              System.out.println("\nLLega GearHead!\n" + 
                                   "===============");
              gearHead.pay(3000); // no tiene crédito
              receptivo.dispatch(gearHead);
              mostrarReserva(gearHead, packExpender, ufospark);

              // Birdpearson es recibido en la fiesta

              System.out.println("\nLLega Birdpearson!\n" + 
                                   "==================");
              CreditCard birdpearson = new CreditCard("Birdpearson", "1111111111111111");
              receptivo.dispatch(birdpearson);
              mostrarReserva(birdpearson, packExpender, ufospark);

              // Morty intenta reserver un ovni y un pack pero no quedan

              System.out.println("\nMorty quiere pack y ovni pero no quedan :(\n" + 
                                   "==========================================");
              morty = new CreditCard("Morty", "0000000000000000");
              receptivo.dispatch(morty);
              mostrarReserva(morty, packExpender, ufospark);
              

              /**
               * A por el 10!! 
               * Wubba lubba dub dub!!
               * 
               * Añade otra tarea al receptivo,
               * de modo que 5 invitados:
               * abradolph, squanchy, morty, gearHead, birdpearson
               * encarguen un RickMenú junto 
               * al ovni y al pack de bienvenida.
               * Hay 100 RickMenús y su precio es de 10 EZIs.
               * Muestra el total de pedidos y la lista de
               * invitados/as (numero de tarjeta) que han hecho un pedido.
               */

              // tu código aquí

              RickMenuDispatcher MenuDispatcher = new RickMenuDispatcher();

              CreditCard[] cards = {abradolph, squanchy, morty, gearHead, birdpearson};

              for (CreditCard card: cards) {
              receptivo.dispatch(card);
              }

              System.out.println("\nPedidos de RickMenus:\n" + 
                                   "=====================");
              System.out.println(MenuDispatcher);

              System.out.println("\nCreditos de los invitados/as:\n" + 
                                   "=============================");

              for (CreditCard card: cards) {
              System.out.println(card);
              System.out.println();
                     }
              }

              private static void mostrarReserva(CreditCard card, GuestDispatcher packExpender, UfosPark ufos) {
                     System.out.println(card);
                     System.out.println("Packs: " + ((CrystalExpender) packExpender).stock());
                     System.out.println("Ovni: " + ufos.getUfoOf(card.getNumber()));
              }
}

