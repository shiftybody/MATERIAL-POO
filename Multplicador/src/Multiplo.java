import java.util.Scanner;

public class Multiplo {
    public static void main(String[] args) {

        //pedir dos numeros y hacer multiplicacion sumandolas vale que el primer número lo sume

        Scanner stdIn = new Scanner(System.in);
        System.out.println("----- Programa multiplica dos numeros -----");

        System.out.println("Ingrese el valor del primer número: ");
        int num1 = Integer.parseInt(stdIn.nextLine());

        System.out.println("Ingrese el valor del segundo número: ");
        int num2 = Integer.parseInt(stdIn.nextLine());

        int suma = 0;

        for (int i = 0; i < num1 ; i++){
            suma = suma + num2;
        }

        System.out.println("El valor de multiplicar " + num1 +" x " + num2 + " es: " + suma);

        //programa que identifique numeros pares, impares y primos

        // variante para cuando los numeros tienen digitos

        System.out.println("----- Programa multiplica dos numeros -----");

        System.out.println("Ingrese el valor del primer número: ");
        double dnum1 = Integer.parseInt(stdIn.nextLine());

        double residuo1 = dnum1 % 1;

        System.out.println("Ingrese el valor del segundo número: ");
        double dnum2 = Integer.parseInt(stdIn.nextLine());

        double residuo2 = dnum1 % 1;

        int dsuma = 0;

        for (int i = 0; i < dnum1 ; i++){
            suma = suma + dnum2;
        }

        System.out.println("El valor de multiplicar " + dnum1 +" x " + dnum2 + " es: " + dsuma);

    }
}
