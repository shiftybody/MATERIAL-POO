import java.util.ArrayList;
import java.util.Iterator;

public class Sales /*implements Iterable<Order>*/ {

    private ArrayList<Order> orders = null;

    // private ArrayList<Order> orders = new ArrayList<Order>();

    public Sales(){
        orders = new ArrayList<Order>();
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public Iterator<Order> iterator(){
        return orders.iterator();
    }

    public int getNumberOfOrders(){

       int numero = 0;

        for(int i = 0;i < orders.size();i++){
            numero += 1;
        }
        return numero;
    }

      /*@Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }*/
}
