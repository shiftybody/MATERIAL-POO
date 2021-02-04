import java.util.Scanner;

public class ColorRange {

    public static double solicitarDato(){
        System.out.println("Enter a color code . press 0 to exit:");
        Scanner stdIn = new Scanner(System.in);
        double valor = Double.parseDouble(stdIn.nextLine());
        return valor;
    }

    public void principal () {
        double valor = 0;
        do  {
            valor = solicitarDato();

            if (valor >= 380 && valor <= 450) {
                System.out.println("The color is Violet");
            } else if (valor >= 450 && valor <= 496) {
                System.out.println("The color is Blue");
            } else if (valor >= 495 && valor <= 570) {
                System.out.println("The color is Green");
            } else if (valor >= 570 && valor <= 590) {
                System.out.println("The color is Yellow");
            } else if (valor >= 590 && valor <= 620) {
                System.out.println("The color is Orange");
            } else if (valor >= 620 && valor <= 750) {
                System.out.println("The color is Red");
            } else if (valor != 0){
                System.out.println("The entered wavelength is not a part of the visible spectrum");
            }
        } while (valor != 0);
    }

    public static void main(String[] args) {
        /* programa que determina dada una longitud de onda en nanómetros
         * su correspindiente color en el espectro visible*/
        ColorRange color = new ColorRange();

        while (true){
            try {
                color.principal();
                break;

            }catch (NumberFormatException e) {
                System.out.println("Numeric entry expected");
            }
        }
    }
}
