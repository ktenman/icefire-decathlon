package ee.icefire.decathlon;

class Athlete {

	private final String name;
	private Integer finalScore;

	Athlete(String name) {
		this.name = name;
		this.finalScore = 0;
	}

	void addEventPoints(int eventPoints) {
		finalScore += eventPoints;
	}

	@Override
	public String toString() {
		return String.format("%-16s (%d)", name, finalScore);
	}
}
