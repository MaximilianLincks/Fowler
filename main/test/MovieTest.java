import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {
    Movie testmovie;

    @BeforeEach
    void setUp() {
        String title = "Testmovie";
        MovieType priceCode = MovieType.REGULAR;
        testmovie = new Movie(title, priceCode);
    }

    @Test
    void getPriceCode() {
        assertEquals(MovieType.REGULAR, testmovie.getPriceCode());
    }

    @Test
    void setPriceCode() {
        testmovie.setPriceCode(MovieType.REGULAR);
        assertEquals(MovieType.REGULAR, testmovie.getPriceCode());
    }

    @Test
    void getTitle() {
        assertEquals("Testmovie", testmovie.getTitle());
    }
}