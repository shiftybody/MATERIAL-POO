/**
 *
 */
public class Equipo {

    private String nombre;
    private int victorias, derrotas, empates, golesMarcados, golesPermitidos;

    // cómo el nombre del equipo es el unico que no va a cambiar
    // cuando se crea la instancia de una clase podemos asignarle un valor a la variable

    public Equipo(String nombre) {

        this.nombre = nombre;
        victorias = 0;
        derrotas = 0;
        empates = 0;
        golesMarcados =0;
        golesPermitidos =0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public void incVictorias() {
        this.victorias ++;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void incDerrotas() {
        this.derrotas ++;
    }

    public int getEmpates() {
        return empates;
    }

    public void incEmpates() {
        this.empates ++;
    }

    public int getGolesMarcados() {
        return golesMarcados;
    }

    public void setGolesMarcados(int golesMarcados) {
        this.golesMarcados = golesMarcados;
    }

    public int getGolesPermitidos() {
        return golesPermitidos;
    }

    public void setGolesPermitidos(int golesPermitidos) {
        this.golesPermitidos = golesPermitidos;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", victorias=" + victorias +
                ", derrotas=" + derrotas +
                ", empates=" + empates +
                ", golesMarcados=" + golesMarcados +
                ", golesPermitidos=" + golesPermitidos +
                '}';
    }

}
