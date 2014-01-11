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
		double totalAmout = 0;
		int frequentRenterPointers = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		String result = getName() + " ������ �뿩 ���\n";
		
		while (rentals.hasMoreElements()) {
			
			Rental each = (Rental)rentals.nextElement();			
			
			frequentRenterPointers += each.getPoint(each);
			
			//�̹��� �뿩�ϴ� ���� ������ �뿩�Ḧ ���
			result += "\t" + each.getMovie().getTitle()+"\t"+ String.valueOf(each.getCharge(each)) + "\n";
			
			//������� ������ �� �뿩��
			totalAmout += each.getCharge(each);
		}
		
		//Ǫ�� �� �߰�
		result += "���� �뿩�� : " + String.valueOf(totalAmout) + "\n";
		result += "���� ����Ʈ : " + String.valueOf(frequentRenterPointers);
		return result;	
		
				
	}

	

	
	
	
	
}
