public class Revista extends Publicacion {

    private final int number;
    public boolean disponible;

    public Revista(String code, String title, int year, int number) {
        super(code, title, year);
        this.disponible = true;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String disponible() {
        if (this.disponible) {
            return " Disponible";
        } else {
            return " No disponible";
        }
    }

    @Override
    public String toString() {
        return super.getCode() + "   " + super.getTitle() + " (" + super.getYear() + ") " + "#" + number + " " + disponible();
    }
}