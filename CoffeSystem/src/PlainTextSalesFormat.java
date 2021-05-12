/**
 * clase que implementa la interfaz SalesFormat
 * para generar el formato PlainText de una Venta
 *
 * @author Shiftybody
 * @version 0.0.2
 */
public class PlainTextSalesFormat implements SalesFormat {

    private static PlainTextSalesFormat singletonInstance;

    /**
     * Método para obtener una instancia unica de PlainTextSaleFormat
     *
     * @return singletonInstance
     */
    public static PlainTextSalesFormat getSingletonInstance() {

        if (PlainTextSalesFormat.singletonInstance == null) {
            PlainTextSalesFormat.singletonInstance = new PlainTextSalesFormat();
        }
        return PlainTextSalesFormat.singletonInstance;
    }


    /**
     * Constructor privado de esta clase
     */
    private PlainTextSalesFormat() {
    }

    /**
     * Método que produce un String con el formato PlainText establecido en este ejercicio
     *
     * @param sales un objeto de la clase Sales
     * @return Representación de las ventas con formato PlainText
     */
    public String formatSales(Sales sales) {
        String plainText = "";
        int nOrder = 0;

        for (Order order : sales) {
            String line = plainText + "------------------------\n" +
                    "Order " + ++nOrder + "\n\n";

            for (OrderItem orderItem : order) {

                line += orderItem.getQuantity() + " " +
                        orderItem.getProduct().getCode() + " " +
                        orderItem.getProduct().getPrice() + "\n";
            }
            plainText = line + "\nTotal = " + order.getTotalCost() + "\n";
        }
        return plainText;
    }
}
