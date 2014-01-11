import static org.junit.Assert.*;

import org.junit.Test;


public class CustomerTest {

	@Test
	public void testAddRental() {
		Customer c1 = new Customer("È«±æµ¿");
		Rental expected = new Rental(new Movie("È¯»ó", Movie.CHILDRENS), 2);
		c1.addRental( expected );
		
		assertEquals(expected, c1._rentals.elementAt(0));		
	}

	@Test
	public void testGetName() {
		Customer c1 = new Customer("È«±æµ¿");
		assertEquals("È«±æµ¿", c1.getName());
	}

	@Test
	public void testStatement() {
		Movie m1 = new Movie("½î¿ì", Movie.REGULAR);
		Rental r1 = new Rental(m1, 3);		
		Customer c1 = new Customer("È«±æµ¿");
		c1.addRental(r1);
		
		
		String result = c1.statement();
		String expect = "È«±æµ¿ °í°´´ÔÀÇ ´ë¿© ±â·Ï\n"   + 
						"\t" + "½î¿ì" + "\t" + "3.5\n" +
						"´©Àû ´ë¿©·á : " + "3.5\n" + 
						"Àû¸³ Æ÷ÀÎÆ® : " + "1";
		
		assertEquals(expect, result);				
	}
	
	@Test
	public void testStatement2() {
		
		Movie m1 = new Movie("½î¿ì", Movie.REGULAR);
		Movie m2 = new Movie("°ü»ó", Movie.NEW_RELEASE);

		Rental r1 = new Rental(m1, 3);
		Rental r2 = new Rental(m2, 2);			
		
		Customer c1 = new Customer("È«±æµ¿");
		
		c1.addRental(r1);
		c1.addRental(r2);
		
		
		String result = c1.statement();
		String expect = "È«±æµ¿ °í°´´ÔÀÇ ´ë¿© ±â·Ï\n"   + 
						"\t" + "½î¿ì" + "\t" + "3.5\n" +
						"\t" + "°ü»ó" + "\t" + "6.0\n" +
						"´©Àû ´ë¿©·á : " + "9.5\n" + 
						"Àû¸³ Æ÷ÀÎÆ® : " + "3";

		
		assertEquals(expect, result);				
	}

}
