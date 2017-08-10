package com.scrumtrek.simplestore.demo;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Mockito.mock;

public class CustomerTest {
    @Test
    public void shouldHaveNameWhenCreate() {
        //region Given
        String customerName = "stub";
        Customer sut = new Customer(customerName);
        //region

        //region When
        //region

        //region Then
        Assert.assertSame(sut.getName(), customerName);
        //region
    }

    @Test
    public void shouldContainMovieWhenAddRental() {
        String movieName = "stub";
        Movie movie = new Movie(movieName, PriceCodes.Regular);
        assumeTrue(movieName.equals(movie.getTitle()));
        Rental rental = new Rental(movie, 0);
        Customer sut = new Customer("");

        sut.addRental(rental);

        assertTrue(sut.Statement().contains(movieName));
    }

    @Test
    public void shouldHaveCorrectPriceWhenChildrenRentalAdd()
    {
        String movieName = "stub";
        Movie movie = new Movie(movieName, PriceCodes.Regular);
        assumeTrue(movieName.equals(movie.getTitle()));
        Rental rental = new Rental(movie, 4);
        Customer sut = new Customer("");

        sut.addRental(rental);

        String ChildrenPriceForFourDays = movie.getTitle() + "\t3";
        assertTrue(sut.Statement().contains(ChildrenPriceForFourDays));
    }

//    @Test
//    public void shouldHaveCorrectAmountWhenAddRegularRental()
//    {
//        //mock();
//    }

    @Test
    public void shouldHaveCorrectPriceWhenAddXxxRental()
    {
        String movieName = "stub";
        Movie movie = new Movie(movieName, PriceCodes.XXX);
        assumeTrue(movieName.equals(movie.getTitle()));
        Rental rental = new Rental(movie, 1);
        Customer sut = new Customer("");

        sut.addRental(rental);

        String XxxPriceForOneDay = movie.getTitle() + "\t1.9"; // Regular-5%
        assertTrue(sut.Statement().contains(XxxPriceForOneDay));
    }

//    @Test
//    public void shouldHaveCorrectRenterPointsWhenAddXxxRental()
//    {
//        String XxxRentalPointsForOneDay = "1.1"; // Regular+10%
//        assertTrue(sut.Statement().contains(XxxRentalPointsForOneDay));
//    }
}
