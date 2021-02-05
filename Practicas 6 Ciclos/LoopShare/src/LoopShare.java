import java.util.Scanner;

public class LoopShare {

    public void createRectangle(int ancho, int alto) {

        for(int i = 0; i < ancho; i++) {
            System.out.print("* ");
        }
        System.out.println();

        if (ancho == 1){
            for (int i = 0; i < alto -1; i++)
                System.out.println("*");

        }else if (alto != 1){

            for(int i = 0; i < alto-2; i++) {
                System.out.print("*");
                for(int j = 0; j < ancho-2; j++) {
                    System.out.print("  ");
                }
                System.out.println(" *");
            }

            for(int i = 0; i < ancho; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void createTriangle(int tramo) {

        String sp = " ";

        if (tramo != 1){
            System.out.println("*");

            for(int i = 0; i < tramo-2; i++) {
                System.out.print("*");

                    System.out.print(sp);
                    sp = sp + "  ";

                System.out.println("*");
            }

            for(int i = 0; i < tramo; i++) {
                System.out.print("* ");
            }

            System.out.println();

        }else {
            System.out.println("*");
        }
    }

    public void principal() throws Exception {

        String estado = null;
        do {
            System.out.println("Ingrese la figura que desea reproducir \n" +
                    "1:   Rectangulo \n" +
                    "2:   Triangulo isoceles \n");

            Scanner stdIn = new Scanner(System.in);
            int valor = Integer.parseInt(stdIn.nextLine());

            if (valor < 1) {
                throw new Exception();
            } else {
                switch (valor) {
                    case 1:

                        System.out.println("Ingrese el ancho del rectangulo: ");
                        int ancho = Integer.parseInt(stdIn.nextLine());
                        System.out.println("Ingrese la altura del rectangulo: ");
                        int alto = Integer.parseInt(stdIn.nextLine());

                        createRectangle(ancho, alto);

                        break;
                    case 2:

                        System.out.println("Ingrese el valor del tramo del triangulo isosceles: ");
                        int tramo = Integer.parseInt(stdIn.nextLine());

                        createTriangle(tramo);

                        break;
                    default:
                        System.out.println("El valor ingresado no es valido");
                }

                do {
                    System.out.print("Ingrese 0 para salir o 1 para continuar : ");
                    estado = stdIn.nextLine();

                    if (!estado.equals("0") && !estado.equals("1")) {
                        System.out.println("La opcion ingresada no es valida ");
                    }
                } while (!estado.equals("0") && !estado.equals("1"));
            }
        } while (!estado.equals("0"));

    }

    public static void main(String[] args) {
        LoopShare fig = new LoopShare();

        while (true) {
            try {
                fig.principal();
                break;

            } catch (NumberFormatException e) {
                System.out.println("Se esperaba ingresar valores numericos enteros");

            } catch (Exception e) {
                System.out.println("El número ingresado no debe ser menor a 1");
            }
        }
    }
}
