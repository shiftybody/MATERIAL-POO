/**
 * clase que implementa la interfaz SalesFormat
 * para generar el formato XML de una Venta
 *
 * @author Shiftybody
 * @version 0.0.2
 */
public class XMLSaleFormat implements SalesFormat {
    private static XMLSaleFormat singletonInstance;

    /**
     *  Método para obtener una inStancia unica de XMLSaleFormat
     *
     * @return singletonInstance
     */
    public static XMLSaleFormat getSingletonInstance() {

        if (XMLSaleFormat.singletonInstance == null) {
            XMLSaleFormat.singletonInstance = new XMLSaleFormat();
        }
        return XMLSaleFormat.singletonInstance;
    }

    /**
     * Constructor privado de esta clase
     */
    private XMLSaleFormat() {
    }

    /**
     * Método que produce un String con el formato XML
     *
     * @param sales  un objeto de la clase Sales
     * @return Representación de las ventas con formato XML
     */
    public String formatSales(Sales sales) {

        String xml = "<Sales>\n";

        for (Order order : sales) {
            String line = xml + "  <Order total=\"" + order.getTotalCost() + "\">\n";
            for (OrderItem orderItem : order) {
                line += "    <OrderItem quantity=\"" + orderItem.getQuantity() + "\" price=\""
                        + orderItem.getProduct().getPrice() + "\">" + orderItem.getProduct().getCode() + "</OrderItem>\n";
            }
            xml = line + "  </Order>\n";
        }
        return xml + "</Sales>";
    }
}
