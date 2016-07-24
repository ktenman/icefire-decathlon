package ee.icefire.decathlon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Decathlon {

	private final List<Athlete> athletes = new ArrayList<>();
	private final String fileName;
	private List<String> athleteResults;

	Decathlon(String fileName) {
		this.fileName = fileName;
		getAthleteResultsFromFile();
		if (validDataFound()) {
			calculatePointsOfAthletes();
			printResults();
		} else {
			System.exit(0);
		}
	}

	private void getAthleteResultsFromFile() {
		try {
			athleteResults = Files.lines(Paths.get(fileName)).collect(toList());
		} catch (IOException e) {
			System.out.println("Something is wrong with input file.");
			System.exit(0);
		}
	}

	private boolean validDataFound() {
		StringBuilder error = new StringBuilder("Please check your file.\n\nRequirments:\n");
		boolean validDataFound = true;
		if (noResultFound()) {
			error.append("* There must be at least one result.\n");
			validDataFound = false;
		}
		if (resultInWrongFormatExists()) {
			error.append("* There is a result in wrong format.\n");
			validDataFound = false;
		}
		if (!validDataFound) {
			System.out.print(error);
		}
		return validDataFound;
	}

	private boolean resultInWrongFormatExists() {
//		Nimi;10,2;790;18,75;217;46,00;13,70;57,50;478;81,00;3:40,2
		for (String athleteResult : athleteResults) {
			String[] columns = athleteResult.split(";");
			if (columns.length != 11) {
				return true;
			}
			for (int i = 1; i < columns.length; i++) {
				try {
					PerformanceParser.parsePerformanceToFloat(columns[i]);
				} catch (Exception e) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean noResultFound() {
		return athleteResults.size() == 0;
	}

	private void calculatePointsOfAthletes() {
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
