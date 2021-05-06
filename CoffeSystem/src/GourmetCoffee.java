import java.util.Scanner;

/**
 * Clase que crea una interfaz de consola para procesar órdenes de la tienda.
 *
 * @author Shiftybody
 * @version 0.3
 */

public class GourmetCoffee {

    private static final Scanner stdIn = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private final Catalog catalog;
    private Order currentOrder;
    private final Sales sales;

    private IFormato formato;

    /**
     * Inicia los atributos catalog, currentOrder y sales.
     */
    public GourmetCoffee() {

        catalog = addCatalog();
        sales = new Sales();
        currentOrder = new Order();
    }

    /**
     * Despliega el catálogo.
     */
    public void displayCatalog() {

        this.setStrategy();
        System.out.println(formato.creaFormato(catalog));

    }

    /**
     * Este método le solicita al usuario un código de producto y despliega la información sobre el producto especificado.
     */
    public void displayProductInfo() {

        Product product = getProductCode();

        System.out.println("  Description: " + product.getDescription());
        System.out.println("  Price: " + ANSI_BLUE + " $" + product.getPrice() + ANSI_RESET);

        Text.displayProduct(product);
    }

    /**
     * Despliega los productos incluidos en la orden actual.
     */
    public void displayOrder() {


        if (currentOrder.getNumberOfItems() == 0) {
            System.out.println("Empty current order ");
        } else {
            for (OrderItem orderItem : currentOrder) {
                System.out.println(orderItem.toString());
            }
            System.out.println("Total:" + ANSI_BLUE + " $" +
                    currentOrder.getTotalCost() + ANSI_RESET);
        }
    }

    /**
     * Este método le solicita al usuario el código de un producto y la cantidad. Si el producto
     * especificado no es parte de la orden actual, entonces es el producto y la cantidad es añadido
     * a la orden; de otra manera, la cantidad de producto es actualizada.
     */
    public void addModifyProduct() {

        Product product = getProductCode();
        int quantity = getQuantity();

        OrderItem orderItem = currentOrder.getItem(product);

        if (orderItem == null) {
            currentOrder.addItem(new OrderItem(product, quantity));

            System.out.println("Product " + product.getCode()
                    + " added");
        } else {
            orderItem.setQuantity(getQuantity());
            System.out.println("The quantity of the product " +
                    product.getCode() + " has been modified");
        }
    }

    /**
     * Este método le solicita al usuario el código de un producto y elimina el
     * producto especificado de la orden actual
     */
    public void removeProduct() {

        Product product = getProductCode();
        OrderItem orderItem = currentOrder.getItem(product);

        if (orderItem != null) {
            currentOrder.removeItem(orderItem);
            System.out.println("The product " + product.getCode()
                    + " has been removed from the current order");
        } else {
            System.out.println("There are no products in the current order with that code");
        }
    }

    /**
     * Registra la venta de la orden actual.
     */
    public void saleOrder() {

        if (currentOrder.getNumberOfItems() > 0) {
            sales.addOrder(currentOrder);
            currentOrder = new Order();
            System.out.println("The sale of the order has been registered");
        } else {
            System.out.println("The current order is empty");
        }
    }

    /**
     * Despliega las órdenes que han sido vendidas.
     */
    public void displayOrdersSold() {


        if (sales.getNumberOfOrders() != 0) {
            int orderNumber = 1;
            for (Order order : sales) {

                System.out.println();
                System.out.println("      Order " + orderNumber++);

                for (OrderItem orderItem : order) {
                    System.out.println("   " + orderItem.toString());
                }
                System.out.println("   Total:" + ANSI_BLUE + " $" +
                        order.getTotalCost() + ANSI_RESET);
            }
        } else {
            System.out.println("There are no sales");
        }
    }

    /**
     * Despliega el número de órdenes que contienen el producto especificado
     *
     * @param product
     */
    public void displayNumberOfOrders(Product product) {

        int numOrd = 0;

        for (Order order : sales) {

            OrderItem item = order.getItem(product);

            if (item != null) {
                numOrd += 1;
            }
        }

        System.out.println("The product " + product.getCode() + " found in: " + numOrd + " order/s");

    }

    /**
     * Despliega la cantidad total que ha sido vendida de cada uno de los productos en el catálogo
     */

