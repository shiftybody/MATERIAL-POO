import java.util.Scanner;

public class Principal {

    private static Scanner in = new Scanner(System.in);

    private int opciones () {
        while (true){
            try{
                String cadena = " *** Opciones ***";
                cadena += "\n1: Agregar estudiante";
                cadena += "\n2: Buscar estudiante";
                cadena += "\n3: Borrar estudiante";
                cadena += "\n4: Obtener numero de  estudiante";
                cadena += "\n5: Desplegar Estudiantes";
                cadena += "\n  Escribe el numero de la opcion que qieres realizar: ";
                System.out.print(cadena);
                int opcion = Integer.parseInt(in.nextLine());

                if (opcion >= 0 && opcion < 6){
                    return opcion;
                }

            }catch (NumberFormatException nfe){
                System.out.println("Elige una opción valida");
            }
        }
    }

    private int solicitaExpediente(){
        while (true){
            try {
                System.out.print("Numero de expediente: ");
                int expediente = Integer.parseInt(in.nextLine());
                return expediente;
            }catch (NumberFormatException nfe){
                System.out.println("Expediente Debe ser un valor numerico");
            }
        }
    }

    public void inicio() {
        CatalogoEstudiantes catalogo = new CatalogoEstudiantes();

        int opcion = 0;
        do {
            opcion = opciones();
            switch (opcion){
                case 1:
                    Estudiante newEstudiante = solicitaEstudiante();
                    catalogo.addEstudiante(newEstudiante);
                    break;
                case 2:
                    int expediente = solicitaExpediente();
                    Estudiante est = catalogo.getEstudiante(expediente);
                    System.out.println(est);
                    break;
                case 3:
                    expediente = solicitaExpediente();
                    if (catalogo.removeEstudiante(expediente)){
                        System.out.println("estudiante eliminado con exito");
                    }else{
                        System.out.println("Estudiante no encontrado");
                    }
                    break;
                case 4:
                    System.out.println("Se tiene" + catalogo.getNumeroEstudiantes()
                            + " estudiantes ");
                    break;
                case 5:
                    Estudiante [] estudiantes;
                    estudiantes = catalogo.getEstudianteArray();
                    for (Estudiante estudiante: estudiantes){
                        System.out.println(estudiante);
                    }
                    break;
                case 0:
                    System.out.println(" ADIOS");
                    break;
            }
        }while (opcion !=0);
    }

/*
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
    } */

    private Estudiante solicitaEstudiante() {
        while (true) {
            try {
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
