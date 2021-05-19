public class XMLCatalogFormatter implements CatalogFormatter {

    @Override
    public String formatCatalog(Catalog catalog) {
        String cadena = "";
        System.out.println("<Catalog>");

        for (Product product : catalog) {

            if (product instanceof Coffee) {

                Coffee coffee = (Coffee) product;

                System.out.println("\t<Coffee>");
                System.out.println("\t\t<Description:>" + product.getDescription() + "</Description>");
                System.out.println("\t\t<Price>" + product.getPrice() + "</Price>");
                System.out.println("\t\t<Origin> " + coffee.getOrigin() + " </Origin> ");
                System.out.println("\t\t<Roast> " + coffee.getRoast() + "</Roast>");
                System.out.println("\t\t<Flavor> " + coffee.getFlavor() + "</Flavor>");
                System.out.println("\t\t<Aroma> " + coffee.getAroma() + "</Aroma>");
                System.out.println("\t\t<Acidity> " + coffee.getAcidity() + "</Acidity>");
                System.out.println("\t\t<Body> " + coffee.getBody() + "</Body>");
                System.out.println("\t</Coffee>");

            } else if (product instanceof CoffeeBrewer) {

                CoffeeBrewer brewer = (CoffeeBrewer) product;

                System.out.println("\t<CoffeeBrewer>");
                System.out.println("\t\t<Description:>" + product.getDescription() + "</Description>");
                System.out.println("\t\t<Price>" + product.getPrice() + "</Price>");
                System.out.println("\t\t<Model> " + brewer.getModel()+ "</Model>");
                System.out.println("\t\t<Water Supply> " + brewer.getWaterSupply()+ "</WaterSupply>");
                System.out.println("\t\t<Number of Cups> " + brewer.getNumberOfCups()+ "</Number of Cups>");
                System.out.println("\t</CoffeeBrewer>");

            } else{
                System.out.println("\t<Product>");
                System.out.println("\t\t<Description:>" + product.getDescription() + "</Description>");
                System.out.println("\t\t<Price>" + product.getPrice() + "</Price>");
                System.out.println("\t</Product>");
            }
        }

        System.out.println("</Catalog>\n");
        return cadena;
    }

}
