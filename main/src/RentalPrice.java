public class RentalPrice {

    public static double getPrice(Rental rental){
        return switch (rental.getMovie().getPriceCode()) {
            case REGULAR -> getRegularPrice(rental);
            case NEW_RELEASE -> getNew_ReleasePrice(rental);
            case CHILDREN -> getChildPrice(rental);
        };
    }

    private static double getChildPrice(Rental rental){
        return 1.5 + ((rental.getDaysRented() > 3) ? (rental.getDaysRented() - 3) * 1.5 : 0);
    }

    private static double getNew_ReleasePrice(Rental rental){
        return rental.getDaysRented() * 3;
    }

    private static double getRegularPrice(Rental rental){
        return 2.0 + (rental.getDaysRented() > 2 ? (rental.getDaysRented() - 2) * 1.5 : 0);

    }
}
