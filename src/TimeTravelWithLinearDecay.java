public class TimeTravelWithLinearDecay extends TimeTravelWithDecay {
	
	public TimeTravelWithLinearDecay(String name) {
		super(name);
	}

	@Override
	public void adjust(Time unit, int amount, boolean ahead) {
		switch (unit) {
			case Hours:
				remainingYears -= (int) amount / (365d * 24d);
				break;
			default:
				remainingYears -= (int) amount / 365d;
		}
		if (remainingYears <= 1e-15d) {
			remainingYears = 0d;
		}
	}
}