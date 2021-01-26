import java.util.Scanner;

public class Promedio {

    public boolean esCalificacionValida (){

        boolean cadenaVlida = esCadenaValida();

        String [] valores = dividrCadena();

        double cal1 = Double.parseDouble(valores[1]);
        double cal2 = Double.parseDouble(valores[2]);
        double cal3 = Double.parseDouble(valores[3]);

        if (cadenaVlida == true){

            if(cal1 % 1 == 0 && cal2 % 1 == 0 && cal3 % 1 == 0){
                if((cal1 >= 0 && cal1 <= 100) && (cal2 >= 0 && cal2 <= 100)&& (cal3 >= 0 && cal3 <= 100)){
                    return true;

                } else {
                    System.out.println("Solo puede ingresar un número entre 0 y 100 ");
                    return false;
                }
            }else {
                System.out.println(" No se admiten números decimles");
                return false;
            }
        }
        return false;
    }

    public boolean esCadenaValida(){

        String[] valores = dividrCadena();
        if (valores.length != 3){
            return false;
        }
        return true;
    }

    public String[] dividrCadena(){

        String valor = solicitarCadena();
        String[] valores = valor.split("_");

        return valores;
    }

    public String solicitarCadena(){

        System.out.println("Ingrese la cadena de texto:  alumno_cal1_cal2_cal3");
        Scanner stdIn = new Scanner(System.in);
        String cadena = stdIn.next();

        return cadena;

    }
    public void principal(){
        double promedio = 0;

        boolean esCadenaValida = esCadenaValida();
        boolean esCalificacionValida = esCalificacionValida();

        if (esCadenaValida){
            if(esCalificacionValida){

                String [] valores = dividrCadena();

                double cal1 = Double.parseDouble(valores[1]);
                double cal2 = Double.parseDouble(valores[2]);
                double cal3 = Double.parseDouble(valores[3]);

                promedio = (cal1 + cal2 + cal3) / 3;
            }
        }else {
            System.out.println("La cadena ingresada no es valida");
        }

        System.out.println("El promedio de las calificaciones es: " + promedio);
    }

    public static void main(String[] args) {

        System.out.println(" --- Programa que determina el promedio de tres calificaciones ---");
        System.out.println(" ---         de un estudiante dado una cadena de texto         ---");

        Promedio prom = new Promedio();
        prom.principal();
    }
}
