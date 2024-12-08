import java.util.List;

/**
 * Шаг 1 (п.1) Написать классы
 * - заказ (объект покупатель, объект товар, количество).
 */

public class Order {
    private Customer customer;
    private Product productName;
    private int amount;

    public Order(Customer customer, Product productName, int amount) {
        this.customer = customer;
        this.productName = productName;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order: " + '\n' +
                customer + '\n' +
                productName + '\n' +
                "amount: " + amount;
    }

    public static boolean checkOrder(Order order, List<Customer> customers,
                                  List<Product> products){

        if(!checkArray(order.productName, products)){
            throw new ProductException(order.productName);
        }
        if(!checkArray(order.customer, customers)){
            throw new CustomerException(order.customer);
        }
        if(order.amount < 0 || order.amount > 100){
            throw new AmountException(order.amount);
        }
        return true;
    }



    private static boolean checkArray(Object object, List list){

        for(Object element : list){
            if(object == element){
                return true;
            }
        }
        return false;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProductName() {
        return productName;
    }

    public void setProductName(Product productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
