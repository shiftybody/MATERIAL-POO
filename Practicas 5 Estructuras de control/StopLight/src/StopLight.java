import java.util.Scanner;

public class StopLight {

    public double currentColor() {
        System.out.println("Enter a color code");
        Scanner stdIn = new Scanner(System.in);
        double valor = Double.parseDouble(stdIn.nextLine());
        return valor;
    }


    public void principal ()  {

        double valor = 0;
        String estado = null;


        do  {
            valor = currentColor();

            if (valor == 1){
                System.out.println("Next Traffic Light is green");
            }else if (valor == 2){
                System.out.println("Next Traffic Light is yellow");
            }else if (valor ==3){
                System.out.println("Next Traffic Light is red");
            }else {
                System.out.println("Invalid Color");
            }


            do {
                System.out.print("Enter 0 to exit or 1 to continue : ");
                Scanner stdIn = new Scanner(System.in);
                estado = stdIn.nextLine();

                if (!estado.equals("0") && !estado.equals("1")) {
                    System.out.println("the option entered is not valid");

                }

            }while (!estado.equals("0") && !estado.equals("1"));



        } while (!estado.equals("0"));
    }

    public static void main(String[] args) {
        /* programa que determina dada una longitud de onda en nanómetros
         * su correspindiente color en el espectro visible*/

        StopLight color = new StopLight();

        while (true){
            try {
                color.principal();
                break;

            }catch (NumberFormatException e) {
                System.out.println("Numeric entry expected");

            }
        }
    }
}
