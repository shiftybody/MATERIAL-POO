
public class HTMLSaleFormat implements SalesFormat {


    private static final String NEW_LINE;
    private static HTMLSaleFormat singletonInstance;


    public static HTMLSaleFormat getSingletonInstance() {

        if (HTMLSaleFormat.singletonInstance == null) {
            HTMLSaleFormat.singletonInstance = new HTMLSaleFormat();
        }
        return HTMLSaleFormat.singletonInstance;
    }


    private HTMLSaleFormat() {

    }

    public String formatSales(final Sales sales) {
        String str =
                "<html>" + HTMLSaleFormat.NEW_LINE + "  <body>" + HTMLSaleFormat.NEW_LINE + "    <center><h2>Orders</h2></center>" + HTMLSaleFormat.NEW_LINE;
        for (Order order : sales) {
            str = str + "    <hr>" + HTMLSaleFormat.NEW_LINE + "    <h4>Total = " + order.getTotalCost() + "</h4>" + HTMLSaleFormat.NEW_LINE;
            for (OrderItem orderItem : order) {
                str = str + "      <p>" + HTMLSaleFormat.NEW_LINE + "        <b>code:</b> " + orderItem.getProduct().getCode() + "<br>" + HTMLSaleFormat.NEW_LINE + "        <b>quantity:</b> " + orderItem.getQuantity() + "<br>" + HTMLSaleFormat.NEW_LINE + "        <b>price:</b> " + orderItem.getProduct().getPrice() + HTMLSaleFormat.NEW_LINE + "      </p>" + HTMLSaleFormat.NEW_LINE;
            }
        }
        return str + "  </body>" + HTMLSaleFormat.NEW_LINE + "</html>";
    }

    static {
        NEW_LINE = System.getProperty("line.separator");
        HTMLSaleFormat.singletonInstance = null;
    }
}
