import java.io.*;

/**
 * Clase que declara un metodo para obtener el catalogo de productos
 * desde un archivo catalogo.dat
 *
 * @author Shiftybody
 * @version 0.0.2
 */
public interface CatalogLoader {

    /**
     *  Método que carga la informacion desde FileCatalogLoader a travez de esta interfaz
     *
     * @param fileName el nombre del archivo que contine el catalogo
     * @return  un catalogo de producto
     * @throws FileNotFoundException  se lanza cuando el archivo no existe
     * @throws IOException Si ocurre algun error
     * @throws DataFormatException  Si el numero de tokens es invalido o el tipo de dato es incorrecto
     *
     */

    Catalog loadCatalog(String fileName)
            throws FileNotFoundException, IOException, DataFormatException;

}
