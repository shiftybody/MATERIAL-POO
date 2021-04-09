/**
 * Clase que mantiene una lista de las órdenes que han sid completadas.
 * Implementa la interfaz Iterable<Order>
 * @author Shiftybody
 * @version 0.2
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Sales /*implements Iterable<Order>*/ {

    /**
     * ArrayList que contiene las referencias a las instancias de la clase Order.
     */

    private ArrayList<Order> orders = null;
    // private ArrayList<Order> orders = new ArrayList<Order>();

    /**
     * Crea la colección orders, que inicialmente está vacío.
     */
    public Sales(){
        orders = new ArrayList<Order>();
    }

    /**
     *Añade la orden especificada a la colección orders.
     * @param order
     */
    public void addOrder(Order order){
        orders.add(order);
    }

    /**
     *Regresa un iterador sobre las instancias de la colección orders.
     * @return iterator
     */
    public Iterator<Order> iterator(){
        return orders.iterator();
    }

    /**
     *Regresa el número de instancias que hay en la colección orders.
     * @return orders.size
     */
    public int getNumberOfOrders(){
       return orders.size();
    }

      /*@Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }*/
}
