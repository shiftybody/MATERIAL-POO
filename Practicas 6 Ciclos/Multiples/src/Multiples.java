import java.util.Scanner;

public class Multiples {

    public void principal() throws Exception {

        String estado = null;
        do {
            System.out.println("Elija un número");
            Scanner stdIn = new Scanner(System.in);
            int number = Integer.parseInt(stdIn.nextLine());

            if (number < 0 ){
                throw new Exception();
            }else {

                int newnumber = number;
                for (int i = 0; i < 12  ; i++){
                    System.out.println(number +  "x" + (i+1) +" = " + newnumber);
                    newnumber = number * (i+2);

                }
                do {
                    System.out.print("Enter 0 to exit or 1 to continue : ");
                    estado = stdIn.nextLine();

                    if (!estado.equals("0") && !estado.equals("1")) {
                        System.out.println("the option entered is not valid");

                    }

                }while (!estado.equals("0") && !estado.equals("1"));

            }
        }while (!estado.equals("0"));

    }
    public static void main(String[] args) {

        Multiples num = new Multiples();

        while (true) {
            try {


                num.principal();
                break;

            } catch (NumberFormatException e) {
                System.out.println("Se esperaba ingresar valores numericos enteros");

            } catch (Exception e){
                System.out.println("El número ingresado debe ser positivo");
            }
        }
    }
}
