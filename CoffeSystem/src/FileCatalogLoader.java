import java.io.*;
import java.util.*;
/**
 * Clase FileCatalogLoader
 *
 * @author oortega
 */
public class FileCatalogLoader {

    private final static String DELIM = "_";
    private final static String PRODUCT_PREFIX = "Product";
    private final static String COFFEE_PREFIX = "Coffee";
    private final static String BREWER_PREFIX = "Brewer";

    private Product readProduct(String line) throws DataFormatException{
        StringTokenizer x = new StringTokenizer(line, DELIM);

        if (x.countTokens() != 4) {
            throw new DataFormatException(line);

        } else {
            try {
                String prefix = x.nextToken();
                String code = x.nextToken();
                String description = x.nextToken();
                double price = Double.parseDouble(x.nextToken());

                return new Product(code,description,price);

            }catch(NumberFormatException  nfe){
                throw new DataFormatException(line);
            }
        }
    }

    private Coffee readCoffee(String line) throws DataFormatException{
        StringTokenizer read = new StringTokenizer(line, DELIM);

        if (read.countTokens() != 10) {
            throw new DataFormatException(line);

        } else {
            try {
                String prefix = read.nextToken();
                String code = read.nextToken();
                String description = read.nextToken();
                double price = Double.parseDouble(read.nextToken());
                String origin = read.nextToken();
                String roast = read.nextToken();
                String flavor = read.nextToken();
                String aroma = read.nextToken();
                String acidity = read.nextToken();
                String body = read.nextToken();

                return new Coffee(code,description,price,origin,
                        roast,flavor,aroma,acidity,body);

            }catch(NumberFormatException  nfe){
                throw new DataFormatException(line);
            }
        }
    }

    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException{
        StringTokenizer read = new StringTokenizer(line, DELIM);

        if (read.countTokens() != 7) {
            throw new DataFormatException(line);

        } else {
            try {
                String prefix = read.nextToken();
                String code = read.nextToken();
                String description = read.nextToken();
                double price = Double.parseDouble(read.nextToken());
                String model = read.nextToken();
                String waterSupply = read.nextToken();
                int numberOfCups = Integer.parseInt(read.nextToken());

                return new CoffeeBrewer(code,description,price,
                        model,waterSupply,numberOfCups);

            }catch(NumberFormatException  nfe){
                throw new DataFormatException(line);
            }
        }
    }

    public Catalog loadCatalog(String filename)
            throws FileNotFoundException,IOException, DataFormatException{

        BufferedReader reader =	new BufferedReader(new FileReader(filename));

        Catalog catalog = Catalog.getSingletonInstance();

        String line = reader.readLine();

        while(line != null) {
            Product product = null;

            if (line.startsWith(PRODUCT_PREFIX)) {
                product = readProduct(line);
            } else if (line.startsWith(COFFEE_PREFIX)) {
                product = readCoffee(line);
            } else if (line.startsWith(BREWER_PREFIX)) {
                product = readCoffeeBrewer(line);
            } else {
                throw new DataFormatException(line);
            }

            catalog.addProduct(product);
            line =  reader.readLine();
        }

        return catalog;
    }

}
