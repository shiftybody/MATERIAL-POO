import java.util.Scanner;
import java.util.StringTokenizer;

public class PromedioCharAt {

    private String [] divideString(String texto, char divisor) throws ArrayIndexOutOfBoundsException{

        String acum = "";
        String[] tokens = new String[4];
        int indice = 0;
        for (int i = 0; i < texto.length(); i++){
            if (texto.charAt(i) == divisor) {
                if (acum.length() != 0){
                    tokens[indice] = acum;
                    indice++;
                    acum ="";
                }
            }
            else{
                acum += texto.charAt(i);
            }
        }
        if (acum.length() != 0){
            tokens[indice] = acum;
            indice ++;
        }
        return tokens;
    }

    public void principal(){
        while (true){
            System.out.println("Ingresa Calificacion [nombre_xxx_xxx_xxx]");
            Scanner stdIn = new Scanner(System.in);
            String texto = stdIn.nextLine();
            int acum = 0;


            try {
                String [] tokens = divideString(texto, '_');
                for (int i = 0; i < 4; i++){
                    int valor = Integer.parseInt(tokens[i]);
                    if (valor < 0 || valor > 100){
                        throw new Exception("Se esperan valores numericos entre 0 y 100");
                    }
                    acum += valor;
                }
                System.out.println("El promedio de " + tokens[0] + " es " + acum/3 );
                return;
            }catch (ArrayIndexOutOfBoundsException iob){
                System.out.println("Se ingrearon mas datos, se espera [nombre_xxx_xxx_xxx]");
            }catch (NumberFormatException nfe){
                System.out.println("Se espera un nombre y tres calificaciones numericas");
                System.out.println("Como por ejemplo Anastasio_100_100_90");
            }catch (Exception e){
                System.out.println(e.toString());
            }
        }
    }

    public static void main(String[] args) {

        PromedioCharAt prom = new PromedioCharAt();
        prom.principal();

    }
}