/**
 *
 */
public class CatalogoEstudiantes {
    private Estudiante[] estudiantes = new Estudiante[5];
    private int indice = 0;

    /**
     *
     * @param newestudiante
     */
    public void addEstudiante (Estudiante newestudiante) {
        if (indice == estudiantes.length) {
            Estudiante [] temporal = new Estudiante[estudiantes.length + 4];
            for (int i = 0; i < indice; i++){
                temporal[i] = estudiantes[i];
            }
            estudiantes = temporal;
        }
        estudiantes [indice] = newestudiante;
        indice ++;
    }

    /**
     *
     * @param expediente
     * @return
     */
    public Estudiante getEstudiante(int expediente){ // para cada elemento de una coleccion has lo siguiente
        for (Estudiante est : estudiantes) {
            if (est.getExpediente() == expediente){
                return est;
            }
        }
        return null;
    }

    private int getPosicion(int expediente) {
        for (int i = 0; i < indice; i++){
            if (estudiantes[i].getExpediente() == expediente){
                return i;
            }
        }
        return -1;
    }

    public boolean removeEstudiante(int expediente) {
        int pos = getPosicion(expediente);
        if (pos != -1){
            for (int i = pos; i < indice; i++){
                estudiantes[i] = estudiantes[i +1];
            }
            indice--;
            return true;
        }
        return false;
    }
    public int getNumeroEstudiantes(){
        return indice;
    }
    public Estudiante[] getEstudianteArray(){
        Estudiante [] tmp= new Estudiante[indice];
        for (int i = 0; i < indice; i++){
            tmp[i] = estudiantes[i];
        }
        return tmp;
    }

    private Estudiante[] ordenarAlfabetico(Estudiante[] estudiantes) {
        for (int i = 0; i < indice - 1; i++) {
            for (int j = i + 1; j < indice; j++) {
                if (estudiantes[i].getNombre().compareToIgnoreCase(
                        estudiantes[j].getNombre()) > 0) {
                    Estudiante tempo = estudiantes[j];
                    estudiantes[j] = estudiantes[i];
                    estudiantes[i] = tempo;
                }
            }
        }
        return estudiantes;
    }


}
