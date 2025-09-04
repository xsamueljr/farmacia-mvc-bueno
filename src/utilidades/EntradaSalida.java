package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaSalida {
    private static final Scanner scanner = new Scanner(System.in);

    public static int leerEntero(String prompt, int minimo, int maximo) {
        while (true) {
            System.out.print(prompt);
            int numero;
            try {
                numero = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un número válido. Vuelve a intentarlo");
                continue;
            } finally {
                // Limpieza de búfer, el scanner coge el número
                // y deja ahí el salto de línea, pudiendo provocar un bucle
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }

            if (numero < minimo) {
                System.out.printf("El número debe ser mayor que %d. Vuelve a intentarlo", minimo);
                continue;
            }

            if (numero > maximo) {
                System.out.printf("El número debe ser menor que %d. Vuelve a intentarlo", maximo);
                continue;
            }

            return numero;
        }
    }

    public static int leerEntero(String prompt) {
        return leerEntero(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static String leerCadena(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static String leerCadena() {
        return leerCadena("> ");
    }
}