    public void displayTotalQuantityOfProducts() {
        for (Product product : catalog) {
            int quantity = 0;
            for (Order orden : sales) {
                OrderItem item = orden.getItem(product);
                if (item != null) {
                    quantity += item.getQuantity();
                    ;
                }
            }
            if (quantity > 0)
                System.out.println(product.getCode() + " Quantity: " + quantity);
        }
    }

    /**
     * Crea un catálogo vacío y luego le agrega productos.
     *
     * @return catalogo
     */
    private Catalog addCatalog() {

        Catalog catalog = Catalog.getSingletonInstance();

        catalog.addProduct(new Coffee(
                "C001", "Colombia, Whole, 1 lb", 17.99,
                "Colombia", "Medium", "Rich and Hearty", "Rich", "Medium", "Full"));
        catalog.addProduct(new Coffee(
                "C002", "Colombia, Ground, 1 lb", 18.75,
                "Colombia", "Medium", "Rich and Hearty", "Rich", "Medium", "Full"));
        catalog.addProduct(new Coffee(
                "C003", "Italian Roasts, Whole, 1 lb", 16.80,
                "Latin American Blend", "Italian Roast", "Dark and heavy",
                "Intense", "Low", "Medium"));
        catalog.addProduct(new Coffee(
                "C004", "Italian Roasts, Ground, 1 lb", 17.55,
                "Latin American Blend", "Italian Roast", "Dark and heavy",
                "Intense", "Low", "Medium"));
        catalog.addProduct(new Coffee(
                "C005", "French Roasts, Whole, 1 lb", 16.80,
                "Latin American Blend", "French Roast", "Bittersweet, full intense",
                "Intense, full", "None", "Medium"));
        catalog.addProduct(new Coffee(
                "C006", "French Roast, Ground, 1 lb", 17.55,
                "Latin American Blend", "French Roast", "Bittersweet, full intense",
                "Intense, full", "None", "Medium"));
        catalog.addProduct(new Coffee(
                "C007", "Guatemala, Whole, 1 lb", 17.99,
                "Guatemala", "Medium", "Rich and complex",
                "Spicy", "Medium to high", "Medium to high"));
        catalog.addProduct(new Coffee(
                "C008", "Guatemala, Ground, 1 lb", 18.75,
                "Guatemala", "Medium", "Rich and complex",
                "Spicy", "Medium to high", "Medium to full"));
        catalog.addProduct(new Coffee(
                "C009", "Sumatra, Whole, 1 lb", 19.99,
                "Sumatra", "Medium", "Vibrant and powdery",
                "Like dark chocolate", "Gentle", "Rich and full"));
        catalog.addProduct(new Coffee(
                "C010", "Sumatra, Ground, 1 lb", 20.50,
                "Sumatra", "Medium", "Vibrant and powdery",
                "Like dark chocolate", "Gentle", "_Rich and full"));
        catalog.addProduct(new Coffee(
                "C011", "Decaf Blend, Whole, 1 lb", 16.80,
                "Latin American Blend", "Dark roast", "Full, roasted flavor",
                "Hearty", "Bold and rich", "Full"));
        catalog.addProduct(new Coffee(
                "C012", "French Roast, Ground, 1 lb", 17.55,
                "Latin American Blend", "Dark roast", "Full, roasted flavo",
                "Hearty", "Bold and rich", "Full"));

        catalog.addProduct(new CoffeeBrewer(
                "B001", "Home Coffee Brewer", 150.00,
                "Brewer 100", "Pourover", 6));
        catalog.addProduct(new CoffeeBrewer(
                "B002", "Coffee Brewer, 2 Warmers", 200.00,
                "Brewer 200", "Pourover", 12));
        catalog.addProduct(new CoffeeBrewer(
                "B003", "Coffee Brewer, 3 Warmers", 280.00,
                "Brewer 210", "Pourover", 12));
        catalog.addProduct(new CoffeeBrewer(
                "B004", "Commercial Coffee, 20 Cups", 380.00,
                "Quick Coffee 100", "Automatic", 20));
        catalog.addProduct(new CoffeeBrewer(
                "B005", "Commercial Coffee, 40 Cups", 480.00,
                "Quick Coffee 200", "Automatic", 40));

        catalog.addProduct(
                new Product("A001", "Almond Flavored Syrup", 9.00));
        catalog.addProduct(
                new Product("A002", "Irish Creme Flavored Syrup", 9.00));
        catalog.addProduct(
                new Product("A003", "Mint Flavored syrup", 9.00));
        catalog.addProduct(
                new Product("A004", "Caramel Flavored Syrup", 9.00));
        catalog.addProduct(
                new Product("A005", "Gourmet Coffee Cookies", 12.00));
        catalog.addProduct(
                new Product("A006", "Gourmet Coffee Travel Thermo", 18.00));
        catalog.addProduct(
                new Product("A007", "Gourmet Coffee Ceramic Mug", 8.00));
        catalog.addProduct(
                new Product("A008", "Gourmet Coffee 12 Cup Filters", 15.00));
        catalog.addProduct(
                new Product("A009", "Gourmet Coffee 36 Cup Filters", 45.00));

        return catalog;
    }

