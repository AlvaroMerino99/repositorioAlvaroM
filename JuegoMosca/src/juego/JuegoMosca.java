package juego;

import java.util.Scanner;

/**
 * Aplicación que ejecuta el juego de la mosca
 * @author Alvaro Merino
 */
public class JuegoMosca {

    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0, longitud;
        do {
            try {
                System.out.println("\t ********** Bienvenido al Juego de la Mosca **********");
                System.out.println("\t *****************************************************");
                System.out.println("\t ********** Introduzca la dificultad        **********");
                System.out.println("\t ********** 1.Fácil                         **********");
                System.out.println("\t ********** 2.Medio                         **********");
                System.out.println("\t ********** 3.Difícil                       **********");
                System.out.println("\t ********** 4.Salir                         **********");
                System.out.println("\t *****************************************************");
                opcion = teclado.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("\t ********** Ha elegido dificultad Fácil     **********");
                        longitud = 4;
                        MetodoMosca.Juego(longitud);
                        break;
                    case 2:
                        System.out.println("\t ********** Ha elegido dificultad  Medio     **********");
                        longitud = 7;
                        MetodoMosca.Juego(longitud);
                        break;
                    case 3:
                        System.out.println("\t ********** Ha elegido difucultad Difícil    **********");
                        longitud = 10;
                        MetodoMosca.Juego(longitud);
                        break;
                    case 4:
                        System.out.println("\t ********** Ha elegido salir                 **********");
                        break;
                    default:
                        System.out.println("\t ********** Opción elegida no válida         ***********");
                        System.out.println("\t ********** Por favor introduzca una opción correcta ***");
                        break;
                }

                System.out.println("Fin del programa...");
            } catch (Exception e) {
                teclado.next();
            }
        } while (opcion != 4);

    }

}
