import java.util.Vector;

public class Biblioteca {
    public static void main(String[] args) {
        Vector<Publicacion> biblical = new Vector<Publicacion>();

        biblical.add(new Revista("C001", "Batman", 1920,3));
        biblical.add(new Revista("C002", "Superman", 2003,12));
        biblical.add(new Revista("C003", "Flash", 1543,34));
        biblical.add(new Revista("B001", "Chespirito", 2344 ,1));
        biblical.add(new Revista("B002", "", 1403,43));
        biblical.add(new Revista("B003", "Batman", 3451,34));

        biblical.add(new Libro("A001", "Los cuentos de Anna Frank", 2001));
        biblical.add(new Libro("A002", "hOLA que hace", 2001));
        biblical.add(new Libro("A003", "Oceano Poque", 2001));
        biblical.add(new Libro("D004", "La tarea que facil", 2001));
        biblical.add(new Libro("D005", "Electicidad y magnetismo", 2001));
        biblical.add(new Libro("D006", "Electricidad y magnetismo", 2001));

        for (Publicacion pub :
             biblical) {
            System.out.println(biblical);
        }
    }
}
