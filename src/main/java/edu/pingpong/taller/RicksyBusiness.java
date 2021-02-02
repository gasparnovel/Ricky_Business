package edu.pingpong.taller;

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
       }
}

