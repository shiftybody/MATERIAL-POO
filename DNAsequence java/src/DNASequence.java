import com.sun.source.tree.CatchTree;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DNASequence {

    private int numberOfA;
    private int numberOfT;
    private int numberOfC;
    private int numberOfG;

    private String DNA;

    public void asignaDNA(String nuevoDNA) {
        DNA = nuevoDNA;
    }

    private void countNucleotides() {

        for (int i = 0; i < DNA.length(); i++) {

            if (DNA.charAt(i) == 'A') numberOfA++;
            else if (DNA.charAt(i) == 'T') numberOfT++;
            else if (DNA.charAt(i) == 'C') numberOfC++;
            else if (DNA.charAt(i) == 'G') numberOfG++;

        }
    }

    public boolean twoConsecutive(char input) {

        boolean isConsecutive = false;

        for (int i = 0; i < DNA.length(); i++) {


            if (DNA.charAt(i) == input && DNA.charAt(i + 1) == input) {
                isConsecutive = true;
                break;
            }
        }
        return isConsecutive;
    }

    public int getNumberA() {
        return numberOfA;
    }

    public int getNumberT() {
        return numberOfT;
    }

    public int getNumberG() {
        return numberOfG;
    }

    public int getNumberC() {
        return numberOfC;
    }


    public static void main(String[] args) throws Exception {

        DNASequence dna = new DNASequence();

        while (true) {
            try {

                //Solicita la cadena de DNA al usuario

                System.out.println("Ingrese la Cadena de DNA: ");
                Scanner stdIn = new Scanner(System.in);
                String DNA = stdIn.nextLine().toUpperCase();

                Pattern pat = Pattern.compile("[ACGT]+");

                Matcher mat = pat.matcher(DNA);
                if (mat.matches()) {
                    System.out.println("SI");
                } else {
                    throw new Exception("e");
                }

                dna.asignaDNA(DNA + ' ');


                dna.countNucleotides();

                System.out.println("La cantidad de A son " + dna.getNumberA());
                System.out.println("La cantidad de T son " + dna.getNumberT());
                System.out.println("La cantidad de G son " + dna.getNumberG());
                System.out.println("La cantidad de C son " + dna.getNumberC());
                System.out.println();

                dna.numberOfA = 0;
                dna.numberOfT = 0;
                dna.numberOfG = 0;
                dna.numberOfC = 0;

                if (dna.twoConsecutive('A')) {
                    System.out.println("EL ADN tiene moleculas de Adenina (A) consecutivas");
                } else {
                    System.out.println("EL ADN NO tiene moleculas de Adenina (A) consecutivas");
                }
                if (dna.twoConsecutive('T')) {
                    System.out.println("EL ADN tiene moleculas de Tiamina (T) consecutivas");
                } else {
                    System.out.println("EL ADN NO tiene moleculas de Tiamina (T) consecutivas");
                }
                if (dna.twoConsecutive('G')) {
                    System.out.println("EL ADN tiene moleculas de Guanina (G) consecutivas");
                } else {
                    System.out.println("EL ADN NO tiene moleculas de Guanina (G) consecutivas");
                }
                if (dna.twoConsecutive('C')) {
                    System.out.println("EL ADN tiene moleculas de Citosina (C) consecutivas");
                } else {
                    System.out.println("EL ADN NO tiene moleculas de Citosina (C) consecutivas");
                }
                break;

            } catch (Exception e) {
                System.out.println("Se esperaba una cadena con A T G C");
            }
        }
    }
}
