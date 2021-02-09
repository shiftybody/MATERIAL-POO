import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherApplication {

    public static class Exceptioncatch extends Exception {
        public Exceptioncatch(String msg) {
            super("Error: " + msg);
        }
    }

    public String solution(String[] datos) {

        String name = datos[0];
        int min = Integer.parseInt(datos[2]);
        int max = Integer.parseInt(datos[2]);

        for (int i = 2; i < (datos.length); i++) {
            if (Integer.parseInt(datos[i]) > max) {
                max = Integer.parseInt(datos[i]);
            }
            if (Integer.parseInt(datos[i]) < min) {
                min = Integer.parseInt(datos[i]);
            }
        }

        return "<city> \n " +
                "      <name> " + name + "</name> \n " +
                "      <lowest_temperature> " + min + " </lowest_temperture> \n " +
                "      <highest_temperature> " + max + " </highest_temperture> \n " +
                "</city>";
    }

    public String[] dividirCadena(String cadena) {
        return cadena.split("_");

    }

    public String solicitarDatos() {
        System.out.print("[city_TEMP_minTemp1_maxTemp1 ...] > ");
        Scanner stdIn = new Scanner(System.in);
        return stdIn.nextLine();

    }

    public void principal() throws Exceptioncatch {

        String[] datos = dividirCadena(solicitarDatos());

        Pattern numberPat = Pattern.compile("[0-9]+");

        if (datos.length < 4) {
            throw new Exceptioncatch("Incomplete data. Need at least 4 tokens ");
            // Incomplete data. Need at least 4 tokens.
        } else {
            Matcher num = numberPat.matcher(datos[0]);
            if (num.matches() || datos[0].equals("TEMP")) {
                throw new Exceptioncatch("Missing city before literal TEMP");
            } else {
                if (!datos[1].equals("TEMP")) {
                    throw new Exceptioncatch("Missing literal TEMP after city");
                    // Missing literal TEMP after city
                } else {
                    if ((datos.length) % 2 != 0) {
                        throw new Exceptioncatch("Missing temperature value. Need min max pairs");
                        // Missing temperature value. Need min max pairs
                    } else {
                        for (int i = 2; i < (datos.length - 1); i += 2) {
                            //datos.length - 1 para evitar NullPointerException y comprobamos en pares
                            if (Integer.parseInt(datos[i]) > Integer.parseInt(datos[i + 1])) {
                                throw new Exceptioncatch("minTemp " + datos[i] + " > maxTemp " + datos[i + 1]);
                                // minTemp valor1 > maxTemp valor2
                            }
                        }
                    }
                }
            }
        }
        //si no ocurre ningun Exception desplegamos el numero mayor y menor
        System.out.println(solution(datos));
    }

    public static void main(String[] args) {
        while (true) {
            try {
                WeatherApplication wA = new WeatherApplication();
                wA.principal();
                break;

            } catch (NumberFormatException e) {
                System.out.println("Error: Incorrect number format: " + e.toString());
                // Incorrect number format: java.lang.NumberFormatException: For input string

            } catch (Exceptioncatch e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
