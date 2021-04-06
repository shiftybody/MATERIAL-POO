import java.util.ArrayList;
import java.util.Iterator;

public class Catalog  /*implements Iterable<Product> */ {

    private ArrayList<Product> products = null;

    // private ArrayList<Product> products = new ArrayList<Product>();

    public Catalog(){
        products = new ArrayList<Product>();
    }

    public void addProduct (Product product){
        products.add(product);
    }

    public Iterator<Product> iterator() {
        return products.iterator();
    }

    public Product getProduct(String code){

        for (Product prod : products) {
            if (prod.getCode().equals(code)) {
                return prod;
            }
        }
        return null;
    }

    public int getNumberOfProducts(){
        int numero = 0;

        for(int i = 0;i < products.size();i++){
            numero += 1;
        }

        return numero;
    }

    /*@Override
    public Iterator<Product> iterator() {
        return products.iterator();

    }*/
}
