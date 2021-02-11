import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodificacionMensaje {

    public static class Exceptioncatch extends Exception {
        public Exceptioncatch(String msg) {
            super("Error: " + msg);
        }
    }

    public void principal() throws Exceptioncatch {

        Scanner stdIn = new Scanner(System.in);
        System.out.print("Ingrese mensaje a codificar: ");
        String mensaje = stdIn.nextLine().toUpperCase(); // volvemos la entrada a mayuzculas

        String codificado = "";
        String letras="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros="0123456789";

        Pattern caracteres = Pattern.compile("[!@#$%^&*()_+<>?:.{}|]+");


        if (mensaje.equals("")){
            throw new Exceptioncatch("Se esperaba una cadena");
        }

        for (int i = 0; i < mensaje.length(); i++){
            //Almacenamos el caracter que vamos a leer en una variable;
            String caracter= Character.toString(mensaje.charAt(i));

            Matcher num = caracteres.matcher(caracter);
            if (num.matches()) {
                throw new Exceptioncatch("No se permiten caracteres");}

            //Si ocurren saltos de linea
            if (caracter.equals(" ")){
                codificado += caracter;
            }
            else {

                for (int x = 0; x < letras.length(); x++){
                    if (caracter.equals(letras.substring(x, x+1 ))){
                        if (caracter.equals("Z")){
                            codificado += "A";
                            break;
                        }else {
                            codificado += letras.substring(x+1, x+2);
                            break;
                        }
                    }
                }

                for (int y =0; y < numeros.length(); y++){
                    if (caracter.equals(numeros.substring(y,y+1))){
                        if (caracter.equals("9")){
                            codificado += "0";
                            break;
                        } else {
                            codificado += numeros.substring(y+1, y+2);
                            break;
                        }
                    }
                }
            }

        }
        System.out.println("El mensaje codificado es: " + codificado );
    }

    public static void main(String[] args) {
        while (true){
         try {

            CodificacionMensaje mC = new CodificacionMensaje();
            mC.principal();
            break;

         } catch (Exceptioncatch e){
             System.out.println(e.getMessage());
         }
        }
    }

}
