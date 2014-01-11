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
			double thisAmount = 0;
			Rental each = (Rental)rentals.nextElement();
			
			thisAmount = each.getCharge(each);
			
			//적립 포인트를 1포인트 증가
			frequentRenterPointers++;
			
			//최신물을 이틀 이상 대여하면 보너스 포인트 지급
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPointers++;
			
			//이번에 대여하는 비디오 정보와 대여료를 출력
			result += "\t" + each.getMovie().getTitle()+"\t"+ String.valueOf(thisAmount) + "\n";
			
			//현재까지 누적된 총 대여료
			totalAmout += thisAmount;
		}
		
		//푸터 행 추가
		result += "누적 대여료 : " + String.valueOf(totalAmout) + "\n";
		result += "적립 포인트 : " + String.valueOf(frequentRenterPointers);
		return result;	
		
				
	}

	
	
	
	
}
