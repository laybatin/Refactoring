
public class Rental {
	
	private Movie _movie;
	private int _daysRented;
	
	public Rental(Movie movie, int daysRented)
	{
		_movie = movie;
		_daysRented = daysRented;
	}
	
	public int getDaysRented()
	{
		return _daysRented;
	}
	
	public Movie getMovie()
	{
		return _movie;
	}
	
	public double getCharge(Rental aRental) {
		double result = 0;
		//비디오 종류별 대여료 계산
		switch (aRental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (aRental.getDaysRented() > 2)
				result += (aRental.getDaysRented() - 2) * 1.5;
			break;
			
		case Movie.NEW_RELEASE:
			result += aRental.getDaysRented() * 3;
			break;
			
		case Movie.CHILDRENS:
			result += 1.5;
			if (aRental.getDaysRented() > 3)
				result += (aRental.getDaysRented() - 3) * 1.5;
			break;
		}
		return result;
	}
	
	public int getPoint(Rental each) {

		int frequentRenterPointers = 0;
		
		//적립 포인트를 1포인트 증가
		frequentRenterPointers++;
		
		//최신물을 이틀 이상 대여하면 보너스 포인트 지급
		if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
			frequentRenterPointers++;
		
		return frequentRenterPointers;
	}

}
