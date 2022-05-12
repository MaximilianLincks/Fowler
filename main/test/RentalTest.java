import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {
    private Movie testMovie;
    private Rental testRental;

    @BeforeEach
    void setUp() {
        testMovie = new Movie("Testmovie", 0);
        int daysRented = 3;
        testRental = new Rental(testMovie, daysRented);
    }

    @Test
    void getDaysRented() {
        assertEquals(3, testRental.getDaysRented());
    }

    @Test
    void getMovie() {
        assertSame(testMovie.getTitle(), testRental.getMovie().getTitle());
        assertEquals(testMovie.getPriceCode(), testRental.getMovie().getPriceCode());
    }
} 