    /**
     * Solicita al usuario la entrada del codigo de producto
     *
     * @return
     */
    private Product getProductCode() {

        do {
            System.out.println();
            System.out.print("  Product code> ");

            Product product = catalog.getProduct(stdIn.nextLine());

            if (product != null) {
                return product;
            } else {
                System.out.println("Product not found. Wrong product code");
            }
        } while (true);
    }

    /**
     * Solicita al usuario la cantidad de producto
     *
     * @return
     */
    private int getQuantity() {

        int quantity;

        do {
            try {

                System.out.print("  Quantity> ");
                quantity = Integer.parseInt(stdIn.nextLine());
                if (quantity > 0) {

                    return quantity;

                } else {
                    System.out.println(
                            "Invalid input. A positive number was expected ");
                }

            } catch (NumberFormatException nfe) {
                System.out.println("Error: Incorrect number format. " + nfe.getMessage());
            }
        } while (true);
    }

    /**
     * Presenta al usuario una terminal con las opcones de la aplicacion
     */

    private int getDisplayOption() {
        while (true) {
            try {
                String cadena = "\t Choose the display style ";
                cadena += "\n[1]: JSON";
                cadena += "\n[2]: Texto";
                cadena += "\n[3]: XML";
                cadena += "\n\n Choose> ";
                System.out.print(cadena);

                int opc = Integer.parseInt(stdIn.nextLine());
                if (opc >= 0 && opc <= 9) {
                    return opc;
                }

            } catch (Exception ioe) {
                ioe.printStackTrace();
            }
        }
    }

    private void setStrategy() {
        int opcion = getDisplayOption();
        switch (opcion) {

            case 1:
                formato = new JSON();
                break;
            case 2:
                formato = new Text();
                break;
            case 3:
                formato = new XML();
                break;
        }
    }

    private int getOption() {
        do {
            try {
                System.out.println();
                System.out.print(
                        ANSI_RED +
                                "[0] Quit\n" +
                                "[1] Display catalog\n" +
                                "[2] Display product\n" +
                                "[3] Display current order\n" +
                                "[4] Add|modify product to|in current order\n" +
                                "[5] Remove product from current order\n" +
                                "[6] Register sale of current order\n" +
                                "[7] Display sales\n" +
                                "[8] Display number of orders with a specific product\n" +
                                "[9] Display the total quantity sold for each product\n" +
                                "\n" +
                                "Choose> " + ANSI_RESET);

                return Integer.parseInt(stdIn.nextLine());

            } catch (NumberFormatException nfe) {
                System.out.println("Error: Incorrect number format. " + nfe.getMessage());
            }
        } while (true);
    }

    private void principal() {
        while (true) {
            int option = getOption();
            switch (option) {
                case 1 -> displayCatalog();
                case 2 -> displayProductInfo();
                case 3 -> displayOrder();
                case 4 -> addModifyProduct();
                case 5 -> removeProduct();
                case 6 -> saleOrder();
                case 7 -> displayOrdersSold();
                case 8 -> displayNumberOfOrders(getProductCode());
                case 9 -> displayTotalQuantityOfProducts();
                case 0 -> {
                    System.out.println(" Proceso finalizado ");
                    return;
                }
                default -> System.out.println("    Invalid option:  " + option);
            }
        }
    }

    /**
     * Inicia la aplicación
     *
     * @param args
     */

    public static void main(String[] args) {

        GourmetCoffee application = new GourmetCoffee();
        application.principal();

    }
}
