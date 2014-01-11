import static org.junit.Assert.*;

import org.junit.Test;


public class CustomerTest {

	@Test
	public void testAddRental() {
		Customer c1 = new Customer("ȫ�浿");
		Rental expected = new Rental(new Movie("ȯ��", Movie.CHILDRENS), 2);
		c1.addRental( expected );
		
		assertEquals(expected, c1._rentals.elementAt(0));		
	}

	@Test
	public void testGetName() {
		Customer c1 = new Customer("ȫ�浿");
		assertEquals("ȫ�浿", c1.getName());
	}

	@Test
	public void testStatement() {
		Movie m1 = new Movie("���", Movie.REGULAR);
		Rental r1 = new Rental(m1, 3);		
		Customer c1 = new Customer("ȫ�浿");
		c1.addRental(r1);
		
		
		String result = c1.statement();
		String expect = "ȫ�浿 ������ �뿩 ���\n"   + 
						"\t" + "���" + "\t" + "3.5\n" +
						"���� �뿩�� : " + "3.5\n" + 
						"���� ����Ʈ : " + "1";
		
		assertEquals(expect, result);				
	}
	
	@Test
	public void testStatement2() {
		
		Movie m1 = new Movie("���", Movie.REGULAR);
		Movie m2 = new Movie("����", Movie.NEW_RELEASE);

		Rental r1 = new Rental(m1, 3);
		Rental r2 = new Rental(m2, 2);			
		
		Customer c1 = new Customer("ȫ�浿");
		
		c1.addRental(r1);
		c1.addRental(r2);
		
		
		String result = c1.statement();
		String expect = "ȫ�浿 ������ �뿩 ���\n"   + 
						"\t" + "���" + "\t" + "3.5\n" +
						"\t" + "����" + "\t" + "6.0\n" +
						"���� �뿩�� : " + "9.5\n" + 
						"���� ����Ʈ : " + "3";

		
		assertEquals(expect, result);				
	}

}
