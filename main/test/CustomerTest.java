
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        String customerName = "John";
        customer = new Customer(customerName);
    }

    @Test
    void addRental() {
        Rental rental = new Rental(new Movie("Test movie",MovieType.NEW_RELEASE), 3);
        customer.addRental(rental);
        // Assertions.assertEquals(1,customer1.rentals.size());
        //Can't be tested before touching the code
    }

    @Test
    void getName() {
        Assertions.assertEquals("John", customer.getName());

    }

    @Test
    void statement() {
        customer.addRental(new Rental(new Movie("childrens", MovieType.CHILDREN), 5));
        customer.addRental(new Rental(new Movie("regular", MovieType.REGULAR), 3));
        customer.addRental(new Rental(new Movie("new release", MovieType.NEW_RELEASE), 10));
        Assertions.assertTrue(customer.statement().contains("for John"));
        Assertions.assertTrue(customer.statement().contains("childrens" + "\t" + "\t" + 5 + "\t" + "4.5"));
        Assertions.assertTrue(customer.statement().contains("regular" + "\t" + "\t" + 3 + "\t" + "3.5"));
        Assertions.assertTrue(customer.statement().contains("new release" + "\t" + "\t" + 10 + "\t" + "30.0"));

    }
}