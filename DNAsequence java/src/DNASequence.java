import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DNASequence {

    private final String sequence;

    private int numberOfA;
    private int numberOfT;
    private int numberOfC;
    private int numberOfG;


    public DNASequence(String initialSequence) {

        sequence = initialSequence;
        countNucleotides();
    }


    private void countNucleotides() {

        int index = 0;

        while (index < sequence.length()) {

            char nucleotide = sequence.charAt(index);

            if (nucleotide == 'A') {
                numberOfA++;
            } else if (nucleotide == 'T') {
                numberOfT++;
            } else if (nucleotide == 'C') {
                numberOfC++;
            } else if (nucleotide == 'G') {
                numberOfG++;
            }
            index++;
        }

    }


    public int getNumberOfA() {

        return numberOfA;
    }


    public int getNumberOfT() {
        return numberOfT;
    }


    public int getNumberOfC() {
        return numberOfC;
    }


    public int getNumberOfG() {
        return numberOfG;
    }


    public boolean twoConsecutive(char input) {

        for (int i = 0; i < sequence.length(); i++) {

            if (sequence.charAt(i) == input &&
                sequence.charAt(i + 1) == input) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {

        while (true) {
            try {

                //Solicita la cadena de DNA al usuario

                System.out.println("Ingrese la Cadena de DNA: ");
                Scanner stdIn = new Scanner(System.in);
                String DNA = stdIn.nextLine().toUpperCase();

                Pattern pat = Pattern.compile("[ACGT]+");

                Matcher mat = pat.matcher(DNA);
                if (mat.matches()) {

                    DNASequence dna = new DNASequence(DNA + " ");

                    System.out.println("La cantidad de A son " + dna.getNumberOfA());
                    System.out.println("La cantidad de T son " + dna.getNumberOfC());
                    System.out.println("La cantidad de G son " + dna.getNumberOfG());
                    System.out.println("La cantidad de C son " + dna.getNumberOfT());
                    System.out.println();

                    dna.numberOfA = 0;
                    dna.numberOfT = 0;
                    dna.numberOfG = 0;
                    dna.numberOfC = 0;

                    if (dna.twoConsecutive('A')) {
                        System.out.println(
                        "EL ADN tiene moleculas de Adenina (A) consecutivas");
                    } else {
                        System.out.println(
                        "EL ADN NO tiene moleculas de Adenina (A) consecutivas");
                    }
                    if (dna.twoConsecutive('T')) {
                        System.out.println(
                        "EL ADN tiene moleculas de Tiamina (T) consecutivas");
                    } else {
                        System.out.println(
                        "EL ADN NO tiene moleculas de Tiamina (T) consecutivas");
                    }
                    if (dna.twoConsecutive('G')) {
                        System.out.println(
                        "EL ADN tiene moleculas de Guanina (G) consecutivas");
                    } else {
                        System.out.println(
                        "EL ADN NO tiene moleculas de Guanina (G) consecutivas");
                    }
                    if (dna.twoConsecutive('C')) {
                        System.out.println(
                        "EL ADN tiene moleculas de Citosina (C) consecutivas");
                    } else {
                        System.out.println(
                        "EL ADN NO tiene moleculas de Citosina (C) consecutivas");
                    }
                    break;

                } else {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println(
                "Se esperaba una cadena con secuencias de moléculas A T G C");
            }
        }
    }
}

