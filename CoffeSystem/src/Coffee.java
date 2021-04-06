/**
 * Clase Cofee que hereda de la clase producto
 * @author Shiftybody
 * @version 0.1
 */

public class Coffee extends Product {

    private String origin;
    private String roast;
    private String flavor;
    private String aroma;
    private String acidity;
    private String body;

    /**
     *Inicializa  a las variables de la clase Coffee
     * @param newCode valor inicial de code
     * @param description valor inicial de description
     * @param price valor inicial de price
     * @param origin valor inicial de origin
     * @param roast valor inicial de roast
     * @param flavor valor inicial de flavor
     * @param aroma valor inicial de aroma
     * @param acidity valor inicial de acidity
     * @param body valor inicial de body
     */

    public Coffee(String newCode, String description, double price, String origin, String roast, String flavor, String aroma,
                  String acidity, String body) {

        super(newCode, description, price);

        this.origin = origin;
        this.roast = roast;
        this.flavor = flavor;
        this.aroma = aroma;
        this.acidity = acidity;
        this.body = body;

    }

    /**
     *Regresa el valor de la variable de instancia origin.
     * @return origen del producto
     */
    public String getOrigin(){
        return this.origin;
    }

    /**
     *Regresa el valor de la variable de instancia roast.
     * @return origen del cafe
     */
    public String getRoast(){
        return this.roast;
    }
    /**
     * Regresa el valor de la variable de instancia flavor.
     * @return el tostado del cafe
     */
    public String getFlavor(){
        return this.flavor;
    }
    /**
     *Regresa el valor de la variable de instancia aroma.
     * @return el aroma del cafe
     */
    public String getAroma(){
        return this.aroma;
    }
    /**
     *Regresa el valor de la variable de instancia acidity.
     * @return la acidez del cafe
     */
    public String getAcidity(){
        return this.acidity;
    }
    /**
     *Regresa el valor de la variable de instancia body.
     * @return el cuerpo del caf[e
     */
    public String getBody(){
        return this.body;
    }

    /**
     *Sobrescribe el metodo toString
     * regresa la representacion string de un objeto coffee
     * @return   code_description_price_origin_roast_flavor_aroma_acidity_body
     */

    @Override
    public String toString(){
        return super.toString() + "_" + this.origin + "_" + this.roast + "_" + this.flavor +  "_"
                + this.aroma +  "_"  + this.acidity +  "_" + this.body;

    }








}
