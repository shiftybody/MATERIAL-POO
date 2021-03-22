import java.util.Scanner;

public class Principal {

    private int indice;

    public void inicio() {
        indice = 0;
        Estudiante[] estudiantes = new Estudiante[3];
        for (int i = 0; i < 3; i++) {
            Estudiante newEstudiante = solicitaEstudiante();
            if (indice == estudiantes.length) {
                Estudiante[] temporal = new Estudiante[estudiantes.length + 4];
                for (int j = 0; i < indice; i++) {
                    temporal[j] = estudiantes[j];
                }
                estudiantes = temporal;
            }
            estudiantes[indice] = newEstudiante;
            indice++;
        }
        Estudiante[] porPromedio = ordenarPromedios(estudiantes);
        for (int i = 0; i < porPromedio.length; i++) {
            System.out.println(porPromedio[i]);
        }
        Estudiante[] porAlfabetico = ordenarAlfabetico(estudiantes);

        for (int i = 0; i < porAlfabetico.length; i++) {
            System.out.println(porAlfabetico[i]);
        }

    }


    private Estudiante[] ordenarAlfabetico(Estudiante[] estudiantes) {
        for (int i = 0; i < indice - 1; i++) {
            for (int j = i + 1; j < indice; j++) {
                if (estudiantes[i].getNombre().compareToIgnoreCase(
                        estudiantes[j].getNombre()) > 0) {
                    Estudiante tempo = estudiantes[j];
                    estudiantes[j] = estudiantes[i];
                    estudiantes[i] = tempo;
                }
            }
        }
        return estudiantes;
    }


    private Estudiante[] ordenarPromedios(Estudiante[] estudiantes) {
        for (int i = 0; i < indice - 1; i++) {
            for (int j = i + 1; j < indice; j++) {
                if (estudiantes[i].getPromedio() > estudiantes[j].getPromedio()) {
                    Estudiante tempo = estudiantes[j];
                    estudiantes[j] = estudiantes[i];
                    estudiantes[i] = tempo;
                }
            }
        }
        return estudiantes;
    }

    private Estudiante solicitaEstudiante() {
        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("Numero de expediente: ");
                int expediente = Integer.parseInt(in.nextLine());
                System.out.print("Nombre del estudiante: ");
                String nombre = in.nextLine();
                System.out.print("Promedio del estudiante: ");
                double promedio = Double.parseDouble(in.nextLine());
                System.out.print("Carrera del estudiante: ");
                String carrera = in.nextLine();
                return new Estudiante(expediente, nombre, carrera, promedio);

            } catch (NumberFormatException nfe) {
                System.out.println("Se esperaba un valor numerico");
            }
        }
    }

    public static void main(String[] args) {
        Principal prin = new Principal();
        prin.inicio();

    }

}
