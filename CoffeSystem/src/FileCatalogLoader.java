import java.io.*;
import java.util.*;

/**
 * Clase FileCatalogLoader que implementa CatalogLoader.
 * Se utiliza para obtener un catágolo de productos desde un archivo
 * FileName: catalog.dat
 *
 * @author Shiftybody
 * @version 0.0.2
 */
public class FileCatalogLoader implements CatalogLoader {

    private final static String separator = "_";
    private final static String prodPref = "Product";
    private final static String cofPref = "Coffee";
    private final static String brewPref = "Brewer";

    /**
     *lee una linea de datos identificada como accesorio de producto,
     *esta linea es recibida desde el método public Catalog loadCatalog de esta clase.
     * y la separa utilizando StringTokenizer.
     *
     * Una propuesta de solución diferente a StringTokenizer es String.split().
     *
     * @param line cadena que contiene el prefijo Product
     * @return un objeto del tipo Product
     * @throws DataFormatException si la línea tiene errores (especficados en la clase DataFormatException)
     */
    private Product readProduct(String line) throws DataFormatException{
        //para este caso en lugar de almacenarlo en un array cómo en ejercicios anteriores
        //podemos utilizar la función miembro nextToken().
        StringTokenizer st = new StringTokenizer(line, separator);

        if (st.countTokens() != 4) {
            throw new DataFormatException("Expected in:  " + line + "\n  Format: Product_code_description_price");

        } else {
            try {
                st.nextToken();
                String code = st.nextToken();
                String description = st.nextToken();
                double price = Double.parseDouble(st.nextToken());

                return new Product(code,description,price);

            }catch(NumberFormatException  nfe){
                // lanzamos la excepción DataFormatException cuando existe un NumberFormatException
                throw new DataFormatException("Expected in:  " + line + "\n  Price double type");
            }
        }
    }

    /**
     *lee una linea de datos identificada como café,
     *la separa utilizando StringTokenizer.
     *
     * @param line cadena que contien el prefijo Coffee
     * @return un objeto del tipo Coffee
     * @throws DataFormatException si la línea tiene errores
     */
    private Coffee readCoffee(String line) throws DataFormatException{
        StringTokenizer st = new StringTokenizer(line, separator);

        if (st.countTokens() != 10) {
            throw new DataFormatException("Expected in:  " + line +
                    "\n  Format: Coffee_code_description_price_origin_roast_flavor_aroma_acidity_body");

        } else {
            try {
                st.nextToken();
                String code = st.nextToken();
                String description = st.nextToken();
                double price = Double.parseDouble(st.nextToken());
                String origin = st.nextToken();
                String roast = st.nextToken();
                String flavor = st.nextToken();
                String aroma = st.nextToken();
                String acidity = st.nextToken();
                String body = st.nextToken();

                return new Coffee(code,description,price,origin,
                        roast,flavor,aroma,acidity,body);

            }catch(NumberFormatException  nfe){
                throw new DataFormatException("Expected in:  " + line + "\n  Price double type");
            }
        }
    }

    /**
     *lee una linea de datos identificada como máquina de preparacion de café,
     *la separa utilizando StringTokenizer.
     *
     * @param line cadena que contien el prefijo Brewer
     * @return un objeto del tipo Brewer
     * @throws DataFormatException si la línea tiene errores
     */
    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException{
        StringTokenizer st = new StringTokenizer(line, separator);

        if (st.countTokens() != 7) {
            throw new DataFormatException("Expected in:  " + line +
                    "\n  Format: CoffeeBrewer_code_description_price_model_waterSupply_numberOfCups");

        } else {
            try {
                st.nextToken();
                String code = st.nextToken();
                String description = st.nextToken();
                double price = Double.parseDouble(st.nextToken());
                String model = st.nextToken();
                String waterSupply = st.nextToken();
                int numberOfCups = Integer.parseInt(st.nextToken());

                return new CoffeeBrewer(code,description,price,
                        model,waterSupply,numberOfCups);

            }catch(NumberFormatException  nfe){
                throw new DataFormatException("Expected in:  " + line + "\n  Price Double | numberOfCups Integer");
            }
        }
    }

    /**
     * Método que carga la información del archivo especificado en un catalogo de productos
     * abre el archivo para su lectura con BufferedReader utilizando String(line).startWith
     *
     * @param filename nombre del archivo con el catalogo de productos catalog.dat
     * @return el catalog de productos.
     * @throws FileNotFoundException si el archivo especificado no existe
     * @throws IOException Si hay algun error al leer la información del archivo especificado
     * @throws DataFormatException si una linea tienen error (indicando cual es la linea con errores)
     */

    public Catalog loadCatalog(String filename)
            throws FileNotFoundException,IOException, DataFormatException{

        BufferedReader fileIn =	new BufferedReader(new FileReader(filename));
        Catalog catalog = Catalog.getSingletonInstance();

        String line = fileIn.readLine();

        while(line != null) {

            Product product = null;

            if (line.startsWith(prodPref)) {
                product = readProduct(line);
            } else if (line.startsWith(cofPref)) {
                product = readCoffee(line);
            } else if (line.startsWith(brewPref)) {
                product = readCoffeeBrewer(line);
            } else {
                throw new DataFormatException("Prefix espected in: " + line);
            }

            catalog.addProduct(product);
            line =  fileIn.readLine();
        }
        return catalog;
    }

}
