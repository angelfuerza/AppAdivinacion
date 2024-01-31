/**
 *
 *
 * @author ÁNGEL DE LARA LAFUERZA 
 * @version 1.0
 */


 
import java.io.*;
import java.util.Scanner;
import java.math.*;
import java.lang.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    // METODO MAIN
    public static void main(String[] args) throws Exception {
        System.out.println("APP DE ADIVINACION\n");

        // Declaramos y generamos el numero aleatorio
        int numUsuario = 0;
        int randomNum = 0;
        randomNum = (int) (Math.random() * 20) + 1;

        // Pedimos al usuario que introduzca su nombre
        Scanner scaner = new Scanner(System.in);
        System.out.println("Por favor, introduce tu nombre: ");
        String nombre = scaner.next();

        // Pedimos al usuario que introduzca un numero
        System.out.println("Por favor, introduce un numero: ");
        numUsuario = scaner.nextInt();

        // Comprobamos si los numeros coinciden llamando a la funcion
        int numeroIntentos = compruebaNumero(numUsuario, randomNum);

        // LLamamos al método para escribir ficheros con nombre e intentos

        escribeFichero(nombre, numeroIntentos);
    }

    









    
    // METODO PARA COMPROBAR LOS NUMEROS QUE DEVUELVE EL NUM DE INTENTOS
    public static int compruebaNumero(int numero, int random) {

        int i = 0;
        while (numero != random) {
            System.out.println("Lo siento, prueba de nuevo");
            System.out.println("Introduce otro número");
            Scanner scaner = new Scanner(System.in);
            numero = scaner.nextInt();
            i++;
        }

        System.out.println("Enhorabuena has acertado en: " + i + " intentos");
        return i;
    }

    



    
    // METODO PARA ESCRIBIR EL FICHERO
    public static void escribeFichero(String nombre, int intentos) {
        // Generamos el fichero
        try {
            File myObj = new File("juego.txt");
            if (myObj.createNewFile()) {
                System.out.println("Fichero creado: " + myObj.getName());
            } else {
                System.out.println("El fichero ya existe");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error");
            e.printStackTrace();
        }

        // Escribimos la información en el fichero
        try {
            FileWriter myWriter = new FileWriter("juego.txt");
            myWriter.write(nombre + ", " + intentos);
            myWriter.close();
            System.out.println("Se escribió el fichero correctamente");
        } catch (IOException e) {
            System.out.println("Ocurrió un error");
            e.printStackTrace();
        }
    }

}
