import java.util.Scanner;

public class SecondsCalculator {

    public String[] separarDatos(String cadena) {
        return cadena.split(":");

    }

    public String solicitarDatos() {
        System.out.print("time [hours:minutes:seconds]> ");
        Scanner stdIn = new Scanner(System.in);
        return stdIn.nextLine();

    }

    public void principal() throws Exception {

        String[] dato = separarDatos(solicitarDatos());

        if (dato.length != 3) {
            throw new Exception();

        } else {

            int horas = Integer.parseInt(dato[0]);
            int minutos = Integer.parseInt(dato[1]);
            int segundos = Integer.parseInt(dato[2]);

            int newHoras, newMinutos, newSegundos;


            if (horas >= 0 && horas <= 24) {
                if (horas == 24 && (minutos != 0 || segundos != 0)) {
                    throw new Exception();
                }

                if (minutos >= 0 && minutos <= 60) {
                    if (minutos == 60 && segundos != 0) {
                        throw new Exception();
                    }

                    if (segundos >= 0 && segundos <= 60) {
                        newSegundos = segundos;
                        newMinutos = minutos * 60;
                        newHoras = horas * 3600;
                        int seconds = newHoras + newMinutos + newSegundos;
                        System.out.println(
                                "The number of seconds is: " + seconds);

                    } else throw new Exception();
                } else throw new Exception();
            } else throw new Exception();
        }
    }


    public static void main(String[] args) {

        System.out.println(">java SecondsCalculator");

        while (true) {
            try {
                SecondsCalculator Calc = new SecondsCalculator();
                Calc.principal();
                break;

            } catch (NumberFormatException e) {
                System.out.println(
                        "java.lang.NumberFormatException: " + e.getMessage());

            } catch (Exception e) {
                System.out.println(
                        "Invalid input");
            }
        }
    }
}