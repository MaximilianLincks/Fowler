public class Movie {
    private String title;
    private MovieType priceCode;

    public Movie(String newtitle, MovieType newpriceCode) {
        title = newtitle;
        priceCode = newpriceCode;
    }
    public MovieType getPriceCode() {
        return priceCode;
    }
    public void setPriceCode(MovieType priceCode) {
        this.priceCode = priceCode;
    }
    public String getTitle (){
        return title;
    };
}