/**
 * Clase CoffeeBrewer que hereda de la clase producto
 * modela una máquina de preparación de café
 *
 * @author Shiftybody
 * @version 0.0.2
 */

public class CoffeeBrewer extends Product {

    private final String model;
    private final String waterSupply;
    private final int numberOfCups;

    /**
     * Constructor que inicializa las variables de instancia
     *
     * @param newCode      valor con el que se inicializa el atributo code
     * @param description  valor con el que se inicializa el atributo description
     * @param price        valor con el que se inicializa el atributo price
     * @param model        valor con el que se inicializa el atributo model
     * @param waterSupply  valor con el que se inicializa el atributo waterSupply
     * @param numberOfCups valor con el que se inicializa el atributo numberOfCups
     */
    public CoffeeBrewer(String newCode, String description, double price, String model, String waterSupply, int numberOfCups) {
        super(newCode, description, price);

        this.model = model;
        this.waterSupply = waterSupply;
        this.numberOfCups = numberOfCups;

    }

    /**
     * Regresa el valor de la variable de instancia model.
     *
     * @return modelo de la maquina de cafe
     */
    public String getModel() {
        return model;
    }

    /**
     * Regresa el valor de la variable de instancia waterSupply.
     *
     * @return el suministro de agua manual o automatica
     */
    public String getWaterSupply() {
        return waterSupply;
    }

    /**
     * Regresa el valor de la variable de instancia numberOfCups.
     *
     * @return la capacidad de la maquina
     */
    public int getNumberOfCups() {
        return numberOfCups;
    }

    /**
     * Sobrescribe el metodo toString
     * Regresa la representación en forma de cadena de caracteres de un objeto CoffeeBrewer.
     *
     * @return code_description_price_model_waterSupply_numberOfCups
     */
    @Override
    public String toString() {
        return super.toString() + "_" + this.model + "_" + this.waterSupply + "_" + this.numberOfCups;
    }

}
