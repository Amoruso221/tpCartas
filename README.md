# tpCartas

*La base de datos utilizada fue MYSQL. La misma se eligio porque se puede utilizar el servidor en varios SO como windows y conectar con java
mediante el Connector/j.

* El juego termina cuando se acaban las cartas. Se pueden setear la cantidad de cartas en el constructor del repartidor desde el main.
  Mientras el hilo del jugador(observable) no sea interrumpido le pedira cartas al repartidor(observador), este le devolvera una carta 
  con un valor aleatorio entre 0 y 11 (se puede modificar en el metodo get del repartidor), guardara la carta en su stack y notificara.
  En el metodo update del repartidor se realizara el print del nombre del jugador y el valor de la carta obtenida.
  Una vez interrumpido el hilo del jugador este llamara a un metodo para comparar la sumatoria de sus puntos con la de los demas jugadores.
  El nombre y el puntaje del jugador ganador se guardaran en la BD mysql. La clase Conexion es la encargada de establecer la conexion y 
  ejecutar el query.
  
  
  
