import java.util.Random;

/**
 *
 */
public class Partido {

    private int id;
    private String equipo1, equipo2;
    private int golesEquipo1, golesEquipo2;
    private float temperatura;

    /**
     *
     * @param id
     * @param equipo1
     * @param equipo2
     * @param temperatura
     */
    public Partido(int id, String equipo1, String equipo2, float temperatura) {
        this.id = id;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.temperatura = temperatura;
        resultados();
    }

    private void resultados(){
        if (temperatura < 5){
            golesEquipo1 = 0;
            golesEquipo2 = 0;
        } else {
            Random aleatorio = new Random();
            if (temperatura < 25){
                golesEquipo1 = aleatorio.nextInt(3);
                golesEquipo2 = aleatorio.nextInt(3);
            } else {
                golesEquipo1 = aleatorio.nextInt(6);
                golesEquipo2 = aleatorio.nextInt(6);
            }
        }
    }

    public String getGanador() {
        if (temperatura < 5) {
                return "Partido Cancelado";
        }
        if (golesEquipo1 == golesEquipo2){
            return "Empate";
        }
        if (golesEquipo1 > golesEquipo2){
            return equipo1;
        }
        return equipo2;
    }

    public String getPerdedor() {
        if (temperatura < 5) {
            return "Partido Cancelado";
        }
        if (golesEquipo1 == golesEquipo2){
            return "Empate";
        }
        if (golesEquipo1 > golesEquipo2){
            return equipo1;
        }
        return equipo2;
    }

    public int getId() {
        return id;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public float getTemperatura() {
        return temperatura;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "id=" + id +
                ", equipo1='" + equipo1 + '\'' +
                ", equipo2='" + equipo2 + '\'' +
                ", golesEquipo1=" + golesEquipo1 +
                ", golesEquipo2=" + golesEquipo2 +
                ", temperatura=" + temperatura +
                '}';
    }
}
