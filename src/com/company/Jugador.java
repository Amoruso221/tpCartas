package com.company;
import java.util.Observable;
import java.util.Stack;

public class Jugador extends Observable implements Runnable {
    private String nombre;
    private final Repartidor repartidor;
    private Stack<Integer> mazoPropio = new Stack<Integer>();

    public Jugador(String nombre, Repartidor repartidor){
        this.nombre = nombre;
        this.repartidor = repartidor;
        addObserver(repartidor);
    }

    public String getNombre() {
        return nombre;
    }

    public Stack<Integer> getMazoPropio() {
        return mazoPropio;
    }

    @Override
    public void run() {

            while(!Thread.currentThread().isInterrupted())
        {
            int valorCarta = repartidor.getCarta();
            mazoPropio.push(valorCarta);
            setChanged();
            notifyObservers(valorCarta);
        }

        repartidor.comparaJugadores(nombre, mazoPropio);
    }
}
