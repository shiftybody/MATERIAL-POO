public class Revista extends Publicacion implements Prestable{

    private final int numero;

    /**
     *
     * @param codigo
     * @param titulo
     * @param año
     * @param numero
     */
    public Revista(String codigo, String titulo, int año, int numero) {
        super(codigo, titulo, año);
        this.numero = numero; // pasamos como parametro el numero al crearlo.
    }

    @Override
    public void prestar() {

    }

    @Override
    public void devolver() {

    }

    @Override
    public boolean prestado() {
        return false;
    }

    @Override
    public String toString() {
        return "Revista{" +
                "numero=" + numero +
                '}';
    }
}