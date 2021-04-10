


import java.util.Iterator;
import java.util.Scanner;

/**
 * Clase que crea una interfaz de consola para procesar órdenes de la tienda.
 * @author Shiftybody
 * @version 0.2
 */

public class GourmetCoffee {

    private static final Scanner stdIn = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private final Catalog  catalog;
    private Order  currentOrder;
    private final Sales  sales;

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

        for (Iterator<Product> itP = catalog.iterator(); itP.hasNext(); ) {
            Product product = itP.next();
            System.out.println(product.getCode() + " " +
                               product.getDescription() + ANSI_BLUE + " $" + product.getPrice() + ANSI_RESET );
        }

    }

    /**
     *Este método le solicita al usuario un código de producto y despliega la información sobre el producto especificado.
     */
    public void displayProductInfo() {

        Product product = requestProductCode();

        System.out.println("  Description: " + product.getDescription());
        System.out.println("  Price: " + ANSI_BLUE + " $" + product.getPrice() + ANSI_RESET );

        if (product instanceof Coffee) {

            Coffee coffee = (Coffee) product;

            System.out.println("  Origin: " + coffee.getOrigin());
            System.out.println("  Roast: " + coffee.getRoast());
            System.out.println("  Flavor: " + coffee.getFlavor());
            System.out.println("  Aroma: " + coffee.getAroma());
            System.out.println("  Acidity: " + coffee.getAcidity());
            System.out.println("  Body: " + coffee.getBody());

        } else if (product instanceof CoffeeBrewer) {

            CoffeeBrewer brewer = (CoffeeBrewer) product;

            System.out.println("  Model: " + brewer.getModel());
            System.out.println("  Water Supply: " + brewer.getWaterSupply());
            System.out.println("  Number of Cups: " + brewer.getNumberOfCups());
        }
    }

    /**
     *Despliega los productos incluidos en la orden actual.
     */
    public void displayOrder() {


        if (currentOrder.getNumberOfItems() == 0) {
            System.out.println("Empty current order ");
        } else {
            for (Iterator<OrderItem> i = currentOrder.iterator(); i.hasNext();) {
                System.out.println(i.next().toString());
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

        Product product = requestProductCode();
        int quantity = requestQuantity();

        OrderItem orderItem = currentOrder.getItem(product);

        if (orderItem == null) {
            currentOrder.addItem(new OrderItem(product, quantity));

            System.out.println("Product " + product.getCode()
                    + " added");
        } else {
            orderItem.setQuantity(requestQuantity());
            System.out.println("The quantity of the product " +
                    product.getCode() + " has been modified");
        }
    }

    /**
     *Este método le solicita al usuario el código de un producto y elimina el
     * producto especificado de la orden actual
     */
    public void removeProduct() {

        Product product = requestProductCode();
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
    public void saleOrder()  {

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
            for (Iterator<Order> itS = sales.iterator(); itS.hasNext(); ) {

                Order order = itS.next();

                System.out.println();
                System.out.println("      Order " + orderNumber++);

                for (Iterator<OrderItem> itItemOrder = order.iterator(); itItemOrder.hasNext();) {
                    System.out.println("   " + itItemOrder.next().toString());
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
     * @param product
     */
    public void displayNumberOfOrders(Product product) {

        int numOrd = 0;

        for (Iterator<Order> itS = sales.iterator(); itS.hasNext();){

            Order order = itS.next();
            OrderItem item = order.getItem(product);

            if(item != null){
                numOrd+=1;
            }
        }

        System.out.println("The product "+ product.getCode() +" found in: "+ numOrd + " order/s");

    }

    /**
     * Despliega la cantidad total que ha sido vendida de cada uno de los productos en el catálogo
     */

    public void displayTotalQuantityOfProducts() {

        Product product;

        int numOrd = 0;
        System.out.println(" ");
        for(Iterator<Product> itP = catalog.iterator(); itP.hasNext();){

            product = itP.next();

            int orderNumber = 1;
            for (Iterator<Order> itS = sales.iterator(); itS.hasNext(); ) {

                Order order = itS.next();

                for (Iterator<OrderItem> itItemOrder = order.iterator(); itItemOrder.hasNext();) {
                    System.out.println("   " + itItemOrder.next().getQuantity());
                }

            }

            System.out.print(product.getCode() + " " + numOrd+"\n");

            numOrd = 0;
        }
    }

    /**
     * Crea un catálogo vacío y luego le agrega productos.
     * @return catalogo
     */
    private Catalog addCatalog() {

        Catalog catalog = new Catalog();

        catalog.addProduct(new Coffee(
                "C001", "Colombia, Whole, 1 lb", 17.99,
                "Colombia", "Medium", "Rich and Hearty", "Rich", "Medium", "Full"));
        catalog.addProduct(new Coffee(
                "C002", "Colombia, Ground, 1 lb", 18.75,
                "Colombia", "Medium", "Rich and Hearty", "Rich", "Medium","Full"));
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
                "B003","Coffee Brewer, 3 Warmers", 280.00,
                "Brewer 210","Pourover",12));
        catalog.addProduct(new CoffeeBrewer(
                "B004","Commercial Coffee, 20 Cups",380.00,
                "Quick Coffee 100", "Automatic",20));
        catalog.addProduct(new CoffeeBrewer(
                "B005","Commercial Coffee, 40 Cups", 480.00,
                "Quick Coffee 200", "Automatic", 40));

        catalog.addProduct(
                new Product("A001", "Almond Flavored Syrup", 9.00));
        catalog.addProduct(
                new Product("A002", "Irish Creme Flavored Syrup", 9.00));
        catalog.addProduct(
                new Product("A003", "Mint Flavored syrup", 9.00));
        catalog.addProduct(
                new Product("A004", "Caramel Flavored Syrup",9.00));
        catalog.addProduct(
                new Product("A005", "Gourmet Coffee Cookies",12.00));
        catalog.addProduct(
                new Product("A006","Gourmet Coffee Travel Thermo",18.00));
        catalog.addProduct(
                new Product("A007","Gourmet Coffee Ceramic Mug",8.00));
        catalog.addProduct(
                new Product("A008","Gourmet Coffee 12 Cup Filters",15.00));
        catalog.addProduct(
                new Product("A009","Gourmet Coffee 36 Cup Filters",45.00));

        return catalog;
    }

    /**
     * Solicita al usuario la entrada del codigo de producto
     * @return
     */
    private Product requestProductCode() {

        do  {
            System.out.println();
            System.out.print("  Product code> ");

            Product product = catalog.getProduct(stdIn.nextLine());

            if (product != null) {
                return product;
            } else {
                System.out.println("Product not found. Wrong product code");
            }
        }  while (true);
    }

    /**
     * Solicita al usuario la cantidad de producto
     * @return
     */
    private int requestQuantity() {

        int quantity;

        do  {
            try  {

                System.out.print("  Quantity> ");
                quantity = Integer.parseInt(stdIn.nextLine());
                if (quantity > 0) {

                    return quantity;

                } else  {
                    System.out.println(
                            "Invalid input. A positive number was expected ");
                }

            } catch (NumberFormatException  nfe)  {
                System.out.println("Error: Incorrect number format. " + nfe.getMessage());
            }
        }  while (true);
    }

    /**
     * Presenta al usuario una terminal con las opcones de la aplicacion
     */
    private void principal() {

        do  {
            try  {
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
                        "Choice> " + ANSI_RESET);


                int option = Integer.parseInt(stdIn.nextLine());

                switch (option) {
                    case 1 -> displayCatalog();
                    case 2 -> displayProductInfo();
                    case 3 -> displayOrder();
                    case 4 -> addModifyProduct();
                    case 5 -> removeProduct();
                    case 6 -> saleOrder();
                    case 7 -> displayOrdersSold();
                    case 8 -> displayNumberOfOrders(requestProductCode());
                    case 9 -> displayTotalQuantityOfProducts();
                    case 0 -> System.out.println(" ");
                    default -> System.out.println("    Invalid option:  " + option);
                }

            } catch (NumberFormatException  nfe)  {
                System.out.println("Error: Incorrect number format. " + nfe.getMessage());
            }
        }  while (true);
    }

    /**
     * Inicia la aplicación
     * @param args
     */
    public static void  main(String[]  args) {

        GourmetCoffee  application = new GourmetCoffee();
        application.principal();

    }
}
