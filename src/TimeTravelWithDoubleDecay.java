public class TimeTravelWithDoubleDecay extends TimeTravelWithDecay {
	
	public TimeTravelWithDoubleDecay(String name) {
		super(name);
	}

	@Override
	public void adjust(Time unit, int amount, boolean ahead) {
		double tempAmount = (double) amount * 2d;
		switch (unit) {
			case Hours:
				remainingYears -= tempAmount / (365d * 24d);
				break;
			default:
				remainingYears -= tempAmount / 365d;
		}
		if (remainingYears <= 1e-15d) {
			remainingYears = 0d;
		}
	}
}