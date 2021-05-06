public class Text implements IFormato {

    @Override
    public String creaFormato(Catalog catalog) {
        String cadena = "";
        for (Product product : catalog) {

            System.out.println("  Description: " + product.getDescription());
            System.out.println("  Price: " + " $" + product.getPrice());

            displayProduct(product);
            System.out.println("");
        }
        return cadena;
    }

    static void displayProduct(Product product) {
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

}
