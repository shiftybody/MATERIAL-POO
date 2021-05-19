/**
 * clase que implementa la interfaz SalesFormat
 * para generar el formato HTML de una Venta
 *
 * @author Shiftybody
 * @version 0.0.2
 */
public class HTMLSalesFormatter implements SalesFormatter {

    private static HTMLSalesFormatter singletonInstance;

    /**
     * Método para obtener una instancia unica de HTMLSaleFormat
     *
     * @return singletonInstance
     */
    public static HTMLSalesFormatter getSingletonInstance() {

        if (singletonInstance == null) {
            singletonInstance = new HTMLSalesFormatter();
        }
        return singletonInstance;
    }

    /**
     * Constructor privado de esta clase
     */
    private HTMLSalesFormatter() {

    }

    /**
     * Método que produce un String con el formato HTML
     *
     * @param sales un objeto de la clase Sales
     * @return Representación de las ventas con formato HTML
     */
    public String formatSales(Sales sales) {
        String html =
                "<html>\n" +
                        "  <body>\n" +
                        "    <center><h2>Orders</h2></center>\n";

        for (Order order : sales) {
            html += "    <hr>\n" + "    <h4>Total = " + order.getTotalCost() + "</h4>\n";

            for (OrderItem orderItem : order) {
                html += "      <p>\n" +
                        "        <b>code:</b> " + orderItem.getProduct().getCode() + "<br>\n" +
                        "        <b>quantity:</b> " + orderItem.getQuantity() + "<br>\n" +
                        "        <b>price:</b> " + orderItem.getProduct().getPrice() + "\n" +
                        "      </p>\n";
            }
        }
        return html +
                "  </body>\n" +
                "</html>";
    }
}
