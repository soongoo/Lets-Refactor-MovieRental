package com.letsdeveloper.refactoring.movierental.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.letsdeveloper.refactoring.movierental.Customer;
import com.letsdeveloper.refactoring.movierental.Movie;
import com.letsdeveloper.refactoring.movierental.Rental;

public class CustomerTest {

	@Test
	public void 렌탈하지_않으면_비어있는_명세서출력() {
		Customer uut = new Customer("Bob");

		String expected = "Rental Record for Bob\n"
				+ "Amount owed is 0.0\n"
				+ "You earned 0 frequent renter points";
		String actual = uut.statement();

		assertEquals(expected, actual);
	}
	@Test
	public void 일반영화_단기렌탈_명세서출력() {
		Customer uut = new Customer("Alice");
		uut.addRental(new Rental(new Movie("Spiderman", Movie.REGULAR), 1));

		String expected = "Rental Record for Alice\n"
				+ "\tSpiderman\t2.0\n"
				+ "Amount owed is 2.0\n"
				+ "You earned 1 frequent renter points";
		String actual = uut.statement();

		assertEquals(expected, actual);
	}
	
	
	@Test
	public void 일반영화_장기렌탈_명세서출력() {
		Customer uut = new Customer("Alice");
		uut.addRental(new Rental(new Movie("Batman", Movie.REGULAR), 3));

		String expected = "Rental Record for Alice\n"
				+ "\tBatman\t3.5\n"
				+ "Amount owed is 3.5\n"
				+ "You earned 1 frequent renter points";
		String actual = uut.statement();

		assertEquals(expected, actual);
	}
	
	@Test
	public void 신간영화_단기렌탈_명세서출력() {
		Customer uut = new Customer("Charly");
		uut.addRental(new Rental(new Movie("X-Men", Movie.NEW_RELEASE), 1));

		String expected = "Rental Record for Charly\n"
				+ "\tX-Men\t3.0\n"
				+ "Amount owed is 3.0\n"
				+ "You earned 1 frequent renter points";
		String actual = uut.statement();

		assertEquals(expected, actual);
	}
	
	@Test
	public void 신간영화_장기렌탈_추가포인트적립_명세서출력() {
		Customer uut = new Customer("Charly");
		uut.addRental(new Rental(new Movie("X-Men 2", Movie.NEW_RELEASE), 3));

		String expected = "Rental Record for Charly\n"
				+ "\tX-Men 2\t9.0\n"
				+ "Amount owed is 9.0\n"
				+ "You earned 2 frequent renter points";
		String actual = uut.statement();

		assertEquals(expected, actual);
	}
	
	@Test
	public void 아동영화_단기렌탈_명세서출력() {
		Customer uut = new Customer("Emma");
		uut.addRental(new Rental(new Movie("Fantastic Four", Movie.CHILDRENS), 1));

		String expected = "Rental Record for Emma\n"
				+ "\tFantastic Four\t1.5\n"
				+ "Amount owed is 1.5\n"
				+ "You earned 1 frequent renter points";
		String actual = uut.statement();

		assertEquals(expected, actual);
	}
	
	@Test
	public void 아동영화_장기렌탈_명세서출력() {
		Customer uut = new Customer("Emma");
		uut.addRental(new Rental(new Movie("Lion King", Movie.CHILDRENS), 4));

		String expected = "Rental Record for Emma\n"
				+ "\tLion King\t3.0\n"
				+ "Amount owed is 3.0\n"
				+ "You earned 1 frequent renter points";
		String actual = uut.statement();

		assertEquals(expected, actual);
	}
	
	@Test
	public void 복수장르_복수렌탈_명세서출력() {
		Customer uut = new Customer("Hugo");
		uut.addRental(new Rental(new Movie("Robin Hood", Movie.CHILDRENS), 3));
		uut.addRental(new Rental(new Movie("V for Vendetta", Movie.REGULAR), 5));

		String expected = "Rental Record for Hugo\n"
				+ "\tRobin Hood\t1.5\n"
				+ "\tV for Vendetta\t6.5\n"
				+ "Amount owed is 8.0\n"
				+ "You earned 2 frequent renter points";
		String actual = uut.statement();

		assertEquals(expected, actual);
	}
}
