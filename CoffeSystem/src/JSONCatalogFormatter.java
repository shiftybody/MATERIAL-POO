public class JSONCatalogFormatter implements CatalogFormatter {

    @Override
    public String formatCatalog(Catalog catalog) {
        String cadena = "{";
        System.out.println("\"Catalogo:\" {");

        for (Product product : catalog) {

            if (product instanceof Coffee) {

                Coffee coffee = (Coffee) product;

                System.out.println("\t\"Coffee\" : {");
                System.out.println("\t\tDescription: " + product.getDescription() + ",");
                System.out.println("\t\tPrice: " + product.getPrice() + ",");
                System.out.println("\t\tOrigin: " + coffee.getOrigin() + ",");
                System.out.println("\t\tRoast: " + coffee.getRoast() + ",");
                System.out.println("\t\tFlavor: " + coffee.getFlavor() + ",");
                System.out.println("\t\tAroma: " + coffee.getAroma() + ",");
                System.out.println("\t\tAcidity: " + coffee.getAcidity() + ",");
                System.out.println("\t\tBody: " + coffee.getBody() + ",");
                System.out.println("\t }");

            } else if (product instanceof CoffeeBrewer) {

                CoffeeBrewer brewer = (CoffeeBrewer) product;

                System.out.println("\t\"CoffeeBrewer\" : {");
                System.out.println("\t\tDescription: " + product.getDescription() +",");
                System.out.println("\t\tPrice: " + product.getPrice() + ",");
                System.out.println("\t\tModel: " + brewer.getModel()+ ",");
                System.out.println("\t\tWater Supply: " + brewer.getWaterSupply()+ ",");
                System.out.println("\t\tNumber of Cups: " + brewer.getNumberOfCups());
                System.out.println("\t< }");

            } else{
                System.out.println("\t\"Product\" : {");
                System.out.println("\t\tDescription: " + product.getDescription() + ",");
                System.out.println("\t\tPrice: " + product.getPrice() + ",");
                System.out.println("\t }");
            }
        }

        System.out.println("}");
        return cadena;
    }

}
