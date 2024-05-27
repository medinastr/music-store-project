package musicstore.bluevelvetmusicstore;

public class CreateProduct {
    private String productName;
    private String description;
    private String brand;
    private String category;
    private double listPrice;
    private double cost;

    public CreateProduct(String productName, String description, String brand, String category, double listPrice, double cost) {
        setProductName(productName);
        setDescription(description);
        setBrand(brand);
        setCategory(category);
        setListPrice(listPrice);
        setCost(cost);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String productDetails() {
        String aux = "Product: " + productName +
                "\nDescription: " + description +
                "\nBrand: " + brand +
                "\nCategory: " + category +
                "\nList price: " + listPrice +
                "\nCost: " + cost;
        return aux;
    }
}
