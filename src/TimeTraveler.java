public interface TimeTraveler {
	
	String getName();

	double getRemainingYearsOfTravel();

	void adjust(Time unit, int amount, boolean ahead);

}