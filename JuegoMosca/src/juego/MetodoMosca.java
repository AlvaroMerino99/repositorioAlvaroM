package juego;

import java.util.Scanner;

/**
@author Alvaro Merino
 * Vamos a intentar cazar una mosca. La mosca ser� un valor que se introduce en
 * una posici�n de una lista; el jugador no ve el panel pero si ve las casillas a las que
 * puede golpear. Si la mosca est� en esa posici�n se acaba el juego, mostrando un
 * mensaje ?mosca cazada?. Si la mosca no est� en esa posici�n pueden ocurrir dos
 * cosas: que la mosca est� en casillas adyacentes en cuyo caso la mosca revolotea
 * y se sit�a en otra casilla o que la mosca no est� en casillas adyacentes, en este
 * caso la mosca permanece donde est�.
 */
public class MetodoMosca {
    
    public static Scanner teclado = new Scanner(System.in);
    /**
     * M�todo utilizado para que el juego cumpla con sus funcionalidades.
     * Lo primmero que hace es crear un array con la longitud pedida por par�metro
     * dentro de ese array introduce una mosca(valor 1), en una posici�n generada
     * de forma aleatoria, pide que introduzcamos una posici�n por teclado
     * si la posici�n de la mosca y la que hemos dado coincide mosca cazada y fin
     * si la posici�n est� 1 por debajo o 1 por encima, cambia de posici�n
     * y si la posici�n no es la acertada ni tampoco 1 por encima o por debajo de la mosca
     * la mosca no se mueve (mensaje la mosca se rie de ti).
     * @param longitud par�metro que dicta la dificultad del juego
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
                    System.out.println("\t ********** Introduzca un n�mero entre 0 y " + (longitud - 1) + "**********");
                    intento = teclado.nextInt();
                    veces++;
                } while (intento > longitud - 1);
                System.out.println("\t ********** �Cazar� a la mosca?             **********");
                if (intento == aleatorio) {
                    //si la posici�n de la mosca y el n�mero coinciden, se termina el do while.
                    System.out.println("\t ********** ���HA CAZADO LA MOSCA!!!        **********");
                    System.out.println("\t ********** Ha necesitado " + veces + " intento(s)      **********");
                    System.out.println("\t *****************************************************");
                    System.out.println(" ");
                    valor = 99;
                } else if (intento == aleatorio + 1 || intento == aleatorio - 1) {
                    aleatorio = generarAleatorio(longitud);
                    //Si la posici�n de la mosca est� una posici�n por encima o una por debajo cambia su valor.
                } else {
                    /*si la mosca no es encontrada ni su posici�n es una arriba o abajo de la elegida,
                    se muestra el siguiente mensaje.*/
                    System.out.println("\t ********** LA MOSCA SE RIE DE TI           **********");
                }
            } catch (Exception e) {
                teclado.next();
            }

        } while (valor != 99);

    }
    
    /**
     * M�todo que genera un n�mero aleatorio, que vamos a utilizar
     * para dar la posici�n en la que est� la mosca.
     * @param longitud m�ximo del array
     * @return posici�n en la que est� la mosca.
     */

    public static int generarAleatorio(int longitud) {
        int aleatorio = 0;
        aleatorio = (int) (Math.random() * (0 - (longitud - 1)) + (longitud - 1));
        return aleatorio;
    }

}
