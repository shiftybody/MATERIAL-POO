
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que mantiene unalista de art[iculos de la orden.
 * Implementando la interfaz Iterable<OrderItem>
 *
 * @author Shiftybody
 * @version 0.0.2
 */

public class Order implements Iterable<OrderItem> {

    /**
     * Crea la colección items, que inicialmente está vacío.
     */
    private final ArrayList<OrderItem> items = new ArrayList<>();

    /**
     * Añade el artículo especificado en la colección items.
     *
     * @param orderItem
     */
    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }

    /**
     * Elimina el artículo especificado de la colección items, es decir la orden.
     *
     * @param orderItem
     */
    public void removeItem(OrderItem orderItem) {
        items.remove(orderItem);
    }

    /**
     * Regresa una referencia a la instancia OrderItem con el producto especificado.
     * Regresa null si no hay elemento en la orden con el producto especificado.
     *
     * @param product
     * @return itm
     */
    public OrderItem getItem(Product product) {

        for (OrderItem itm : items) {
            if (itm.getProduct().equals(product)) {
                return itm;
            }
        }
        return null;
    }

    /**
     * Regresa el número de instancias que hay en la colección items.
     *
     * @return items.size()
     */
    public int getNumberOfItems() {
        return items.size();
    }

    /**
     * Regresa el costo total de la orden
     *
     * @return costoTotal
     */
    public double getTotalCost() {

        DecimalFormat formato1 = new DecimalFormat("#.00");
        double costoTotal = 0;

        for (OrderItem ot : items) {
            costoTotal += ot.getValue();
        }

        return Math.round(costoTotal);
    }

    /**
     * Regresa un iterador sobre las instancias de la colección items.
     *
     * @return iterator
     */
    @Override
    public Iterator<OrderItem> iterator() {
        return items.iterator();
    }

}
