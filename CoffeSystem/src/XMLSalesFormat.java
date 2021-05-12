
public class XMLSalesFormat implements SalesFormat
{
    private static final String NEW_LINE;
    private static XMLSalesFormat singletonInstance;

    public static XMLSalesFormat getSingletonInstance() {

        if (XMLSalesFormat.singletonInstance == null) {
            XMLSalesFormat.singletonInstance = new XMLSalesFormat();
        }
        return XMLSalesFormat.singletonInstance;
    }

    private XMLSalesFormat() {
    }

    public String formatSales(final Sales sales) {

        String s = "<Sales>" + XMLSalesFormat.NEW_LINE;

        for (Order order : sales) {
            String s2 = s + "  <Order total=\"" + order.getTotalCost() + "\">" + XMLSalesFormat.NEW_LINE;
            for (OrderItem orderItem : order) {
                s2 = s2 + "    <OrderItem quantity=\"" + orderItem.getQuantity() + "\" price=\"" + orderItem.getProduct().getPrice() + "\">" + orderItem.getProduct().getCode() + "</OrderItem>" + XMLSalesFormat.NEW_LINE;
            }
            s = s2 + "  </Order>" + XMLSalesFormat.NEW_LINE;
        }
        return s + "</Sales>";
    }

    static {
        NEW_LINE = System.getProperty("line.separator");
        XMLSalesFormat.singletonInstance = null;
    }
}
