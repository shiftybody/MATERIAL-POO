import java.util.Scanner;
import java.util.StringTokenizer;

public class PromedioTokenizer {


    public double promedio(double cal1, double cal2, double cal3) {

        double promedio = (cal1 + cal2 + cal3) / 3;
        return promedio;

    }

    public static boolean esNumerico(String stdIn) {

        try {
            Double.parseDouble(stdIn);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String modificarValor(String valor) {

        Scanner stdIn = new Scanner(System.in);
        String valorNuevo = stdIn.nextLine();
        return valorNuevo;

    }

    public String[] verificarValores(String[] valores) {

        String[] valor = valores;
        String[] valorNuevo = new String[4];


        for (int i = 0; i <= valor.length - 1; i++) {

            try {

                double dato = Double.parseDouble(valor[i]);

                if (esNumerico(valor[i]) && (i == 0)) {
                    //falta un ciclo para comprobar que no se vuelva aingresar un numero en Alumno
                    System.out.println(" No se admiten entradas numericas en 'Alumno' que dice: " + valor[i] +
                            ". Por favor Ingresela nuevamente :");

                    valorNuevo[i] = modificarValor(valor[i]);

                } else {

                    int contador = 0;
                    do {

                        if (dato % 1 == 0) {
                            if (dato >= 0 && dato <= 100) {

                                valorNuevo[i] = String.valueOf(dato);
                                contador++;

                            } else {
                                System.out.println("Solo puede ingresar un número entre 0 y 100  en Calificación " + (i) + " " +
                                        " Por favor Ingresela nuevamente :");

                                valorNuevo[i] = modificarValor(valor[i]);
                                dato = Double.parseDouble(valorNuevo[i]);

                            }
                        } else {
                            System.out.println(" No se admiten números decimles en Calificación " + (i) +
                                    " Por favor Ingresela nuevamente :");

                            valorNuevo[i] = modificarValor(valor[i]);
                            dato = Double.parseDouble(valorNuevo[i]);

                        }

                    } while (contador < 1);
                }

            } catch (NumberFormatException e) {

                //falta un ciclo para verficiar que no se vuelva  ingresar un valor invalido
                // Si se vuelve a repetir va a ocurrir una excepción o se van a a poder ingresar valores fuera del rango

                if (!esNumerico(valor[i]) && (i != 0)) {

                    System.out.println(" No se admiten caracteres en la 'Calificacion: " + i +
                            "' Por favor Ingresela nuevamente :");

                    valorNuevo[i] = modificarValor(valor[i]);

                } else {
                    valorNuevo[i] = valor[i];
                }
            }
        }
        return valorNuevo;
    }

    public String[] dividirCadena(String cadena) {

        String valor = cadena;
        StringTokenizer st = new StringTokenizer(valor, "_");
        String[] valores = new String[st.countTokens()];


        int elementos = st.countTokens();
        for (int i= 0; i < elementos; i++){
            valores[i] = st.nextToken();
        }

        return valores;
    }


    public String solicitarCadena() {

        System.out.print(" 1.- Ingrese la entrada de la siguiente manera: alumno_cal1_cal2_cal3 \n" +
                " 2.-  '0' para salir >>  ");
        Scanner stdIn = new Scanner(System.in);
        String cadena = stdIn.nextLine();
        return cadena;
    }

    public void principal() {

        String cadena = solicitarCadena();

        while (!cadena.equals("0")) {

            String[] valores = dividirCadena(cadena);

            if (valores.length != 4) {

                System.out.println(" La longitud de la cadena es incorrecta, favor de ingresarla de nuevo \n");

            } else {
                String[] verificarValores = verificarValores(valores);

                String alumno = verificarValores[0];
                double cal1 = Double.parseDouble(verificarValores[1]);
                double cal2 = Double.parseDouble(verificarValores[2]);
                double cal3 = Double.parseDouble(verificarValores[3]);

                double promedio = promedio(cal1, cal2, cal3);

                System.out.println("El promedio de las calificaciones ingresadas " +
                        cal1 + ", " +
                        cal2 + ", y " +
                        cal3 + " del alumno " + alumno + " es: " + promedio + "\n");
            }
            cadena = solicitarCadena();
        }
    }

    public static void main(String[] args) {
        System.out.println("  --- Programa que calcula la calificacion promedio de un --- \n " +
                " estudiante a travéz de una entrada en cadena  ( usando StringTokenizer ) \n");

        PromedioTokenizer prom = new PromedioTokenizer();
        prom.principal();

    }
}
