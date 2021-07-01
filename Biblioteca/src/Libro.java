public class Libro extends Publicacion implements Prestable {

    private boolean prestado;

    public Libro(String code, String title, int year) {
        super(code, title, year);
        this.prestado = false;
    }

    public String getCode() {
        return super.getCode();
    }

    @Override
    public void prestar() {
        this.prestado = true;
    }

    @Override
    public void devolver() {
        this.prestado = false;
    }

    @Override
    public String prestado() {
        if (this.prestado) {
            return " No disponible";
        } else {
            return " Disponible";
        }
    }

    @Override
    public String toString() {
        return super.getCode() + "   " + super.getTitle() + " (" + super.getYear() + ") " + prestado();
    }
}