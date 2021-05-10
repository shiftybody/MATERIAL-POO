
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author ThinkPad
 * @version 0.1
 */
public class CatalogoEstudiantes implements Iterable<Estudiante>{

    private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
    //private Estudiante [] estudiantes = new Estudiante[5];
    //private int indice = 0;

    /**
     *
     * @param newEstudiante
     */
    public void addEstudiante(Estudiante newEstudiante) {
        estudiantes.add(newEstudiante);

        /**  if (indice == estudiantes.length ){
         Estudiante [] temporal = new Estudiante[estudiantes.length + 4];
         for (int i = 0; i < indice; i++){
         temporal[i] = estudiantes[i];
         }
         estudiantes = temporal;
         }
         estudiantes[indice] = newEstudiante;
         indice ++;
         **/
    }

    /**
     *
     * @param expediente
     * @return
     */
    public Estudiante getEstudiante(int expediente) {
        for (Estudiante est : estudiantes) {
            if (est.getExpediente() == expediente) {
                return est;
            }
        }
        return null;
    }

    private int getPosicion(int expediente) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getExpediente() == expediente) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeEstudiante(int expediente) {
        Estudiante estTmp = getEstudiante(expediente);
        return estudiantes.remove(estTmp);

        /**
         * int pos = getPosicion(expediente);
         if (pos != -1) {
         for (int i = pos; i < indice-1; i++ ) {
         estudiantes[i] = estudiantes[i+1];
         }
         indice--;
         return true;
         }
         return false;
         **/
    }

    public int getNoEstudiantes() {
        return estudiantes.size();
    }

    public Estudiante[] getEstudianteArray() {
        return (Estudiante[]) estudiantes.toArray();
        /**
         * Estudiante [] tmp = new Estudiante[indice];
         *
         for (int i = 0; i < indice; i++) {
         tmp[i] = estudiantes[i];
         }
         return tmp;
         **/
    }

    public Estudiante[] ordenarAlfabetico(Estudiante[] estudiantes) {

        for (int i = 0; i < estudiantes.length - 1; i++) {
            for (int j = i + 1; j < estudiantes.length; j++) {
                if (estudiantes[i].getNombre().compareToIgnoreCase(
                        estudiantes[j].getNombre()) > 0 ) {
                    Estudiante tempo = estudiantes[j];
                    estudiantes[j] = estudiantes[i];
                    estudiantes[i] = tempo;
                }
            }
        }
        return estudiantes;
    }


    public Estudiante[] ordenarPromedios(Estudiante[] estudiantes) {
        for (int i = 0; i < estudiantes.length  - 1; i++) {
            for (int j = i + 1; j < estudiantes.length; j++) {
                if (estudiantes[i].getPromedio() > estudiantes[j].getPromedio()) {
                    Estudiante tempo = estudiantes[j];
                    estudiantes[j] = estudiantes[i];
                    estudiantes[i] = tempo;
                }
            }
        }
        return estudiantes;
    }

    @Override
    public Iterator<Estudiante> iterator() {
        return estudiantes.iterator();
    }
}
