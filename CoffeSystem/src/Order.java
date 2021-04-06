import java.util.ArrayList;
import java.util.Iterator;

public class Order /*implements Iterable<OrderItem> */ {

    private ArrayList<OrderItem> items = null;
    // private ArrayList<OrderItem> items = new ArrayList<OrderItem>();

    public Order(){
        items = new ArrayList<>();
    }

    public void addItem(OrderItem orderItem){
        items.add(orderItem);
    }

    public void removeItem(OrderItem orderItem){
        items.remove(orderItem);
    }

    public Iterator<OrderItem> iterator(){
        return items.iterator();
    }

    public OrderItem getItem(Product product){

        for (OrderItem itm : items) {
            if (itm.getProduct().equals(product)) {
                return itm;
            }
        }
        return null;
    }

    public int getNumberOfItems(){
        int numero = 0;

        for(int i = 0;i < items.size();i++){
            numero += 1;
        }
        return numero;
    }

    public double getTotalCost(){
        double costoTotal = 0;

        for (Object o : items) {
            OrderItem ot = (OrderItem) o;
            costoTotal += ot.getValue();
        }
        return costoTotal;
    }

      /*@Override
    public Iterator<OrderItems> iterator() {
        return items.iterator();
    }*/

}
