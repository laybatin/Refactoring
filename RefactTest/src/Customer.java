import java.util.Enumeration;
import java.util.Vector;


public class Customer {
	private String _name;
	protected Vector<Rental> _rentals = new Vector<>();
	
	public Customer(String name)
	{
		_name = name;
	}
	
	public void addRental(Rental arg)
	{
		_rentals.addElement(arg);
	}
	
	public String getName()
	{
		return _name;
	}
	
	
	public String statement()
	{
		
		
		Enumeration<Rental> rentals = _rentals.elements();
		String result = getName() + " ������ �뿩 ���\n";
		
		while (rentals.hasMoreElements()) {
			
			Rental each = (Rental)rentals.nextElement();			
			
			
			
			//�̹��� �뿩�ϴ� ���� ������ �뿩�Ḧ ���
			result += "\t" + each.getMovie().getTitle()+"\t"+ String.valueOf(each.getCharge(each)) + "\n";
			
			
		}
		
		//Ǫ�� �� �߰�
		result += "���� �뿩�� : " + String.valueOf(getTotalCharge()) + "\n";
		result += "���� ����Ʈ : " + String.valueOf(getTotalFrequentRenterPoints());
		return result;	
		
				
	}

	private int getTotalFrequentRenterPoints() {
		int frequentRenterPointers = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental)rentals.nextElement();
			frequentRenterPointers += each.getPoint(each);
		}		
		return frequentRenterPointers;
	}
	
	private double getTotalCharge()
	{
		//������� ������ �� �뿩��
		double result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental)rentals.nextElement();
			result += each.getCharge(each);
		}
		return result;
	}
	
	

	

	
	
	
	
}
