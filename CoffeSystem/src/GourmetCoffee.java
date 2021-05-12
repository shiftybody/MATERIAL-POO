import java.io.*;
import java.util.*;
/**
 * Clase que modela un sistema de cafe gourmet
 *
 * @author Shiftybody
 * @version 0.0.2
 */

public class GourmetCoffee {

    private static final Scanner stdIn = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private final Catalog catalog;
    private final Sales sales;

    private Order currentOrder;
    private SalesFormat salesFormat;

    /**
     * Crea un nuevo archivo con un nombre obtenido desde getFileName()
     * y guarda el contenido
     *
     * @param filename nombre del archivo que guardara la informacion de ventas
     * @param content String con el contenido enviado desde salesFormat
     * @throws IOException si ocurre algun error al generar el archivo
     */
    private void writeFile(String filename, String content)
            throws IOException {

        PrintWriter fileOut = new PrintWriter(new FileWriter(filename));
        fileOut.println(content);
        fileOut.close();

    }

    /**
     * Inicia los atributos catalog, currentOrder y sales.
     */
    public GourmetCoffee(Catalog catalog) {

        this.catalog = catalog;
        sales = new Sales();
        currentOrder = new Order();

    }

    /**
     * Despliega el catálogo.
     */
    public void displayCatalog() {

        int size = catalog.getNumberOfProducts();

        if (size == 0) {
            System.out.println("The catalog is empty");
        } else {
            for (Product product : catalog) {

                System.out.println(product.getCode() + " " +
                        product.getDescription() + " " +
                        ANSI_BLUE + "$" + product.getPrice() + ANSI_RESET);
            }
        }
    }

    /**
     * Este método le solicita al usuario un código de producto y despliega la información sobre el
     * producto especificado.
     */
    public void displayProductInfo() {

        Product product = getProductCode();

        System.out.println("  Description: " + product.getDescription());
        System.out.println("  Price: " + ANSI_BLUE + " $" + product.getPrice() + ANSI_RESET);

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
     * llama a getDisplaySaveOption y segun la respuesta del usuario
     * y el nombre de archivo genera el formato  PlainText, HTML o XML.
     *
     * @throws IOException si ocurre algun error
     */
    public void saveSales() throws IOException {

        int choice = getDisplaySaveOption();

        if (choice == 1) {
            salesFormat = PlainTextSalesFormat.getSingletonInstance();
            writeFile(getFileName(), salesFormat.formatSales(sales));
        } else if (choice == 2) {
            salesFormat = HTMLSaleFormat.getSingletonInstance();
            writeFile(getFileName(), salesFormat.formatSales(sales));
        } else if (choice == 3) {
            salesFormat = XMLSaleFormat.getSingletonInstance();
            writeFile(getFileName(), salesFormat.formatSales(sales));
        }

    }

    /**
     * Despliega el número de órdenes que contienen el producto especificado
     *
     * @param product recibe un tipo producto para enviar como parametro a getItem() de Order
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
                }
            }
            if (quantity > 0)
                System.out.println(product.getCode() + " Quantity: " + quantity);
        }
    }

    /**
     * Solicita al usuario el nombre del archivo
     * que almacenara la Venta
     *
     * @return el nombre del archivo que guardara la informacion de Venta
     */
    private String getFileName()  {
        System.out.print("FileName: ");
        return stdIn.nextLine();
    }

    /**
     * Solicita al usuario la entrada del codigo de producto
     *
     * @return el codigo de producto
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
     * @return la catidad de producto
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
     * Solicita al usuario el formato para guardar las ordenes de venta
     *
     * @return la opcion indicada por el usuario para el formato de salida
     */
    private int getDisplaySaveOption() {

        int opc;

        while (true) {
            try {
                String cadena = "\t Choice the display save style \n";
                cadena += "\n[1]: Plain Text";
                cadena += "\n[2]: HTML";
                cadena += "\n[3]: XML";
                cadena += "\n\n Choice> ";
                System.out.print(cadena);

                opc = Integer.parseInt(stdIn.nextLine());

                if (0 < opc && 3 >= opc)  {
                    break;
                } else {
                    System.out.print("Invalid choice:  " + opc);
                }

            } catch (NumberFormatException nfe) {
                System.out.println("Error > " + nfe.getMessage());
            }
        }
        return opc;
    }

    /**
     * Menú con las opciones que modelan el sistema de cafe gourmet
     *
     * @return un entero que representa la accion a realizar dentro del sistema
     */
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
                                "[8] Save sales\n" +
                                "[9] Display number of orders with a specific product\n" +
                                "[10] Display the total quantity sold for each product\n" +
                                "\n" +
                                "Choice> " + ANSI_RESET);

                return Integer.parseInt(stdIn.nextLine());

            } catch (NumberFormatException nfe) {
                System.out.println("Error: Incorrect number format. " + nfe.getMessage());
            }
        } while (true);
    }

    /**
     *
     * llama al método de la clase GourmetCoffee
     * según la opción del menú indicada por el usuario
     *
     * @throws IOException en caso de que ocurra algun error
     */
    private void principal() throws IOException {
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
                case 8 -> saveSales();
                case 9 -> displayNumberOfOrders(getProductCode());
                case 10 -> displayTotalQuantityOfProducts();
                case 0 -> {
                    System.out.println(" Proceso finalizado ");
                    return;
                }
                default -> System.out.println("    Invalid option:  " + option);
            }
        }
    }

    /**
     *
     * Comienza la aplicación verificando si existe el archivo catalog.dat
     * y no existen errores en el formato de los datos dentro del archivo.
     *
     * @param args argumentos String[]
     */
    public static void main(String[] args) throws IOException {

        Catalog catalog = null;

        try {
            catalog = (new FileCatalogLoader()).loadCatalog("catalog.dat");

        } catch (FileNotFoundException fnfe) {
            System.out.println("The file doesn´t exist");
            //terminamos la MVJ
            System.exit(1);

        } catch (DataFormatException dfe) {
            System.out.println("The file contains badly formulated data in line: "
                    + dfe.getMessage());
            System.exit(1);
        }

        // si no se termina la MVJ continuamos a despelgar el menú de la aplicacion.
        GourmetCoffee application = new GourmetCoffee(catalog);
        application.principal();
    }
}

