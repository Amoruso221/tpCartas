package com.company;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Stack;

public class Repartidor implements Observer{
    private int cantCartas;
    private final Random aleatorio;
    private String nombreGanador;
    private int maxCantPuntos;
    private int cantJugadorFinalizados = 0;

    public Repartidor(int cantCartas){
        this.cantCartas = cantCartas;
        aleatorio = new Random();
        maxCantPuntos = 0;
    }

    public synchronized int getCarta()
    {
        int valorCarta = 0;

        if (cantCartas > 0){
            valorCarta = aleatorio.nextInt(12);
            cantCartas = cantCartas - 1;
            notifyAll();
        }
        else
            Thread.currentThread().interrupt();

        return valorCarta;
    }

    @Override
    public void update(Observable o, Object arg) {
        Jugador jugador = (Jugador) o;
        int valorCarta = (int) arg;
        System.out.println("El jugador: " + jugador.getNombre() + " obtiene carta con valor: " + valorCarta);
    }

    private int getSumatoriaValoresCartas(Stack<Integer> mazoPropio){
        int resultado=0;
        for(int i=0; i<mazoPropio.size(); i++){
            resultado += mazoPropio.pop();
        }
        return resultado;
    }

    public void comparaJugadores(String nombre, Stack<Integer> mazoPropio){
        int sumatoria = getSumatoriaValoresCartas(mazoPropio);
        cantJugadorFinalizados+=1;

        if (sumatoria > maxCantPuntos) {
            maxCantPuntos = sumatoria;
            nombreGanador = nombre;
        }

        //Se ejecuta cuando finalizan los 4 jugadores
        if(cantJugadorFinalizados == 4){
            determinaGanador();
        }
    }

    private void determinaGanador(){
        System.out.printf("\nEl ganador es: " + nombreGanador + " con un total de " + maxCantPuntos + " puntos");
        guardarGanador();
    }

    private void guardarGanador(){
        Conexion conexion = new Conexion();
        conexion.ejecutarQuery(nombreGanador, maxCantPuntos);
    }
}

