package com.company;

public class Main {
    //private static Repartidor repartidor;

    public static void main(String[] args) {
       Repartidor repartidor = new Repartidor(1000); // Establece la cantidad de cartas del mazo

            Thread jugador1 = new Thread(new Jugador("jugador1", repartidor));
            Thread jugador2 = new Thread(new Jugador("jugador2", repartidor));
            Thread jugador3 = new Thread(new Jugador("jugador3", repartidor));
            Thread jugador4 = new Thread(new Jugador("jugador4", repartidor));

                jugador1.start();
                jugador2.start();
                jugador3.start();
                jugador4.start();
    }
}
