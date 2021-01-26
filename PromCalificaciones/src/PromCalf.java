import java.util.Scanner;

public class PromCalf {
    public static void main(String[] args) {

        //recibir calificaciones de 0 a 100 sin decimales
        Scanner stdIn = new Scanner(System.in);

        int contador = 0;
        double suma = 0;
        int num = 1;

        do {

            System.out.println("Ingrese la calificación número: " + num);

            double cal = Double.parseDouble(stdIn.nextLine()); //los objetos comienzan con minuscula

            if(cal % 1 == 0){
                if(cal >= 0 && cal <= 100){
                    suma = cal + suma;
                    contador ++;
                    num ++;
                } else {
                    System.out.println("Solo puede ingresar un número entre 0 y 100 ");
                }
            }else {
                System.out.println(" No se admiten números decimles");
            }

            } while (contador < 3 );

            double promedio = suma/3;
            System.out.println("El promedio de las calificaciones ingresadas es: " + promedio);
    }
}
