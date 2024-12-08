public class CustomerException extends RuntimeException{

    private Customer customer;

    public CustomerException(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String getMessage() {
        return String.format("This customer doesn't exists in the list - %s %s ", customer.getSurname(), customer.getName());
    }
}
