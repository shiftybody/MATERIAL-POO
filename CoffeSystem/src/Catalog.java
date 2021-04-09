/**
 * Clase que modela un catálogo de productos.
 * Implementando la interfaz Iterable<Product>
 * @author Shiftybody
 * @version 0.2
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Catalog  /*implements Iterable<Product> */ {

    private ArrayList<Product> products = null;
    // private ArrayList<Product> products = new ArrayList<Product>();

    /**
     * Crea la colección products, que inicialmente está vacío.
     */
    public Catalog(){
        products = new ArrayList<Product>();
    }

    /**
     * Añade el producto especificado a la colección products.
     * @param product entrada de producto
     */
    public void addProduct (Product product){
        products.add(product);
    }

    /**
     * Regresa un iterador sobre las instancias de la colección products.
     * @return iterator
     */
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    /**
     * Regresa una referencia a la instancia Product con el código especificado.
     * @param code entrada de codigo de producto
     * @return el producto buscado que hace referencia al codigo ingresado; null si no existe.
     */
    public Product getProduct(String code){

        for (Product prod : products) {
            if (prod.getCode().equals(code)) {
                return prod;
            }
        }
        return null;
    }

    /**
     * Regresa el número de instancias que hay en la colección products.
     * @return la cantidad de prductos dentro del catalogo.
     */
    public int getNumberOfProducts(){
         return products.size();
    }

    /*@Override
    public Iterator<Product> iterator() {
        return products.iterator();

    }*/
}
