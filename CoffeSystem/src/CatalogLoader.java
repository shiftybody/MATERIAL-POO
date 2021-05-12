import java.io.*;

/**
 * @author Shiftybody
 * @version 0.3
 */
public interface CatalogLoader {
    Catalog loadCatalog(String fileName)
            throws FileNotFoundException, IOException, DataFormatException;
}
