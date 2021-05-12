
/**
 * Clase que contiene la informacion de un producto
 * de la tienda de Cafe Gourmet.
 *
 * @author Shiftybody
 * @version 0.0.2
 */

public class Product {

    private final String code;
    private final String description;
    private final double price;

    /**
     * Inicializa el código y la descripción de un producto
     *
     * @param newCode     Valor al cual es iniciaalizado el atributo code
     * @param description Valor al cual es inizalizado el atributo description
     * @param price       Valor para inicializar el pecio del producto
     */

    public Product(String newCode, String description, double price) {
        this.code = newCode;
        this.description = description;
        this.price = price;
    }

    /**
     * Devuelve el codigo del producto
     *
     * @return codigo del producto
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Devuelve la descripcion del producto
     *
     * @return descripcion del producto
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Devuelve el precio del producto
     *
     * @return precio del producto
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Sobrescribe el metodo toString  de la clase Object.
     * Devuelve una cadena de un objeto product.
     *
     * @return code_description_price
     */

    @Override
    public String toString() {
        return this.code + "_" + this.description + "_" + this.price;
    }

    /**
     * Sobrescribe el metodo equals de la clase Object
     * Devuelve verdadero si dos codigos son iguales y falso si no
     *
     * @return bool
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            Product prodTemp = (Product) obj;
            return this.code.equals(prodTemp.getCode());
        }
        return false;
    }


}
