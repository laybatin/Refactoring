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
			double thisAmount = 0;
			Rental each = (Rental)rentals.nextElement();
			
			thisAmount = each.getCharge(each);
			
			//���� ����Ʈ�� 1����Ʈ ����
			frequentRenterPointers++;
			
			//�ֽŹ��� ��Ʋ �̻� �뿩�ϸ� ���ʽ� ����Ʈ ����
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPointers++;
			
			//�̹��� �뿩�ϴ� ���� ������ �뿩�Ḧ ���
			result += "\t" + each.getMovie().getTitle()+"\t"+ String.valueOf(thisAmount) + "\n";
			
			//������� ������ �� �뿩��
			totalAmout += thisAmount;
		}
		
		//Ǫ�� �� �߰�
		result += "���� �뿩�� : " + String.valueOf(totalAmout) + "\n";
		result += "���� ����Ʈ : " + String.valueOf(frequentRenterPointers);
		return result;	
		
				
	}

	
	
	
	
}
