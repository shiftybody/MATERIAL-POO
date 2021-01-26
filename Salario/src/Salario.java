import java.util.Scanner;

public class Salario {

    public int horasExtras(int horas) {

        int horasE = 0;

        if (horas >= 38) {
            horasE = horas - 37;
        }
        return horasE;
    }

    public double aumento( int horasE, double tasa){

        double aumento = horasE * ((tasa * .5) + tasa) ;
        return aumento;

    }

    public double salarioBruto(int horas, double tasa, double aumento) {

        double salarioB = (horas * tasa) + aumento;
        return salarioB;

    }

    public double Impuestos(double salarioB) {

        double impuestos = 0;

        if (salarioB <= 12000){
            impuestos = salarioB * 0; // por no poner impuestos = 0
        }else if (salarioB > 12000) {
            impuestos = salarioB * .1;
        }

        return impuestos;
    }

    public int solicitarHoras() {

        System.out.print("Introduzca la cantidad de horas trabajadas durante la semana:");
        Scanner stdIn = new Scanner(System.in);
        int horas = Integer.parseInt(stdIn.nextLine());
        return horas;
    }

    public double solicitarTasa() {

        System.out.print("Ingrese la tasa ordinaria :");
        Scanner stdIn = new Scanner(System.in);
        double tasa = Double.parseDouble(stdIn.nextLine());
        return tasa;
    }

    public void Principal() {

        int horas = solicitarHoras();
        double tasa = solicitarTasa();
        int horasE = horasExtras(horas);
        double aumento = aumento(horasE,tasa);
        double salarioB = salarioBruto(horas, tasa, aumento);
        double impuestos = Impuestos(salarioB);
        double salarioT = salarioB + impuestos;

        // al usuario tambien se le pueden mostrar todos los
        // los valores anteriores si es necesario

        System.out.println("El salario neto es de: " + salarioT );

    }

    public static void main(String[] args) {
        System.out.println(" ---  Programa que determina el salario neto de un trabajador, " +
                "dadas las horas por semana y la tasa : ---");

        Salario sueldo;
        sueldo = new Salario();
        sueldo.Principal();
    }
}
