package ee.icefire.decathlon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Decathlon {
	Decathlon(String fileName) {
		try {
			List<String> athleteResults = Files.lines(Paths.get(fileName)).collect(toList());
			for (String athleteResult : athleteResults) {
				String[] values = athleteResult.split(";");
				String name = values[0];
				Athlete athlete = new Athlete(name);
				for (int i = 1; i < values.length; i++) {
					athlete.addEventPoints(PointsCalculator.calculatePoints(i, PerformanceParser
						.parsePerformanceToFloat(values[i])));
				}
				System.out.println(athlete.toString());
			}
		} catch (IOException e) {
			System.out.println("Something is wrong with input file.");
		}
	}
}
