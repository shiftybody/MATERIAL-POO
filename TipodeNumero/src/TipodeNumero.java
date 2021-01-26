import java.util.Scanner;

public class TipodeNumero {

    public boolean esPar(int valor) {
        if (valor % 2 == 0) {
            return true;
        }
        return false;
    }

    public boolean esPrimo(int valor) {

        for (int i = 2; i < valor / 2; i++) {
            if (valor % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solicitaNumero() {
        System.out.print("Escribe un numero, 0 si quieres salir :");
        Scanner stdIn = new Scanner(System.in);
        int valor = Integer.parseInt(stdIn.nextLine());
        return valor;
    }

    public void principal() {

        int par = 0;
        int impar = 0;
        int primos = 0;

        while (true) {
            int valor = solicitaNumero();

            if (valor == 2) {
                primos++;
            }

            if (valor != 0) {
                if (esPar(valor)) {
                    par++;
                } else {
                    if (esPrimo(valor)) {
                        primos++;
                    }
                    impar++;
                }


            } else {
                System.out.println("Se encontraron " + par + " numeros pares");
                System.out.println("Se encontraron " + impar + " numeros impares");
                System.out.println("Se encontraron " + primos + " numeros primos");
                return;
            }
        }
    }

    public static void main(String[] args) {

        TipodeNumero num; // crearoms referencia tipo num
        num = new TipodeNumero(); // creamos un opbjeto
        num.principal(); //

    }
}
