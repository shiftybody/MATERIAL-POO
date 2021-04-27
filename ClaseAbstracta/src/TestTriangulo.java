import java.util.Scanner;

public class TestTriangulo {
    public static void main(String[] args) {
        String colorTringulo;
        double base;
        double altura;

        Scanner in = new Scanner(System.in);

        System.out.println("Introduzca el color del triangulo");
        colorTringulo = in.nextLine();
        System.out.println("Introduzca la base del triangulo");
        base = Double.parseDouble(in.nextLine());
        System.out.println("Introduzca la altura del tringulo");
        altura = Double.parseDouble(in.nextLine());

        Triangulo trin = new Triangulo(colorTringulo, base, altura);

        System.out.printf("El area del triangulo %s es: %f", trin.getColor(), trin.calucloArea());

    }
}
