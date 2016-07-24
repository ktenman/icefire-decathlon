package ee.icefire.decathlon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Decathlon {

	private List<String> athleteResults;
	private final List<Athlete> athletes = new ArrayList<>();

	Decathlon(String fileName) {
		try {
			athleteResults = Files.lines(Paths.get(fileName)).collect(toList());

		} catch (IOException e) {
			System.out.println("Something is wrong with input file.");
		}
		calculatePoints(athleteResults);
		printResults();
	}

	private void calculatePoints(List<String> athleteResults) {
		for (String athleteResult : athleteResults) {
			String[] columns = athleteResult.split(";");
			String name = columns[0];
			Athlete athlete = new Athlete(name);
			for (int i = 1; i < columns.length; i++) {
				athlete.addEventPoints(PointsCalculator.calculatePoints(i, PerformanceParser
					.parsePerformanceToFloat(columns[i])));
			}
			athletes.add(athlete);
		}
	}

	private void printResults() {
		athletes.forEach(System.out::println);
	}
}
