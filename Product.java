/**
 * Шаг 1 (п.1) Написать классы
 * - товар (название, цена);
 */

public class Product {
    private String productName;
    private long price;

    public Product(String productName, long price) {
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name: " + productName +
                ", price: " + price + " rub";
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
