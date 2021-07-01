import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    private static final Scanner stdIn = new Scanner(System.in);
    private final ArrayList<Publicacion> publicaciones = new ArrayList<>();

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.principal();

    }

    private Biblioteca() {
        loadPublicaciones();
    }


    private void principal() {

        while (true) {
            int option = getOption();
            switch (option) {
                case 1 -> displayPublicaciones();
                case 2 -> infPublicacion();
                case 3 -> displayAction();
                case 0 -> {
                    System.out.println("Proceso finalizado");
                    return;
                }
                default -> System.out.println("Opción invalida: " + option);
            }
        }
    }


    private void displayAction() {
        do {
            try {
                System.out.println("[0] Volver \n" +
                        "[1] Prestar Publicación \n" +
                        "[2] Devolver Publicación \n ");

                int opc = Integer.parseInt(stdIn.nextLine());

                switch (opc) {
                    case 1:
                        prestar();
                        return;
                    case 2:
                        devolver();
                        return;
                    case 0:
                        return;
                    default:
                        System.out.println("Opción invalida: " + opc);
                }

            } catch (NumberFormatException nfe) {
                System.out.println("Error: Formato Incorrecto: " + nfe.getMessage());
            }
        } while (true);
    }

    private void prestar() {
        Publicacion publicacion = getPublicacionCode();

        if (publicacion instanceof Libro) {
            Libro libro = (Libro) publicacion;
            if (libro.prestado().equals(" Disponible")) {
                System.out.println("Libro prestado exitosamente");
                libro.prestar();
            } else {
                System.out.println("Error: El libro no se encuentra disponible");
            }
        } else if (publicacion instanceof Revista) {
            Revista revista = (Revista) publicacion;
            if (revista.disponible().equals(" Disponible")) {
                System.out.println("Revista prestada exitosamente");
                revista.setDisponible(true);
            } else {
                System.out.println("Error: La revista no se encuentra disponible");
            }
            revista.setDisponible(false);
        }
    }

    private void devolver() {

        Publicacion publicacion = getPublicacionCode();

        if (publicacion instanceof Libro) {
            Libro libro = (Libro) publicacion;
            if (libro.prestado().equals(" No disponible")) {
                System.out.println("Libro devuelto exitosamente");
                libro.devolver();
            } else {
                System.out.println("Error: El libro no se encuentra disponible para devolver, o no ha sido prestado aún");
            }
        } else if (publicacion instanceof Revista) {
            Revista revista = (Revista) publicacion;
            if (revista.disponible().equals(" No disponible")) {
                System.out.println("Revista devuelta exitosamente");
                revista.setDisponible(false);
            } else {
                System.out.println("Error: La revista no se encuentra disponible para devolver, o no ha sido prestada aún");
            }
            revista.setDisponible(true);
        }
    }

    private void infPublicacion() {

        Publicacion publicacion = getPublicacionCode();

        System.out.println(
                "Título: " + publicacion.getTitle() + "\n" +
                        "Año: " + publicacion.getYear()
        );

        if (publicacion instanceof Libro) {
            Libro libro = (Libro) publicacion;

            System.out.println(
                    "Estado: " + libro.prestado()
            );
        } else if (publicacion instanceof Revista) {
            Revista revista = (Revista) publicacion;

            System.out.println(
                    "Número: " + revista.getNumber() + "\n" +
                            "Estado: " + revista.disponible()
            );
        }

    }

    private Publicacion getPublicacion(String code) {
        for (Publicacion pub :
                publicaciones) {
            if (pub.getCode().equals(code)) {
                return pub;
            }
        }
        return null;
    }

    private Publicacion getPublicacionCode() {

        do {
            System.out.println();
            System.out.print("  Ingrese el código > ");

            Publicacion publicacion = getPublicacion(stdIn.nextLine());

            if (publicacion != null) {
                return publicacion;
            } else {
                System.out.println("Publicación no encontrada. Código incorrecto");
            }
        } while (true);


    }

    private void displayPublicaciones() {

        for (Publicacion pub :
                publicaciones) {
            System.out.println(pub);
        }
    }

    private int getOption() {
        do {
            try {
                System.out.print(
                        """

                                [0] Salir
                                [1] Mostrar Publicaciones
                                [2] Información de Publicación
                                [3] Pedir prestado o devolver Publicación
                                                        
                                """
                );
                return Integer.parseInt(stdIn.nextLine());

            } catch (NumberFormatException nfe) {
                System.out.println("Error: Formato Incorrecto: " + nfe.getMessage());
            }
        } while (true);
    }

    private void loadPublicaciones() {

        publicaciones.add(new Libro("L001", "Aventuras de Sherlock Holmes", 2013));
        publicaciones.add(new Libro("L002", "Hombres de Metal", 2015));
        publicaciones.add(new Libro("L003", "Tormenta", 2013));

        publicaciones.add(new Revista("R001", "Nature", 2010, 140));
        publicaciones.add(new Revista("R002", "Forbes", 2018, 30120));
        publicaciones.add(new Revista("R003", "Science", 2020, 9179));

    }
}
