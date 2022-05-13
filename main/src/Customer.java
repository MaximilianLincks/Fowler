
import java.lang.*;
import java.util.*;

class Customer {
    private final String name;

    private final List<Rental> rentals = new ArrayList<>();

    public Customer (String newname){
        name = newname;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }
    public String getName (){
        return name;
    }
    public String statement() {

        double totalAmount = rentals.stream()
                .mapToDouble(RentalPrice::getPrice)
                .sum();

        long frequentRenterPoints = rentals.size() +
                // add bonus for a two day new release rental
                rentals.stream()
                        .filter(rental -> rental.getDaysRented() > 1)
                        .filter(rental -> rental.getMovie().getPriceCode() == MovieType.NEW_RELEASE)
                        .count();

        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n")
                .append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        rentals.stream()
                        .map(rental -> "\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + RentalPrice.getPrice(rental) + "\n")
                        .forEach(result::append);

        //add footer lines
        result.append("Amount owed is ").
                append(totalAmount).
                append("\n").
                append("You earned ").
                append(frequentRenterPoints).
                append(" frequent renter points");

        return result.toString();
    }



}
    