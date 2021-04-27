/**
 * Crea una matriz de los equipos que gestionar[a el programador.
 * Imprime las estad[isticas del equipo cuando termine la temporada.
 * @author Shiftybody
 */
public class Participantes {

    private final Equipo [] equipos;
    private int indice;

    public Participantes(){
        equipos = new Equipo[4];
        indice = 0;
    }

    public void addEquipo(Equipo equipo){
        equipos[indice] = equipo;
        indice ++;
    }

    public Equipo getEquipo(int posicion){
        if (posicion < 4){
            return equipos[posicion];
        }
        return null;
    }



}
