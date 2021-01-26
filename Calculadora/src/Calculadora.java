import java.util.Scanner;

public class Calculadora {


    public double suma(int a, int b){

        double resultado = a + b;
        return resultado;
    }

    public double resta(int a, int b){
        double resultado = a - b;
        return resultado;
    }

    public double multiplicion(int a, int b){

        double resultado = a * b;
        return resultado;
    }

    public double division(int a, int b){
        double resultado = a / b;
        return resultado;
    }

    public double porcentaje(int a, int b){

        double resultado = a % b;
        return resultado; // esta operacion no logre conseguirla
    }

    public int valorA(){

        System.out.print("Introduzca el valor de a : ");
        Scanner stdIn = new Scanner(System.in);
        int a = Integer.parseInt(stdIn.nextLine());
        return a;
    }

    public int valorB(){

        System.out.print("Introduzca el valor de b : ");
        Scanner stdIn = new Scanner(System.in);
        int b = Integer.parseInt(stdIn.nextLine());
        return b;
    }


    public void principal(){

        int a = valorA();
        int b = valorB();

        System.out.println("Ingrese el signo de la operacion que se desa realizar: ");
        System.out.println("Suma:   + ");
        System.out.println("Resta:   - ");
        System.out.println("Multiplicación:   * ");
        System.out.println("Divsión:   / ");
        System.out.println("Residuo:   % ");

        Scanner stdIn = new Scanner(System.in);
        String operacion = stdIn.nextLine();


        if (operacion.equals("+")){
            double resultado = suma(a, b);
            System.out.print("El resulado de la operacion es: " + resultado);
        }else if (operacion.equals("-")){
            double resultado = resta(a, b);
            System.out.print("El resulado de la operacion es: " + resultado);
        }else if (operacion.equals("*")){
            double resultado = multiplicion(a, b);
            System.out.print("El resulado de la operacion es: " + resultado);
        }else if (operacion.equals("/")) {
            double resultado = division(a, b);
            System.out.print("El resulado de la operacion es: " + resultado);
        }else if (operacion.equals("%")){
            double resultado = porcentaje(a, b);
            System.out.print("El resulado de la operacion es: " + resultado);
        }

    }

    public static void main(String[] args) {

        System.out.println(" --- Calculadora simple utilizando POO ---");

        Calculadora calc;
        calc = new Calculadora();
        calc.principal();

    }
}
