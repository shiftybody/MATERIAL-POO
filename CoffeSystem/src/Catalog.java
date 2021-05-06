
import java.util.ArrayList;
import java.util.Iterator;


public class Catalog implements Iterable<Product> {

    private static Catalog singLetonCatalog = null;
    private final ArrayList<Product> products = new ArrayList<>();

    private Catalog() {

    }

    /**
     * Implementación del patrón Singleton
     *
     * @return una unica instancia de la clase Catalog
     */
    public static Catalog getSingletonInstance() {

        if (singLetonCatalog == null) {
            singLetonCatalog = new Catalog();
        }
        return singLetonCatalog;
    }

    /**
     * Añade el producto especificado a la colección products.
     *
     * @param product entrada de producto
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Regresa una referencia a la instancia Product con el código especificado.
     *
     * @param code entrada de codigo de producto
     * @return el producto buscado que hace referencia al codigo ingresado; null si no existe.
     */
    public Product getProduct(String code) {

        for (Product prod : products) {
            if (prod.getCode().equals(code)) {
                return prod;
            }
        }
        return null;
    }

    /**
     * Regresa el número de instancias que hay en la colección products.
     *
     * @return la cantidad de prductos dentro del catalogo.
     */
    public int getNumberOfProducts() {
        return products.size();
    }

    /**
     * Regresa un iterador sobre las instancias de la colección products.
     *
     * @return iterator
     */

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
