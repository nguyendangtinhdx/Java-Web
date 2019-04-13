package bean;

public class Product {
    private long productID;
    private Category category;
    private String productName;
    private String productImage;
    private double productPrice;
    private String productDescription;
 
    public Product() {
    }
 
    public Product(long productID, Category category, String productName,
            String productImage, double productPrice, String productDescription) {
        this.productID = productID;
        this.category = category;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }
 
    public long getProductID() {
        return productID;
    }
 
    public void setProductID(long productID) {
        this.productID = productID;
    }
 
    public Category getCategory() {
        return category;
    }
 
    public void setCategory(Category category) {
        this.category = category;
    }
 
    public String getProductName() {
        return productName;
    }
 
    public void setProductName(String productName) {
        this.productName = productName;
    }
 
    public String getProductImage() {
        return productImage;
    }
 
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
 
    public double getProductPrice() {
        return productPrice;
    }
 
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
 
    public String getProductDescription() {
        return productDescription;
    }
 
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
 
}