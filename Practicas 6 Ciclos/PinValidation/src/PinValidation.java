import java.util.Scanner;

public class PinValidation {

    public void principal(){

        int pinValido = 15103106; // el paso 1 solicita declarar el valor de pin desde el código
        int pinIngresado = 0;

        while (pinIngresado != pinValido) {

            System.out.println("Ingrese su pin bancario: ");
            Scanner stdIn = new Scanner(System.in);
            pinIngresado = Integer.parseInt(stdIn.nextLine());

            if (pinIngresado != pinValido) {
                System.out.println("El pin ingresado es incorrecto , vuelva a ingresarlo: ");
            }else{
                System.out.println("pin ingresado correctamente ");
                break;
            }

        }
    }
    public static void main(String[] args) throws Exception {

        PinValidation val = new PinValidation();

        while (true) {
            try {

                val.principal();
                break;

            } catch (NumberFormatException e) {
                System.out.println("Se esperaba ingresar valores numericos enteros");

            }
        }
    }
}
