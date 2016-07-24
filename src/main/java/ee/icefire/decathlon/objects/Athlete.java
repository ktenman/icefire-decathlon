package ee.icefire.decathlon.objects;

public class Athlete {

	private final String name;
	private Integer finalScore;

	public Athlete(String name) {
		this.name = name;
		this.finalScore = 0;
	}

	public void addEventPoints(int eventPoints) {
		finalScore += eventPoints;
	}

	@Override
	public String toString() {
		return String.format("%-16s (%d)", name, finalScore);
	}
}
