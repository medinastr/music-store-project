package musicstore.bluevelvetmusicstore;

public class Main {
    public static void main(String[] args) {

        CreateProduct product = new CreateProduct("Guitar", "You can play many musical types",
                "Instrument", "Strinberg", 1199.90, 1000.00);

        System.out.println(product.productDetails());
    }
}