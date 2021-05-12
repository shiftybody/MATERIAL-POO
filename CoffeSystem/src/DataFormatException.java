/**
 *Excepcion que se lanza cuando:
 *
 *  La línea no tiene el número de tokens esperado
 *  Los tokens se deben contener números, no lo hacen
 *
 * Derivada de la clase Exception cómo una excepción propia
 *
 * @author author Shiftybody
 * @version 0.0.2
 */
public class DataFormatException extends Exception  {

    /**
     * Esta excepción se lanza con un NumberFormatException
     * o un Array IndexOutofbounds
     *
     * @param message devuelve la linea donde se encontro la excepción
     */
    public DataFormatException(String message) {
        super(message);
    }
}
