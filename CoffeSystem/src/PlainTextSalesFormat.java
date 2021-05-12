
public class PlainTextSalesFormat implements SalesFormat
{
    private static final String NEW_LINE;
    private static PlainTextSalesFormat singletonInstance;

    public static PlainTextSalesFormat getSingletonInstance() {

        if (PlainTextSalesFormat.singletonInstance == null) {
            PlainTextSalesFormat.singletonInstance = new PlainTextSalesFormat();
        }
        return PlainTextSalesFormat.singletonInstance;
    }

    private PlainTextSalesFormat() {

    }

    public String formatSales(final Sales sales) {
        String string = "";
        int n = 0;
        for (Order order : sales) {
            String s = string + "------------------------" +
                    PlainTextSalesFormat.NEW_LINE + "Order " + ++n
                    + PlainTextSalesFormat.NEW_LINE +
                    PlainTextSalesFormat.NEW_LINE;

            for (OrderItem orderItem : order) {
                s = s + orderItem.getQuantity() + " " +
                        orderItem.getProduct().getCode() + " "
                        + orderItem.getProduct().getPrice() +
                        PlainTextSalesFormat.NEW_LINE;
            }
            string = s + PlainTextSalesFormat.NEW_LINE + "Total = " + order.getTotalCost() + PlainTextSalesFormat.NEW_LINE;
        }
        return string;
    }

    static {
        NEW_LINE = System.getProperty("line.separator");
        PlainTextSalesFormat.singletonInstance = null;
    }
}
