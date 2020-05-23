package juego;

import java.util.Scanner;

/**
@author Alvaro Merino
 * Vamos a intentar cazar una mosca. La mosca será un valor que se introduce en
 * una posición de una lista; el jugador no ve el panel pero si ve las casillas a las que
 * puede golpear. Si la mosca está en esa posición se acaba el juego, mostrando un
 * mensaje ?mosca cazada?. Si la mosca no está en esa posición pueden ocurrir dos
 * cosas: que la mosca esté en casillas adyacentes en cuyo caso la mosca revolotea
 * y se sitúa en otra casilla o que la mosca no esté en casillas adyacentes, en este
 * caso la mosca permanece donde está.
 */
public class MetodoMosca {
    
    public static Scanner teclado = new Scanner(System.in);
    /**
     * Método utilizado para que el juego cumpla con sus funcionalidades.
     * Lo primmero que hace es crear un array con la longitud pedida por parámetro
     * dentro de ese array introduce una mosca(valor 1), en una posición generada
     * de forma aleatoria, pide que introduzcamos una posición por teclado
     * si la posición de la mosca y la que hemos dado coincide mosca cazada y fin
     * si la posición está 1 por debajo o 1 por encima, cambia de posición
     * y si la posición no es la acertada ni tampoco 1 por encima o por debajo de la mosca
     * la mosca no se mueve (mensaje la mosca se rie de ti).
     * @param longitud parámetro que dicta la dificultad del juego
     */

    public static void Juego(int longitud) {
        int valor = 0, mosca = 1, aleatorio, intento;
        int[] array = new int[longitud];
        int veces = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = valor;
        }

        aleatorio = generarAleatorio(longitud);
        array[aleatorio] = mosca;
        do {
            try {
                do {
                    System.out.println("\t *****************************************************");
                    System.out.println("\t ********** INTENTE CAZAR LA MOSCA          **********");
                    System.out.println("\t ********** Introduzca un número entre 0 y " + (longitud - 1) + "**********");
                    intento = teclado.nextInt();
                    veces++;
                } while (intento > longitud - 1);
                System.out.println("\t ********** ¿Cazará a la mosca?             **********");
                if (intento == aleatorio) {
                    //si la posición de la mosca y el número coinciden, se termina el do while.
                    System.out.println("\t ********** ¡¡¡HA CAZADO LA MOSCA!!!        **********");
                    System.out.println("\t ********** Ha necesitado " + veces + " intento(s)      **********");
                    System.out.println("\t *****************************************************");
                    System.out.println(" ");
                    valor = 99;
                } else if (intento == aleatorio + 1 || intento == aleatorio - 1) {
                    aleatorio = generarAleatorio(longitud);
                    //Si la posición de la mosca está una posición por encima o una por debajo cambia su valor.
                } else {
                    /*si la mosca no es encontrada ni su posición es una arriba o abajo de la elegida,
                    se muestra el siguiente mensaje.*/
                    System.out.println("\t ********** LA MOSCA SE RIE DE TI           **********");
                }
            } catch (Exception e) {
                teclado.next();
            }

        } while (valor != 99);

    }
    
    /**
     * Método que genera un número aleatorio, que vamos a utilizar
     * para dar la posición en la que está la mosca.
     * @param longitud máximo del array
     * @return posición en la que está la mosca.
     */

    public static int generarAleatorio(int longitud) {
        int aleatorio = 0;
        aleatorio = (int) (Math.random() * (0 - (longitud - 1)) + (longitud - 1));
        return aleatorio;
    }

}
