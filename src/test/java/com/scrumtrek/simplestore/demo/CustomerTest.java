package com.scrumtrek.simplestore.demo;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CustomerTest {
    @Test
    public void shouldBeEmptyNameWhenCreate()
    {
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
    public void shouldContainMovieWhenAdd()
    {
        String movieName = "stub";
        Movie movie = new Movie(movieName, PriceCodes.NewRelease);
        Rental rental = new Rental(movie, 0);
        Customer sut = new Customer("");

        sut.addRental(rental);

        assertTrue(sut.Statement().contains(movieName));
    }
}
