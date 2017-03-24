public abstract class TimeTravelWithDecay implements TimeTraveler {
	private final String name;
	protected double remainingYears;

	public TimeTravelWithDecay(String name) {
		this.name = name;
		this.remainingYears = 5d;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getRemainingYearsOfTravel() {
		return remainingYears;
	}
}