
import java.util.Scanner;

public class TestCuadrado {
    public static void main(String[] args) {
        String colorCuadrado;
        double lado;
        Scanner in = new Scanner(System.in);

        System.out.println("Introduzca el color del cuadrado");
        colorCuadrado = in.nextLine();
        System.out.println("Introduzca el ldo del cuadrado");
        lado = Double.parseDouble(in.nextLine());

        Cuadrado cuad = new Cuadrado(colorCuadrado, lado);

        System.out.printf("El area del cuadrado %s es: %f", cuad.getColor(), cuad.calucloArea());
    }

}
