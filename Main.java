import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Задача: Эмуляция интернет-магазина
 * 1. написать классы покупатель, товар и заказ;
 * 2. создать массив покупателей, массив товаров и массив заказов;
 * 3. создать статический метод “совершить покупку” со строковыми
 * параметрами, соответствующими полям объекта заказа. Метод
 * должен вернуть объект заказа
 * 4. Если в метод передан несуществующий покупатель, товар или
 * отрицательное количество, метод должен выбросить
 * соответствующее исключение;
 * 5. Вызвать метод совершения покупки несколько раз таким образом,
 * чтобы заполнить массив покупок возвращаемыми значениями.
 * Обработать исключения.
 * 6. Вывести в консоль итоговое количество совершённых покупок после
 * выполнения приложения.
 */


public class Main {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Dan", "-", "Ivanov", Gender.valueOf("Male"),
                LocalDate.of(1985,01,13), null, 896324852);
        Customer customer2 = new Customer("Danis", "Muu", "-", Gender.valueOf("Male"),
                LocalDate.of(1979,02,11), null, 896324852);
        Customer customer3 = new Customer("Daria", "Sinitsyna", "-", Gender.valueOf("Female"),
                LocalDate.of(1965,03,01), null, 896324852);
        Customer customer4 = new Customer("Anna", "Kurochkina", "-", Gender.valueOf("Female"),
                LocalDate.of(1975,04,10), null, 896324852);
        //not in registry list of customers
        Customer customer5 = new Customer("Summer", "Smith", "-", Gender.valueOf("Female"),
                LocalDate.of(1995,05,01), null, 896324852);


        Product product1 = new Product("Computer", 200_000);
        Product product2 = new Product("Processor", 50_000);
        Product product3 = new Product("Computer mouse", 20_000);
        Product product4 = new Product("Chair", 20_000);
        Product product5 = new Product("Table", 25_000);
        //not in registry list of products
        Product product6 = new Product("Computer table", 35_000);

        List<Customer> customers = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        orders.add(new Order(customer1, product1, 150));
        orders.add(new Order(customer2, product2, 90));
        orders.add(new Order(customer5, product3, 30));
        orders.add(new Order(customer4, product4, 90));
        orders.add(new Order(customer2, product6, 10));
        orders.add(new Order(customer5, product1, 150));

       for(int i = 0; i < orders.size(); i++){
           try{
               Order.checkOrder(orders.get(i), customers, products);
           }catch (CustomerException e){
               System.out.println(e.getMessage());
           }catch (ProductException e){
               System.out.println(e.getMessage());
           }catch (AmountException e){
               System.out.println(e.getMessage());
           }

       }

        System.out.println("Customers: ");
        for(Customer customer : customers){
            System.out.println(customer);
        }

        System.out.println("Products: ");
        for(Product product : products){
            System.out.println(product);
        }

        celebrateHolidays(customers);


    }

    public static void celebrateHolidays(List<Customer> customers){

        for(Customer customer : customers){
            if(customer.getGender().equals(Gender.Female)){
                System.out.println(String.format("Dear %s, Be brave! Woman, you are important part our society!\n" +
                        "Your work is important for this world!", customer.getName()) + "\n");
            } else if (customer.getGender().equals(Gender.Male)) {
                System.out.println(String.format("Dear %s, Happy 23rd Of February!", customer.getName()) + "\n");
            }else{
                System.out.println("Happy New Year! Be kind, calm, healthy and happy! \n");
            }
        }
    }

}
