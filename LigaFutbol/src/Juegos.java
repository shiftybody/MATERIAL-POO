import java.util.ArrayList;
import java.util.Iterator;

public class Juegos implements Iterable<Partido> {

    private ArrayList<Partido> juegos;

    public Juegos() { juegos = new ArrayList<Partido>();}

    public void addPartido(Partido partido){
        juegos.add(partido);
    }

    public Partido getPartido(int indice) {
        return juegos.get(indice);
    }

    @Override
    public Iterator<Partido> iterator() {
        return juegos.iterator();
    }
}
