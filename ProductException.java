public class ProductException extends RuntimeException{

    private Product product;

    public ProductException(Product product) {
        this.product = product;
    }

    @Override
    public String getMessage() {
        return String.format("This product doesn't exists in the list - %s ", product.getProductName());
    }
}
