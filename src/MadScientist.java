public class MadScientist {
	private final TimeMachine timeMachine;

	public MadScientist(TimeMachine timeMachine) {
		this.timeMachine = timeMachine;
	}

	public void experiment(TimeTraveler timeTraveler) {
		final TimeTraveler finalTimeTraveler = timeTraveler;
		timeMachine.travel(finalTimeTraveler, new TimeTravelCallback() {
			@Override
			public void leaped(Time unit, int amount, boolean ahead) {
				finalTimeTraveler.adjust(unit, amount, ahead);
				System.out.print(finalTimeTraveler.getName() + " travels " + amount + " " + unit + " in the");
				if (ahead) {
					System.out.print(" future, ");
				} else {
					System.out.print(" past, ");
				}
				if (finalTimeTraveler.getRemainingYearsOfTravel() > 0d) {
					System.out.println(finalTimeTraveler.getRemainingYearsOfTravel() + " years left.");
					experiment(finalTimeTraveler);
				} else {
					System.out.println(" 0 years left.");
				}
			}
		});
	}

	public static void main(String[] args) {
		TimeMachine timeMachine = new TimeMachine();
		MadScientist madScientist = new MadScientist(timeMachine);

		if (args[0].equals("linear")) {
			TimeTravelWithLinearDecay linearDecay = new TimeTravelWithLinearDecay(args[1]);
			System.out.println("With linear decay:");
			madScientist.experiment(linearDecay);
		} else if (args[0].equals("double")) {
			TimeTravelWithDoubleDecay doubleDecay = new TimeTravelWithDoubleDecay(args[1]);
			System.out.println("With double decay:");
			madScientist.experiment(doubleDecay);
		} else if (args[0].equals("expo")) {
			TimeTravelWithExDecay exDecay = new TimeTravelWithExDecay(args[1], Double.parseDouble(args[2]));
			System.out.println("With exponential decay:");
			madScientist.experiment(exDecay);
		} else {
			System.out.println("Invalid input! Try again!");
		}
	}
}