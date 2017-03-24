import java.lang.Math.*;

public class TimeTravelWithExDecay extends TimeTravelWithDecay {
	
	private final double decayConstant;
	private final double initialRemain;

	public TimeTravelWithExDecay(String name, double decayConstant) {
		super(name);
		this.decayConstant = decayConstant;
		this.initialRemain = this.remainingYears;
	}

	@Override
	public void adjust(Time unit, int amount, boolean ahead) {
		double tempAmount = decayConstant * amount;
		switch (unit) {
			case Hours:
				remainingYears = initialRemain * Math.exp(0d - tempAmount / (365d * 24d));
				break;
			default:
				remainingYears = initialRemain * Math.exp(0d - tempAmount / 365d);
				break;
		}
		if (remainingYears <= 1e-15d) {
			remainingYears = 0d;
		}
	}

}