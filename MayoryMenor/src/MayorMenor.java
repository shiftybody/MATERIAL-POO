import java.util.Scanner;

public class MayorMenor {
    // programa que lee 10 números y nos dice cual es el menor y cual es el mayor
    // pedir dos numeros y hacer multiplicacion sumanolas vale que el primer numero lo sume el numero de veces
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        System.out.println("----- Programa que calcula el mayor y menor de 10 números -----");

        double num;

        System.out.println("Ingrese el valor del numero 1 :");
        double valor = Double.parseDouble(stdIn.nextLine());

        double mayor = valor;
        double menor = valor;

        for (int i = 0; i < 9; i++) {
            System.out.println("Ingrese el valor del numero " + (i + 2) + " : ");
            num = Double.parseDouble(stdIn.nextLine());
            if (num > mayor) {
                mayor = num;
            }
            if (num < menor) {
                menor = num;
            }
        }

        if (mayor == menor) {
            System.out.println("los numeros ingesados son iguales"); // por si casualmente todos los números ingresados son los mismos
        } else {
            System.out.println("El numero mayor es :" + mayor);
            System.out.println("El numero menor es :" + menor);
        }
    }
}
