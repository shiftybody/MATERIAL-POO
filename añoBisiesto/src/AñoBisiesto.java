import java.util.Scanner;

public class AñoBisiesto {


    public boolean esBisiesto(int valor) {

        return (valor % 4 == 0 && valor % 100 != 0) || (valor % 400 == 0);
        //el IDE me recomendó esta otra forma de devoler el valor booleano
    }

    public int solicitaNumero() {

        System.out.println("Ingrese el año que desea calcular, ingrese 0 para salir : ");
        Scanner stdIn = new Scanner(System.in);
        int valor = Integer.parseInt(stdIn.next());
        return valor;
    }

    public void principal() {

        while (true) {
            int valor = solicitaNumero();

            if (valor != 0) {
                if (esBisiesto(valor)) {
                    System.out.println("El año ingresado es bisiesto");
                } else {
                    System.out.println("El año ingresado no es bisiesto");
                }
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(" --- programa que determina si un año es bisiesto o no ---");

        AñoBisiesto año;
        año = new AñoBisiesto();
        año.principal();
    }
}

