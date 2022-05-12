import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {
    Movie testmovie;

    @BeforeEach
    void setUp() {
        String title = "Testmovie";
        int priceCode = 0;
        testmovie = new Movie(title, priceCode);
    }

    @Test
    void getPriceCode() {
        assertEquals(0, testmovie.getPriceCode());
    }

    @Test
    void setPriceCode() {
        testmovie.setPriceCode(0);
        assertEquals(0, testmovie.getPriceCode());
    }

    @Test
    void getTitle() {
        assertEquals("Testmovie", testmovie.getTitle());
    }
}