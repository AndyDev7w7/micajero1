package tarea.clase;

import java.util.Scanner;

public class Cajero1 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        //variables y constantes
        final int PIN_CORRECTO = 1234;
        double saldo = 50000;
        int intentos = 0;
        boolean cuentaBloqueada = false;

        // Autenticación según intentos
        while (intentos < 3) {
            System.out.println("Introduce tu PIN, máquina: ");
            int pinIngresado = scanner.nextInt();

            if (pinIngresado == PIN_CORRECTO) {
                System.out.println("¡Bienvenido, crack! A ver si no la lías esta vez.");
                break;
            } else {
                intentos++;
                System.out.println("¡PIN incorrecto, mastodonte! Intenta otra vez sin usar la frente.");
            }

            if (intentos == 3) {
                cuentaBloqueada = true;
                System.out.println("¡Tremendo fiera! Te has bloqueado la cuenta, ¿cómo lo haces?");
            }
        }

        // Si la cuenta está bloqueada finaliza el programa
        if (cuentaBloqueada) {
            scanner.close();
            return;
        }

        // Menú del cajero
        int opcion;
        do {
            System.out.println("\nBienvenido a tu cajero VIP de los campeones");
            System.out.println("1. Consultar monedero mágico");
            System.out.println("2. Sacar billetacos");
            System.out.println("3. Meter dineros");
            System.out.println("4. Ver historial de transacciones");
            System.out.println("5. Huir como todo un estratega");
            System.out.println("Elige sabiamente, sensei");
            opcion = scanner.nextInt();

            // Manejo de opciones
            switch (opcion) {
                case 1:
                    System.out.println("Ojito, que tienes en tu cuenta la tremenda cifra de: $ " + saldo);
                    break;

                case 2:
                    System.out.println("¿Cuánta pasta quieres llevarte, magnate?");
                    double retiro = scanner.nextDouble();
                    if (retiro > saldo || retiro <= 0) {
                        System.out.println("¡Ay, máquina! No tienes tanto dinero o acabas de intentar retirar el aire. Saldo actual: $ " + saldo);
                    } else {
                        saldo -= retiro;
                        System.out.println("Buena esa, rey. Ahora te queda: $ " + saldo);
                    }
                    break;

                case 3:
                    System.out.println("¿Cuánto dinero vas a lanzar a esta máquina de absorción monetaria?");
                    double deposito = scanner.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("¡Eso es! La cuenta crece, te quedan $ " + saldo + ", a seguir farmeando.");
                    } else {
                        System.out.println("Hermano, eso no funciona así, no me hagas llamar a los matemáticos.");
                    }
                    break;

                case 4:
                    System.out.println("Últimos movimientos: \n- No tenemos base de datos, así que imagina que ves algo aquí :D");
                    break;

                case 5:
                    System.out.println("Te vas, pero recuerda: un gran poder conlleva una gran responsabilidad. O algo así.");
                    break;

                default:
                    System.out.println("Esa opción no existe, bro. Intenta con una que sí tenga sentido.");
                    break;
            }

        } while (opcion != 5);
        scanner.close();
    }
}
