/**
 * Clase que cmodela un elemento de una orden.
 *
 * @author Shiftybody
 * @version 0.0.2
 */

public class OrderItem {

    private final Product product;
    private int quantity;

    /**
     * Inicializa la variable de instancia product y la cantidad de un producto
     *
     * @param product  Esta variable de instancia representa la asociación de una vía entre OrderItem y Product.
     * @param quantity La cantidad del producto en la orden.
     */
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * @return el valor de la variable de instancia product
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Regresa el valor de la variable de instancia quantity.
     *
     * @return La cantidad del producto en la orden.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Establece la variable de instancia quantity con el valor del parámetro quantity.
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return la multiplicación de quantity por price.
     */
    public double getValue() {
        return this.quantity * this.product.getPrice();
    }

    /**
     * Sobrescribe el método toString de la clase Object.
     *
     * @return la representación en formato de cadena de caracteres de un objeto OrderItem.
     */
    @Override
    public String toString() {
        return this.quantity + " " + this.product.getCode() + " " + this.product.getPrice();
    }

}
