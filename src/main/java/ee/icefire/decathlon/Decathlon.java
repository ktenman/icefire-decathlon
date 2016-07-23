package ee.icefire.decathlon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Decathlon {
	private final List<Athlete> athletes = new ArrayList<>();
	Decathlon(String fileName) {
		try {
			List<String> athleteResults = Files.lines(Paths.get(fileName)).collect(toList());

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

			printResults();

		} catch (IOException e) {
			System.out.println("Something is wrong with input file.");
		}
	}

	private void printResults() {
		athletes.forEach(System.out::println);
	}
}
