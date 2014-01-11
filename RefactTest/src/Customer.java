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
		String result = getName() + " 고객님의 대여 기록\n";
		
		while (rentals.hasMoreElements()) {
			
			Rental each = (Rental)rentals.nextElement();			
			
			frequentRenterPointers += each.getPoint(each);
			
			//이번에 대여하는 비디오 정보와 대여료를 출력
			result += "\t" + each.getMovie().getTitle()+"\t"+ String.valueOf(each.getCharge(each)) + "\n";
			
			//현재까지 누적된 총 대여료
			totalAmout += each.getCharge(each);
		}
		
		//푸터 행 추가
		result += "누적 대여료 : " + String.valueOf(totalAmout) + "\n";
		result += "적립 포인트 : " + String.valueOf(frequentRenterPointers);
		return result;	
		
				
	}

	

	
	
	
	
}
