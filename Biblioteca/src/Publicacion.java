public class Publicacion {  // esta clase extiende de la clase libro y revista

    // Caracteristicas comunes de libros y revistas
    private String codigo;
    private String titulo;
    private int año;

    /**
     * pasamos como parametros al momento de crear los objetos
     * @param codigo
     * @param titulo
     * @param anio
     */
    public Publicacion(String codigo, String titulo, int anio) {

        this.codigo = codigo;
        this.titulo = titulo;
        this.año = anio;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", año=" + año +
                '}';
    }

}