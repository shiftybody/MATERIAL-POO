import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class CalcularAreas {

        public double Circulo(double radio){
            System.out.println("El area del circulo es: ");

            return Math.PI * Math.pow(radio,2);

        }
        public double Cuadrado(double lado){
            System.out.println("El area del cuadrado es: ");

            return lado * lado;

        }
        public double Rectangulo(double base, double altura){
            System.out.println("El area del rectangulo es: ");

            return base * altura;
        }
        public double Triagulo(double base, double altura){
            System.out.println("El area del triangulo es: ");

            return (base * altura)/2;
        }

        public void Principal() throws Exception {

            Scanner stdIn = new Scanner(System.in);
            System.out.println("Ingrese la opción correspondiente al area \n " +
                    "de la figura que desea calcular" +
                    "1:  Circulo \n" +
                    "2:  Cuadrado \n" +
                    "3:  Rectangulo \n" +
                    "4:  Triangulo \n");

            int opcion = Integer.parseInt(stdIn.nextLine());


            switch (opcion){
                case 1:
                    System.out.println("Ingrese la longitud del radio: ");
                    System.out.println(Circulo(Double.parseDouble(stdIn.nextLine())));
                    break;
                case 2:
                    System.out.println("Ingrese la longitud de uno de los lados: ");
                    System.out.println(Cuadrado(Double.parseDouble(stdIn.nextLine())));
                    break;
                case 3:
                    System.out.println("Ingrese la longitud de la base: ");
                    double base = Double.parseDouble(stdIn.nextLine());
                    System.out.println("Ingrese la longitud de la altura");
                    double altura = Double.parseDouble(stdIn.nextLine());

                    System.out.println(Rectangulo(base, altura));

                    break;
                case 4:

                    System.out.println("Ingrese la longitud de la base: ");
                    double baseT = Double.parseDouble(stdIn.nextLine());
                    System.out.println("Ingrese la longitud de la altura");
                    double alturaT = Double.parseDouble(stdIn.nextLine());

                    System.out.println(Triagulo(baseT, alturaT));

                    break;

                default:
                        throw new Exception();
            }
        }

        public static void main(String[] args) {

            System.out.println("Calculadora de Areas");

            while(true){

                try{
                    CalcularAreas num = new CalcularAreas();
                    num.Principal();
                    break;

                }catch (NumberFormatException e){
                    System.out.println("Se esperaba una opcion numerica");

                }catch (Exception e){
                    System.out.println(" Valor incorrecto ");
                }

            }
        }
    }

