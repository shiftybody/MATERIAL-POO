import java.util.Scanner;

public class StopLightv2 {


    public int currentColor() {
        System.out.println("Enter a color code");
        Scanner stdIn = new Scanner(System.in);
        int valor = Integer.parseInt(stdIn.nextLine());
        return valor;
    }


    public void principal ()  {

        int valor = 0;
        String estado = null;

        do  {
            valor = currentColor();

            switch (valor){
                case 1:
                    System.out.println("Next Traffic Light is green");
                    break;
                case 2:
                    System.out.println("Next Traffic Light is yellow");
                    break;
                case 3:
                    System.out.println("Next Traffic Light is red");
                    break;
                default:
                    System.out.println("Invalid Color");
                    break;
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

        StopLightv2 color = new StopLightv2();

        while (true){
            try {
                color.principal();
                break;

            }catch (NumberFormatException e) {
                System.out.println("Integer numeric entry expected");

            }
        }
    }
}
