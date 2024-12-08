public class AmountException extends RuntimeException{
    private int amount;

    public AmountException(int amount) {
        this.amount = amount;
    }

    @Override
    public String getMessage() {
        return String.format("This amount %d is incorrect", amount);
    }
}
