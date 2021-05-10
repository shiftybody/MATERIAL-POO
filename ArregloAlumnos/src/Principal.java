/**
 *
 */

import java.io.*;
import java.util.Scanner;

/**
 * @author ThinkPad
 * @version 0.2
 */
public class Principal {

    private static Scanner in = new Scanner(System.in);

    public int opciones() {
        while (true) {
            try {
                String cadena = "*** Opciones *** ";
                cadena += "\n1: Agregar estudiantes";
                cadena += "\n2: Buscar estudiante";
                cadena += "\n3: Borrar estudiantes";
                cadena += "\n4: Obtener numero de estudiantes";
                cadena += "\n5: Desplegar Estudiantes";
                cadena += "\n6: Guardar estudiantes";
                cadena += "\n7: Cargar estudiantes";
                cadena += "\n0: Salir";
                cadena += "\n Escribe el numero de la opcion que quieres realizar: ";
                System.out.print(cadena);
                int opc = Integer.parseInt(in.nextLine());
                if (opc >= 0 && opc <=7) {
                    return opc;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Elige una opcion valida");
            }
        }
    }

    private CatalogoEstudiantes cargaEstudiantes() {
        try {
            CatalogoEstudiantes catalogo = new CatalogoEstudiantes();
            FileReader file = new FileReader("estudiantes.dat");
            BufferedReader fileIn = new BufferedReader(file);
            String line = fileIn.readLine();
            while (line != null) {
                String [] datosEstudiante = line.split("_");
                catalogo.addEstudiante(new Estudiante(Integer.parseInt(datosEstudiante[0]), datosEstudiante[1], datosEstudiante[2], Double.parseDouble(datosEstudiante[3])));
                System.out.println(line);
                line = fileIn.readLine(); // cerrar fileIn
            }
            fileIn.close();
            return catalogo;
        } catch (IOException ioe) {
            System.out.println("No se puede leer el archiv0");
        }
        return null;
    }

    private void guardaEstudiantes(CatalogoEstudiantes catalogo) {
        try {
            FileWriter archivo = new FileWriter("estudiantes.dat");
            PrintWriter fileOut = new PrintWriter(archivo);

            for (Estudiante estudiante : catalogo) {
                fileOut.println(estudiante.getExpediente() + "_" + estudiante.getNombre() +
                        "_" +estudiante.getCarrera() + "_" + estudiante.getPromedio());
            }
            fileOut.close();
            System.out.println("Estudiante agregados");
        } catch (IOException ioe) {
            System.out.println("No se puede crear o accesar al archivo");
            return;
        }
    }

    private int solicitaExpediente() {
        while (true) {
            try {
                System.out.print("Numero de expediente: ");
                int expediente = Integer.parseInt(in.nextLine());
                return expediente;
            } catch (NumberFormatException nfe) {
                System.out.println("Expediente es un valor numerico");
            }
        }
    }


    public void inicio() {
        CatalogoEstudiantes catalogo = new CatalogoEstudiantes();
        int opc = 0;
        do {
            opc = opciones();
            switch (opc) {
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
                    if (catalogo.removeEstudiante(expediente)) {
                        System.out.println("Estudiante eliminado con exito");
                    } else {
                        System.out.println("Ese estudiante no se encontraba en la BD");
                    }
                    break;
                case 4:
                    System.out.println("Se tienen " + catalogo.getNoEstudiantes()
                            + " estudiantes");
                    break;
                case 5:
                    /*
                     * Estudiante [] estudiantes;
                     *	estudiantes = catalogo.getEstudianteArray();
                     */
                    for (Estudiante estudiante : catalogo) {
                        System.out.println(estudiante);
                    }
                case 6:
                    guardaEstudiantes(catalogo);
                    break;
                case 7:
                    catalogo = cargaEstudiantes();
                    break;
                case 0:
                    System.out.println("='(  Adios");
                    break;
            }
        } while (opc != 0);
    }


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

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Principal prin = new Principal();
        prin.inicio();

    }

}
