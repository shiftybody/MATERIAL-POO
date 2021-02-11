import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumerosRomanos {
    // Este caso cae en excepciones como por ejejmplo no validar una cantidad de
    // de veces que podemos recibir una literal

    public void Principal() throws Exception {
        System.out.print("Ingrese el número Romano que desea convertir: ");
        Scanner stdIn = new Scanner(System.in);
        String secuens =stdIn.nextLine();

        Pattern pat = Pattern.compile("[IVXLCDM]+");
        Matcher mat = pat.matcher(secuens);

        if (mat.matches()) {

            String secuencia =  " " + secuens;
            int n = secuencia.length();
            int s = 0;


            for (int i = 0; i < n;i++){

                if (secuencia.charAt(i) == 'M'){
                    s = s+1000;
                    if (secuencia.charAt(i-1) == 'C'){
                        s = s-200;
                    }
                }
                if (secuencia.charAt(i) == 'D'){
                    s = s+500;
                    if (secuencia.charAt(i-1) == 'C'){
                        s = s-200;
                    }
                }
                if (secuencia.charAt(i) == 'C'){
                    s = s+100;
                    if (secuencia.charAt(i-1) == 'X'){
                        s = s-20;
                    }
                }
                if (secuencia.charAt(i) == 'L'){
                    s = s+50;
                    if (secuencia.charAt(i-1) == 'X'){
                        s = s-20;
                    }
                }
                if (secuencia.charAt(i) == 'X'){
                    s = s+10;
                    if (secuencia.charAt(i-1) == 'I'){
                        s = s-2;
                    }
                }
                if (secuencia.charAt(i) == 'V'){
                    s = s+5;
                    if (secuencia.charAt(i-1) == 'I'){
                        s = s-2;
                    }
                }
                if (secuencia.charAt(i) == 'I'){
                    s = s+1;
                }

            }

            System.out.println(secuencia + " (" + s+ ")");

        } else {
            throw new Exception("e");

        }


    }

    public static void main(String[] args) {

        while(true){
            try{
                NumerosRomanos num = new NumerosRomanos();
                num.Principal();
                break;

            }catch (Exception e){
                System.out.println("Error: solo se permiten IVXLCDM ");
            }
        }
}
}